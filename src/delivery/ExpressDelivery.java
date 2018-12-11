package delivery;

public class ExpressDelivery implements Delivery {

	/**
	 * ExpressDelivery constructor with an argument of String type
	 * @param city The city
	 */
	public ExpressDelivery(String city) {
		this.city = city;
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public double getPrice() {
		
		if (this.city == "Paris")
			return 6.99;
		else
			return 9.99;
	}
	
	@Override
	public String getInfo() {		
		return "Livraison à domicile express";
	}
	
	//---------------------------------------------------------------------------------------------
	
	private String city;
}
