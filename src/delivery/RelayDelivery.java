package delivery;

public class RelayDelivery implements Delivery {

	/**
	 * RelayDelivery constructor with an argument of integer type
	 * @param number The street number
	 */
	public RelayDelivery (int number) {
		this.number = number;		
	}
	
	//---------------------------------------------------------------------------------------------
	
	@Override
	public double getPrice() {
		
		if (this.number >= 1 && this.number <= 22) 
			return 0.0;
		else if (this.number >= 23 && this.number <= 47)
			return 2.99;
		else 
			return 4.99;
	}
	
	@Override
	public String getInfo() {		
		return "Livraison en point relais";
	}
	
	//---------------------------------------------------------------------------------------------
	
	private int number;
}
