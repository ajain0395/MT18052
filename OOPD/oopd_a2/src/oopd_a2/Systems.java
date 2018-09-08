package oopd_a2;

import java.util.ArrayList;
import java.util.Scanner;

public class Systems {
	
	static Scanner sc = new Scanner(System.in);
	
	ArrayList<Restaurant> rest_list = new ArrayList<Restaurant>();
	ArrayList<Customer>		cust_list = new ArrayList<Customer>();
	
	public void add_restaurant(int id,String resname,String location,String phone,String owner,int minorder,int fine)
	{
//		Restaurant_count = n;
		Restaurant res = new Restaurant();
		res.setName(resname);
		res.setId(id);
		res.setAddress(location);
		res.setFine(fine);
		res.setMinval(minorder);
		res.setOwner(owner);
		res.setRest_number(phone);
		rest_list.add(res);	
	}
	
	int getitem(Restaurant rest)
	{
		
		int val ;//= sc.nextInt();
		do {
			rest.getMenu();
			System.out.println("Enter Item no.: ");
			val = sc.nextInt();
			if((val - 1) > rest.menu.size() || val < 1)
			{
				System.out.println("Invalid Choice");
			}
		}while((val - 1 ) > rest.menu.size() || val < 1);
		return val - 1 ;
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
	
	Restaurant select_restaurant()
	{
		int restid;
		do
		{
			display_restaurant();
			System.out.print("Enter Restaurant no. : ");
			restid = sc.nextInt();
			if(restid > rest_list.size() || restid < 1)
			{
				System.out.println("Invalid Choice");
			}
		}
		while(restid > rest_list.size() || restid < 1);
		return rest_list.get(restid-1);
	}
	
	public void add_customer(String name,String number,String address)
	{
		Customer cst = new Customer(name,number,address);
		Restaurant selected;
		int selected_index = cst.getCart().res.size();
		boolean flag = false;
		selected = select_restaurant();
		for(int i = 0; i < cst.getCart().res.size();i++)
		{
			if (cst.getCart().res.get(i).getId() == selected.getId())
			{
				flag = true;
				selected_index = i;
				break;
			}
		}
		if(!flag)
			{
				selected_index = cst.getCart().res.size();
				cst.getCart().res.add(new Restaurant(selected));
			}
		int ch = 0;
		do
		{
			System.out.println("===============================================================================================================");
			System.out.println("1.Add Item\n2.Remove Item\n3.Checkout\n4.Display Cart\n5.Switch Restaurant");
			System.out.println("===============================================================================================================");
			System.out.println("Enter Choice");
			ch = sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("Add Item");
				cst.getCart().add_item(selected_index,selected.menu.get(getitem(selected)));
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
			case 5:
			{
				flag = false;
				selected = select_restaurant();
				for(int i = 0; i < cst.getCart().res.size();i++)
				{
					if (cst.getCart().res.get(i).getId() == selected.getId())
					{
						flag = true;
						selected_index = i;
						break;
					}
				}
				if(!flag)
					{
						selected_index = cst.getCart().res.size();
						cst.getCart().res.add(new Restaurant(selected));
					}
			}
				break;
			default:
					System.out.println("Invalid choice");
					break;
			}
			
		}while(ch != 3);
		

		cust_list.add(cst);
		
	}
	
	public static void main(String []args)
	{	
		Systems mainsys = new Systems();
		
			mainsys.add_restaurant(66,"Restaurant 1","Govindpuri","9846523789","Raman",0,0);

			mainsys.rest_list.get(0).add_dish(0,100,"Salad");
			mainsys.rest_list.get(0).add_dish(1,50,"Papad");
			mainsys.rest_list.get(0).add_dish(2,70,"Rice");

			mainsys.add_restaurant(45,"Restaurant 2", "Lajpat Nagar", "9875462314", "Ram", 100, 50);
			mainsys.rest_list.get(1).add_dish(0,100,"Daal");
			mainsys.rest_list.get(1).add_dish(1,10,"Roti");

			mainsys.add_customer("Ashish Jain","9718865548","H1 IITD");
						
	}
}
