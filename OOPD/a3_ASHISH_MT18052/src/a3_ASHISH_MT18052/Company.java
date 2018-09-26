package a3_ASHISH_MT18052;


public interface Company {

	boolean display_coupons();
	void setName(String name);
	String getName() ;
	float getFare();
	void setFare(float fare);
	int select_code();
	String getContact_number();
	void setContact_number(String contact_number);
	void add_coupons(int discount);
	int getCancel_charge();
	void setCancel_charge(int cancel_charge);
}
