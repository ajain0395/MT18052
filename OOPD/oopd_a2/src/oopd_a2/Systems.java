package oopd_a2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ashish
 *
 */
public class Systems {

	static Scanner sc = new Scanner(System.in);

	ArrayList<Restaurant> rest_list = new ArrayList<Restaurant>();
	ArrayList<Customer>		cust_list = new ArrayList<Customer>();


	/*
	 * Restaurant Registration
	 * (restaurant_id,
	 * Restaurant name,
	 * Address,
	 * Contact number,
	 * min order Value,
	 * Delivery charge if order value < min order value,
	 */
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

	/*
	 * select dist from current selected menu
	 */
	int getitem(Restaurant rest)
	{

		int val ;//= sc.nextInt();
		do {
			rest.getMenu();
			System.out.println("Enter Item no.: ");
			val = sc.nextInt();
			if((val) > rest.menu.size() || val < 1)
			{
				System.out.println("Invalid Choice");
			}
		}while((val) > rest.menu.size() || val < 1);
		return val - 1 ;
	}
	/*
	 * Display list of Registered Restaurants
	 */
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
	/*
	 * Select Restaurant from list
	 */
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

	/*
	 * Add a user to take order
	 */
	public void add_customer(String name,String number,String address) throws InterruptedException
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
			if(cst.getCart().getCount() > 0)
			{
				cst.checkout();
				cst.setStatus("Order Successfully Placed");
				//Thread.sleep(5000);
			}
			else
			{
				ch = 4;
				System.out.println("Cart is Empty");
			}
				break;
			case 4:
				if(cst.getCart().getCount() > 0)
				{
					cst.getCart().display();
				}
				else
				{
					System.out.println("Cart is Empty");
				}
				
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
		System.out.println(cst.getStatus());
		cst.setStatus("Order is being prepared");
		Thread.sleep(5000);
		System.out.println(cst.getStatus());
		cst.setStatus("Order Out For Delivery");
		Thread.sleep(5000);
		System.out.println(cst.getStatus());
		cst.setStatus("Order Delivered");
		Thread.sleep(5000);
		System.out.println(cst.getStatus());
		cust_list.add(cst);

	}

	void add_new_dish(int index,int id,int price,String dish)
	{
		rest_list.get(index).add_dish(id, price, dish);
	}
	
	//Main method
	public static void main(String []args)
	{	
		Systems mainsys = new Systems();

		mainsys.add_restaurant(0,"Restaurant 1","Govindpuri","9846523789","Raman",0,0);
		
		mainsys.add_new_dish(0,0,100,"Salad");
		mainsys.add_new_dish(0,1,50,"Papad");
		mainsys.add_new_dish(0,2,20,"Juice");

		mainsys.add_restaurant(1,"Restaurant 2", "Lajpat Nagar", "9875462314", "Ram", 100, 50);
		mainsys.add_new_dish(1,0,100,"Daal");
		mainsys.add_new_dish(1,1,10,"Roti");

		try {
			mainsys.add_customer("Ashish Jain","9718865548","H1 IITD");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
