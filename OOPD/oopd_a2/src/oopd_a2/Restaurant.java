package oopd_a2;

import java.util.ArrayList;

public class Restaurant {

	String name;
	private String Owner;
	private String rest_number;
	private String Address;
	int minval;
	int fine;
	ArrayList <Menu>menu = new ArrayList<Menu>();
	private int id;
	
	public Restaurant(Restaurant obj)
	{
		this.setAddress(obj.getAddress());
		this.setFine(obj.getFine());
		this.setId(obj.getId());
		this.setName(obj.getName());
		this.setOwner(obj.getOwner());
		this.setRest_number(obj.getRest_number());
		this.setMinval(obj.getMinval());
	}
	public Restaurant()
	{
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return Owner;
	}

	public void setOwner(String owner) {
		Owner = owner;
	}

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
	
	public void getMenu()
	{
		System.out.println("===============================================================================================================");
		for(int i = 0; i < menu.size();i++)
		{
			System.out.println("Item id: "+(i + 1)+"\tItem Name: " +menu.get(i).getDish() + "\tPrice: " + menu.get(i).getPrice()+"/-" );
		}
		System.out.println("===============================================================================================================");
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
