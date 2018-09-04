package oopd_a2;

public class Menu {

	int id;
	String dish;
	int price;
	public Menu(int id,int price,String dish)
	{
		this.setId(id);
		this.setDish(dish);
		this.setPrice(price);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDish() {
		return dish;
	}
	public void setDish(String dish) {
		this.dish = dish;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
