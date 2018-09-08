package oopd_a2;

public class Customer {

	private String name;
	private String cust_number;
	private Cart cart;
	private String address;
	
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void checkout()
	{
		System.out.println("Order Summary " + getName());
		this.cart.display();
		System.out.println("Contact No. " + getCust_number());
	}
	
	public Customer(String name,String cust_number,String address)
	{
		
		this.setName(name);
		this.setCust_number(cust_number);
		this.setAddress(address);
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
