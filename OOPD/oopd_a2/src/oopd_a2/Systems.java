package oopd_a2;

import java.util.ArrayList;
import java.util.Scanner;

public class Systems {
	
	static Scanner sc = new Scanner(System.in);
	
	ArrayList<Restaurant> rest_list = new ArrayList<Restaurant>();
	ArrayList<Customer>		cust_list = new ArrayList<Customer>();
	int Restaurant_count;
	
	public Systems(int n)
	{
		Restaurant_count = n;
		for(int i = 0; i < Restaurant_count; i++)
		{
			this.rest_list.add(new Restaurant());
		}
	}
	
	int getitem(int restid)
	{
		
		int val ;//= sc.nextInt();
		do {
			this.rest_list.get(restid).getMenu();
			System.out.println("Enter Item ID: ");
			val = sc.nextInt();
			if(val > this.rest_list.get(restid).menu.size() || val < 0)
			{
				System.out.println("Invalid Choice");
			}
		}while(val > this.rest_list.get(restid).menu.size() || val < 0);
	
		return val;
	}
	void display_restaurant()
	{
		System.out.println("===============================================================================================================");
		System.out.println("No.\tName\t\tPhone Number\t\tAddress\t\tMin Order Val\t\tDelivery Charge");
		System.out.println("===============================================================================================================");
		for(int i = 0; i <rest_list.size();i++)
		{
			System.out.print((i+1) + "\t");
			System.out.print(rest_list.get(i).getName() + "\t");
			System.out.print(rest_list.get(i).getRest_number() + "\t\t");
		
			System.out.print(rest_list.get(i).getAddress()+ "\t\t");
			System.out.print(rest_list.get(i).getMinval() + "\t\t\t" +rest_list.get(i).getFine() + "\t\t");
			System.out.println();
		}
		System.out.println("===============================================================================================================");
	}
	
	public Customer add_customer(String name,String number)
	{
		Customer cst = new Customer(name,number);
		int restid;
		do
		{
		display_restaurant();
			System.out.print("Enter Restaurant id : ");
			restid = sc.nextInt();
			if(restid > Restaurant_count || restid < 1)
			{
				System.out.println("Invalid Choice");
				
			}
		}while(restid > Restaurant_count || restid < 1);
		restid--;
		cst.getCart().setRes(rest_list.get(restid));
		int ch = 0;
		
		do
		{
			System.out.println("===============================================================================================================");
			System.out.println("1.Add Item\n2.Remove Item\n3.Checkout\n4.Display Cart");
			System.out.println("===============================================================================================================");
			System.out.println("Enter Choice");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				//mainsys.rest_list.get(restid).getMenu();	
			
				System.out.println("Add Item");
				cst.getCart().add_item(cst.getCart().getRes().menu.get(getitem(restid)));
				break;
			case 2:
			
				System.out.println("Remove Item");
				cst.getCart().remove_item(); 
				break;
			case 3:
			
				cst.checkout();
				break;
			case 4:
			
				cst.getCart().display();
				break;
				default:
					System.out.println("Invalid choice");
					break;
			}
			
		}while(ch != 3);
		

		return cst;
	}
	
	public static void main(String []args)
	{
		
		Systems mainsys = new Systems(2);
		
		
			mainsys.rest_list.get(0).setName("Restaurant 1");
			mainsys.rest_list.get(0).setAddress("Delhi");
			mainsys.rest_list.get(0).setRest_number("9856321478");
			mainsys.rest_list.get(0).setMinval(0);
			mainsys.rest_list.get(0).setFine(0);
			mainsys.rest_list.get(0).add_dish(0,100,"Salad");
			mainsys.rest_list.get(0).add_dish(1,50,"Papad");
			
			mainsys.rest_list.get(1).setName("Restaurant 2");
			mainsys.rest_list.get(1).setAddress("Noida");
			mainsys.rest_list.get(1).setRest_number("9654786321");
			mainsys.rest_list.get(1).setMinval(100);
			mainsys.rest_list.get(1).setFine(50);
			mainsys.rest_list.get(1).add_dish(0,100,"Daal");
			mainsys.rest_list.get(1).add_dish(1,10,"Roti");
	
			
			mainsys.cust_list.add(mainsys.add_customer("Ashish Jain","9718865548"));
						
	}
}
