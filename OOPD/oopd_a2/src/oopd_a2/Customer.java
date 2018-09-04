package oopd_a2;

public class Customer {

	private String name;
	private String cust_number;
	
	private Cart cart;
	
	public void checkout()
	{
		System.out.println("Order Summary " + getName());
		this.cart.display();
		System.out.println("Contact No. " + getCust_number());
	}
	
	public Customer(String name,String cust_number)
	{
		this.setName(name);
		this.setCust_number(cust_number);
		this.cart = new Cart();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCust_number() {
		return cust_number;
	}
	public void setCust_number(String cust_number) {
		this.cust_number = cust_number;
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
