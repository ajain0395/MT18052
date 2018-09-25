package a3_ASHISH_MT18052;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_System {

	public static Scanner sc = new Scanner(System.in);
	
	public static int curr_date = 30;
	public static ArrayList<Air_Mode> air_mode = new ArrayList<>();
	public static ArrayList<Bus_Mode> bus_mode = new ArrayList<>();
	public static ArrayList<Train_Mode> train_mode = new ArrayList<>();
	ArrayList<User> user = new ArrayList<>();
	
	void preregister()
	{
		
		Air_Mode cd = new Air_Mode();
		cd.register_company("SpiceJet", "8965412347", 3500);
		cd.add_coupons(10);
		cd.add_coupons(15);
		air_mode.add(cd);
		cd = new Air_Mode();
		cd.register_company("Indigo Airlines", "6597312347", 2700);
		cd.add_coupons(8);
		cd.add_coupons(11);
		air_mode.add(cd);
		cd = new Air_Mode();
		cd.register_company("Air India", "8968965412", 5000);
		cd.add_coupons(6);
		cd.add_coupons(13);
		air_mode.add(cd);
		cd = new Air_Mode();
		cd.register_company("Vistara Airlines", "6589412347", 4503);
		cd.add_coupons(12);
		cd.add_coupons(6);
		air_mode.add(cd);
		
		
		User usr = new User("Ashish Jain","ajain0395","9711779966");
		usr.history.add(new Journey_details("Delhi","Bangalore",30,cd));
		usr.history.add(new Journey_details("Mumbai","Bangalore",20,cd));
		user.add(usr);
		
	}
	
	public static int nextint()
	{
		return Integer.parseInt('0'+sc.nextLine());
	}
	
	int find_user(String name)
	{
		int index = -1;
		
		for(int i = 0; i < user.size();i++)
		{
			if(user.get(i).getUsername().compareToIgnoreCase(name) == 0)
			{
				index = i;
				break;
			}
		}
		return index;
	}
	int find_train_company(String name)
	{
		int index = -1;
		
		for(int i = 0; i < train_mode.size();i++)
		{
			if(train_mode.get(i).getName().compareToIgnoreCase(name) == 0)
			{
				index = i;
				break;
			}
		}
		return index;
	}
	int find_bus_company(String name)
	{
		int index = -1;
		
		for(int i = 0; i < bus_mode.size();i++)
		{
			if(bus_mode.get(i).getName().compareToIgnoreCase(name) == 0)
			{
				index = i;
				break;
			}
		}
		return index;
	}
	int find_air_company(String name)
	{
		int index = -1;
		
		for(int i = 0; i < air_mode.size();i++)
		{
			if(air_mode.get(i).getName().compareToIgnoreCase(name) == 0)
			{
				index = i;
				break;
			}
		}
		return index;
	}
	User registerUser(String fullname,String username,String number)
	{
		User usr = null;
		int index = -1;
		index = find_user(username);
		if(index == -1)
		{
			usr = new User(fullname,username,number);
		}
		else
		{
			//usr = user.get(index);
			System.out.println("Username already exist");
		}
		return usr;
	}
	
	void company_view()
	{
		boolean flag = true;
		String name,contact;
		float fare;
		while(flag){
			System.out.println("Company Menu\n1. Register Company\n2. Add Coupon\n3. Previous Menu");
			int ch = nextint();
			switch(ch)
			{
			case 1:
			{
				System.out.print("Enter Company Name: ");
				name = sc.nextLine();
				System.out.print("Enter Contact Number: ");
				contact = sc.nextLine();
				System.out.println("Enter Fare");
				fare = nextint();
				newcompany(name,contact,fare);
				flag = false;
				break;
			}
			case 2:
				register_coupon();
				flag = false;
				break;
			case 3:
				flag = false;
				break;
			default:
				System.out.println("Invalid Choice");
				break;
		}
	}
	}
	
	private void register_coupon() {

		boolean flag = true;
		while(flag)
		{
			int index;
			String name = sc.nextLine();
			if(find_air_company(name) !=-1)
			{
				index =find_air_company(name);
				air_mode.get(index).add_coupons();
			}
			else if(find_bus_company(name) !=-1)
			{
				index =find_bus_company(name);
				bus_mode.get(index).add_coupons();
			}
			else if(find_train_company(name) !=-1)
			{
				index =find_train_company(name);
				train_mode.get(index).add_coupons();
			}
			else
			{
				System.out.println("Company not found");
			}
		}
	}

	void newcompany(String name, String number, float fare) {
		// TODO Auto-generated method stub
		boolean flag = true;
while(flag)
{
	
	System.out.println("1. Airline\n2. Bus Service3. Train Serivce");
	int key = nextint();
		switch (key) {
		case 1:
			Air_Mode am = new Air_Mode();
			am.register_company(name, number, fare);
			air_mode.add(am);
			flag = false;
			break;
		case 2:
			Bus_Mode bm = new Bus_Mode();
			bm.register_company(name, number, fare);
			bus_mode.add(bm);
			flag = false;
			break;
		case 3:
			Train_Mode tm = new Train_Mode();
			tm.register_company(name, number, fare);
			train_mode.add(tm);
			flag = false;
			break;
		default:
			break;
		}
}
}

	void User_view()
	{
		String username,fullname,number;
	
		boolean flag = true;
		
		do
		{
			User us =null;
			System.out.println("1. Register\n2. Login\n3. Previous Menu");
			int ch = Integer.parseInt(sc.nextLine());
			switch(ch)
		{
			case 1:
				System.out.print("Enter Name: ");
				fullname = sc.nextLine();
				System.out.print("Enter userame: ");
				username = sc.nextLine();
				System.out.print("Enter Phone Number: ");
				number = sc.nextLine();
				us = registerUser(fullname, username, number);
				if(us == null)
					break;
				else
				{
					user.add(us);
					us=null;
				}
				break;
			case 2:
			{
					System.out.print("Enter userame: ");
					username = sc.nextLine();
					int index = find_user(username);
					if(index == -1)
					{
						System.out.println("Invalid Username");
						break;
					}
					else
					{
						us = user.get(index);
						us.user_menu();
						//flag = false;
					}
				}
				break;
			case 3:
				flag = false;
				break;
			default:
					System.out.println("Invalid Choice");
					break;
		}
	}
		while(flag);

	}
	
	
	public static void main(String[] args) {
		//System.out.println("Running");
		
		Main_System admin = new Main_System();
		admin.preregister();

		boolean flag = true;
		while(flag){
			System.out.println("Choose your role\n1. Admin\n2. Company\n3. User");
			int ch = nextint();
			switch (ch) {
			case 1:
			
				do{
					System.out.println("Admin\n1.Companies Records\n2. User Records");
					int x = nextint();
					if(x == 1)
					{
						admin.show_companies_records();
						break;
					}
					else if(x == 2)
					{
						admin.show_users_records();
					break;
					}
					else
					{
						System.out.println("Invalid choice");
					}
				}while(true);
				break;
			case 2:
				admin.company_view();
				break;
			case 3:
				admin.User_view();
				break;
			default:
				break;
			}
		}
	//	admin.User_view();
	}
	void show_users_records()
	{
		System.out.println();
		System.out.println("User Records");
		for(int i = 0 ; i < user.size();i++)
		{
			System.out.print(i + 1);
			user.get(i).display_user();
			System.out.println();
		}
	}
	void show_companies_records()
	{
		System.out.println();
		System.out.println("Company Records");
		if(air_mode.size() > 0)
		{
			System.out.println("Airlines");
		}
		for(int i = 0 ; i < air_mode.size();i++)
		{
			System.out.print(i + 1);
			air_mode.get(i).display_info();
		}
		if(bus_mode.size() > 0)
		{
			System.out.println("Bus Services");
		}
		for(int i = 0 ; i < bus_mode.size();i++)
		{
			System.out.print(i + 1);
			bus_mode.get(i).display_info();
		}
		if(train_mode.size() > 0)
		{
			System.out.println("Train Services");
		}
		for(int i = 0 ; i < train_mode.size();i++)
		{
			System.out.print(i + 1);
			train_mode.get(i).display_info();
		}
	}
}
