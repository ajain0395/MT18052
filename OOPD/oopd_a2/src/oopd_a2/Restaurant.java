package oopd_a2;

import java.util.ArrayList;

public class Restaurant {

	String name;
	private String rest_number;
	private String Address;
	int minval;
	int fine;
	
	public int getFine() {
		return fine;
	}

	public void setFine(int fine) {
		this.fine = fine;
	}

	public int getMinval() {
		return minval;
	}

	public void setMinval(int minval) {
		this.minval = minval;
	}
	ArrayList <Menu>menu = new ArrayList<Menu>();
	
	public void getMenu()
	{
		for(int i = 0; i < menu.size();i++)
		{
			System.out.println("Item id: "+menu.get(i).id+"\tItem Name: " +menu.get(i).getDish() + "\tPrice: " + menu.get(i).getPrice()+"/-" );
		}
	}
	
	public void add_dish(int id,int price,String dish)
	{
		menu.add(new Menu(id,price,dish));
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRest_number() {
		return rest_number;
	}
	public void setRest_number(String rest_number) {
		this.rest_number = rest_number;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
}
