package oopd_a2;

import java.util.ArrayList;

public class Cart {
	
	private int count;
	private int total;
	Restaurant res;
	ArrayList<Menu> dish = new ArrayList<Menu>();
	
	void display_dishes()
	{
		for(int i = 0; i < dish.size();i++)
		{
			System.out.println("Item id: "+dish.get(i).getId()+"\tItem Name: " +dish.get(i).getDish() + "\tPrice: " + dish.get(i).getPrice()+"/-" );
		}
	}
	
	void display()
	{
			for(int i = 0; i < dish.size();i++)
			{
				System.out.println("Item id: "+dish.get(i).getId()+"\tItem Name: " +dish.get(i).getDish() + "\tPrice: " + dish.get(i).getPrice() );
			}
			System.out.println("Total Item Count " + this.getCount());
			if(getTotal() < this.res.getMinval())
			{
				System.out.println("Total Amount " + (this.getTotal() + res.getFine()) + "/-");	
			}
			else
			{
				System.out.println("Total Amount " + this.getTotal() + "/-");
			}
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public Cart()
	{
		this.setCount(count);;
	}
	
	public void remove_item()
	{
		boolean flag = false;
		int id ;
		do
		{
			
		display_dishes();
		System.out.println("Enter Dish id: ");
		id = Systems.sc.nextInt();
		for(int i = 0; i <dish.size();i++)
		{
			if(id == dish.get(i).getId())
			{
				this.setTotal(this.getTotal() - dish.get(i).getPrice());
				dish.remove(i);
				flag = true;
				this.setCount(this.getCount() - 1);
				break;
			}
		}
		if(!flag)
		{
			System.out.println("invalid item;");
		}
		}while(!flag);
	}
	public Restaurant getRes() {
		return res;
	}
	public void setRes(Restaurant res) {
		this.res = res;
	}
	public void add_item(Menu m)
	{
		dish.add(m);
		this.setCount(this.getCount() + 1);
		this.setTotal(this.getTotal() + m.getPrice());
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
