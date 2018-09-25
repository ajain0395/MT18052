package a3_ASHISH_MT18052;

import java.util.ArrayList;


public class User implements Journey {
	
	String username;
	String fullName;
	String ph_number;
	ArrayList<Journey_details> history = new ArrayList<>();
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String fullname, String name,String number) {
		// TODO Auto-generated constructor stub
		this.setFullName(fullname);
		this.setUsername(name);
		this.setPh_number(number);
	}
	
	Journey_details newTrip(String source,String destination,String date,Company company)
	{	
		Journey_details jd = new Journey_details();
		jd.setSource(source);
		jd.setDestination(destination);
		jd.setMedium(company);
		jd.setDate(Integer.parseInt(date));
		float fare = 0;
		boolean flag = true;
		int disc = 0;
		while(flag)
		{
		System.out.println("1. Apply Coupon and Checkout\n2. Checkout");
		int ch = Integer.parseInt(Main_System.sc.nextLine());
		switch(ch)
		{
		case 1:
			disc = company.select_code();
			System.out.println("Discount Percentage Selected "+ disc);
		case 2:
			fare = (float) (company.getFare() - company.getFare()*((float)disc/100.0));
			jd.setCost(fare);
		//	history.add(jd);
			flag = false;
			break;
		default:
				break;
		}
		}
		jd.setCost(fare);
		//history.add(new Journey_details());
		return jd;
	}
	void display_user()
	{
		System.out.print("\t\t"+getFullName() + "\t\t"+getUsername()+ "\t\t"+ getPh_number() + "\n");
		System.out.println("Trips");
		show_trips();
	}
	void user_menu()
	{
		
		
		boolean flag = true;
		
		while(flag)
		{
			System.out.println("1. Show Trips\n2. New Trip\n3. Cancel Trip\n4. Logout");
			int ch = Main_System.nextint();
			switch(ch)
			{
			case 1:
				show_trips();
				break;
			case 2:
				String source,destination,date;
				System.out.print("Enter Source: ");
				source = Main_System.sc.nextLine();
				System.out.print("Enter Destination: ");
				destination = Main_System.sc.nextLine();
				
				while(true)
				{
				System.out.print("Enter Date(eg: 01 or 23 etc.): ");
				date = Main_System.sc.nextLine();
					if(date.length() != 2 || Integer.parseInt(date) > 31 || Integer.parseInt(date) < 1)
					{
						System.out.println("Invalid date");
					}
					else
					{
						break;
					}
				}
				//flag = false;
				planner(source, destination, date);
				break;
			case 3:
				cancel_trip();
				break;
			case 4:
				flag = false;
			//	return;
				break;
				default:
					System.out.println("Invalid choice");
					break;
			}
		}
		
		
	}
	void cancel_trip()
	{
		boolean flag = true;
		
		while(flag && history.size()>0)
			{
			System.out.println("0. To return to previous menu");
			show_trips();
			System.out.print("Enter Trip to be cancelled: ");
			int ind = Main_System.nextint();
			if(ind >history.size() || ind < 0)
			{
				System.out.println("Invalid Choice");
			}
			else if(ind == 0)
			{
				flag = false;
			}
			else
			{
				ind = ind -1;
				if(history.get(ind).getDate() == Main_System.curr_date)
				{
					System.out.println("Refund amount is 0 as trip is of same day");
				}
				else
				{
					System.out.println("Refund amount is "+ (history.get(ind).getCost() - (float)history.get(ind).getMedium().getCancel_charge()));
				System.out.println("Rs. " +(float)history.get(ind).getMedium().getCancel_charge() + " will be deducted as the cancellation charges");
				}
				System.out.println("Remove Trip (Y/y) to confirm: ");
				String y = Main_System.sc.nextLine();
				if(y.equalsIgnoreCase("y"))
				{
				history.remove(ind);
				}
				else
				{
					System.out.println("Trip not Cancelled");
				}
				break;
			}
			
		}
	}
	void show_trips()
	{
		if(history.isEmpty())
		{
			System.out.println("No Record Found");
		}
		else
		{
			for(int i = 0; i < history.size();i++)
			{
				System.out.println(i + 1 +"\t\t"+
						history.get(i).getSource()
						+"\t\t"+history.get(i).getDestination()
						+"\t\t"+history.get(i).getDate()
						+"\t\t"+history.get(i).getCost()
						+"\t\t"+history.get(i).getMedium().getName()
						);
			}
		}
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPh_number() {
		return ph_number;
	}
	public void setPh_number(String ph_number) {
		this.ph_number = ph_number;
	}
	void choose_air()
	{
		for(int index = 0;index < Main_System.air_mode.size();index++)
		{
			System.out.println((index + 1)+".\t" + Main_System.air_mode.get(index).getName() + "\t\t"+Main_System.air_mode.get(index).getFare());
		}
	}
	
	void choose_bus()
	{
		for(int index = 0;index < Main_System.bus_mode.size();index++)
		{
			System.out.println((index + 1)+".\t" + Main_System.bus_mode.get(index).getName() + "\t\t"+Main_System.bus_mode.get(index).getFare());
		}		
	}
	void choose_train()
	{
		for(int index = 0;index < Main_System.train_mode.size();index++)
		{
			System.out.println((index + 1)+".\t" + Main_System.train_mode.get(index).getName() + "\t\t"+Main_System.train_mode.get(index).getFare());
		}
	}
	
	@Override
	public void planner(String source, String destination, String date) {
		
		boolean flag = true;
		int index;
		while(flag)
		{
			System.out.println("Choose Mode of Travel\n1. Air Mode\n2. Train Mode\n3. Bus Mode");
			int ch = Main_System.nextint();
			switch(ch)
			{
			case 1: 
			while(true)
			{
				choose_air();
				index = Main_System.nextint();
				if(index <1 || index > Main_System.air_mode.size())
				{
					System.out.println("Invalid Input");
				}
				else
				{
					break;
				}
				
			}
			history.add(newTrip(source, destination, date, Main_System.air_mode.get(index -1)));
			flag = false;
			break;
			case 2: 
				while(true)
				{
					choose_train();
					index = Main_System.nextint();
					if(index <1 || index > Main_System.train_mode.size())
					{
						System.out.println("Invalid Input");
					}
					else
					{
						break;
					}
					
				}
				history.add(newTrip(source, destination, date, Main_System.train_mode.get(index -1)));
				flag = false;
				break;
			case 3: 
				while(true)
				{
					choose_bus();
					index = Main_System.nextint();
					if(index <1 || index > Main_System.bus_mode.size())
					{
						System.out.println("Invalid Input");
					}
					else
					{
						break;
					}
					
				}
				history.add(newTrip(source, destination, date, Main_System.bus_mode.get(index -1)));
				flag = false;
				break;
			default:
				break;
			}
		}
		
		
	}

}
