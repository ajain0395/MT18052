package oopd_a2;

import java.util.ArrayList;

public class Cart {
	
	private int count;

	ArrayList<Restaurant> res = new ArrayList<Restaurant>();
//	ArrayList<Menu> dish = new ArrayList<Menu>();
	
	void display_dishes_to_remove()
	{
		int ind = 1;
		System.out.println("===============================================================================================================");
		for(int j =0;j < res.size();j++)
		{
			if(res.get(j).menu.size()>0)
			{
				System.out.println("---------------------------------------------------------------------------------------------------------------");			
				System.out.println(res.get(j).getName());
				System.out.println("---------------------------------------------------------------------------------------------------------------");			
				for(int i = 0; i < res.get(j).menu.size();i++)
				{
					System.out.println("Item No.: "+ (ind )+"\tItem Name: " +res.get(j).menu.get(i).getDish() + "\tPrice: " + res.get(j).menu.get(i).getPrice() );
					ind++;
				}
			}
		}
			System.out.println("===============================================================================================================");
	}
	void display()
	{
		int total_i = 0;
		int tota_final = 0;
		@SuppressWarnings("unused")
		int ind = 1;
		System.out.println("===============================================================================================================");
		for(int j =0;j < res.size();j++)
		{
			if(res.get(j).menu.size() > 0)
			{	
			total_i = 0;
			System.out.println("---------------------------------------------------------------------------------------------------------------");	
			System.out.println(res.get(j).getName());
			System.out.println("---------------------------------------------------------------------------------------------------------------");			
			for(int i = 0; i < res.get(j).menu.size();i++)
			{
				System.out.println("Item No.: "+ (i + 1 )+"\tItem Name: " +res.get(j).menu.get(i).getDish() + "\tPrice: " + res.get(j).menu.get(i).getPrice() );
				total_i += res.get(j).menu.get(i).getPrice(); 
				ind +=1;
			}

			tota_final += total_i;
			if(total_i > 0 && total_i < this.res.get(j).getMinval())
			{
				System.out.println("Amount: " + total_i + " + " +res.get(j).getFine()+ " = " +(total_i + res.get(j).getFine()) + "/-");	
				tota_final += res.get(j).getFine();
			}
			else
			{
				System.out.println("Amount:" + total_i + "/-");
			}
		}
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------");			
		System.out.println("Total: " + tota_final);
			System.out.println("===============================================================================================================");
	}
	
	
	public Cart()
	{
		this.setCount(count);;
	}
	
	public void remove_item()
	{
		boolean flag = false;
		int id ;
		int cou = 1;
		if(getCount() > 0)
		{
		do
		{
		cou = 1;
		display_dishes_to_remove();
		System.out.println("Enter Dish To remove no. : ");
		id = Systems.sc.nextInt();
		for(int j =0;j < res.size();j++)
		{
			for(int i = 0; i < res.get(j).menu.size();i++)
			{
				if(cou == id)
				{
					res.get(j).menu.remove(i);
					this.setCount(this.getCount() - 1);
					flag = true;
					break;
				}
				cou++;
			}
			if(flag)
				break;
		}
		if(!flag)
		{
			System.out.println("invalid item");
		}
		}while(!flag);
		}
		else
		{
			System.out.println("Cart is Empty");
		}
	}
	public void add_item(int index,Menu m)
	{
		res.get(index).menu.add(m);
		this.setCount(this.getCount() + 1);
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
