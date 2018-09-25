package a3_ASHISH_MT18052;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_System {

	public static Scanner sc = new Scanner(System.in);
	
	public static int curr_date = 30;
	public static ArrayList<Air_Mode> air_mode = new ArrayList<>();
//	public static ArrayList<Bus_Mode> bus_mode = new ArrayList<>();
//	public static ArrayList<Train_Mode> train_mode = new ArrayList<>();
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
		cd.register_company("Vistara", "6589412347", 4503);
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
		return Integer.parseInt(sc.nextLine());
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
	User registerUser(String fullname,String username,String number)
	{
		User usr = null;
		int index = -1;
		index = find_user(username);
		if(find_user(username) == -1)
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
		System.out.println("Running");
		Main_System admin = new Main_System();
		admin.preregister();
		admin.User_view();
	}

}
