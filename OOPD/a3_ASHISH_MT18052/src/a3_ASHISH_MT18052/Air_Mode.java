package a3_ASHISH_MT18052;

import java.util.ArrayList;
import java.util.Random;

public class Air_Mode implements Company {

	public String name;
	public String contact_number;
	int fare = 1000000;	
	ArrayList<String> coupons_code = new ArrayList<String>();
	ArrayList<Integer> coupons_percent = new ArrayList<Integer>();
	int cancel_charge;
	
	
	public Air_Mode() {
		// TODO Auto-generated constructor stub
		cancel_charge = 400;
	}
	
	
	
	void register_company(String name,String number, int fare)
	{
			this.setFare(fare);
			this.setName(name);
			this.setContact_number(number);
	}
	public int getCancel_charge() {
		return cancel_charge;
	}

	public void setCancel_charge(int cancel_charge) {
		this.cancel_charge = cancel_charge;
	}
	
	public boolean display_coupons()
	{
		if(coupons_code.isEmpty())
		{
			System.out.println("Coupons not available");
			return false;
		}
		else
		{
			System.out.println("Available Coupons");
			System.out.println("S No.\t\tCode\t\t%Discount");
			for(int i = 0;i<coupons_code.size();i++)
			{
				System.out.println((i+1)+"\t\t"+coupons_code.get(i) + "\t\t"+coupons_percent.get(i));
			}
		}
		return true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	
	public String getContact_number() {
		return contact_number;
	}
	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}
	public void add_coupons(int discount)
	{
		Random r = new Random();
		String e = new String("");
		for(int i = 0;i < 5;i++)
		{
			e+= (char)('A' + r.nextInt(25));
		}
		coupons_code.add(e);
		coupons_percent.add(discount);
	}

	@Override
	public int select_code() {

		boolean flag = true;
		while(flag && display_coupons())
		{
			int sel = Main_System.nextint();
			if(sel < 1 || sel > coupons_code.size())
			{
				System.out.println("Invalid Choice");
			}
			else
				{
				int dis = coupons_percent.get(sel - 1);
					
				return dis;
				}
		}
		return 0;
	}
}
