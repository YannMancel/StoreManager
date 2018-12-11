package delivery;

public class TakeAwayDelivery implements Delivery {

	@Override
	public double getPrice() {
		return 0;
	}
	
	@Override
	public String getInfo() {		
		return "Retrait en entrepot";
	}
}
