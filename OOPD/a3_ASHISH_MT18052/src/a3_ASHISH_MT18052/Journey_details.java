package a3_ASHISH_MT18052;

public class Journey_details{

	String Source;
	String Destination;
	int date;
	float cost;
	Company medium;
	public Journey_details() {
		// TODO Auto-generated constructor stub
		
	}
	public Journey_details(String source,String destination,int date,Company med) {
		// TODO Auto-generated constructor stub
		setSource(source);
		setDestination(destination);
		setCost(med.getFare());
		setDate(date);
		setMedium(med);
	}
	void print_ticket()
	{
		System.out.println("```````````````````````````````````````````````````````````````````````````````````````````");
		System.out.println("From "+ getSource()+"\t to \t"+getDestination());
		System.out.println("Journey Date: " + getDate());
		System.out.println("Company: " + medium.getName());
		System.out.println("```````````````````````````````````````````````````````````````````````````````````````````");
	}
	public Company getMedium() {
		return medium;
	}
	public void setMedium(Company medium) {
		this.medium = medium;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
}
