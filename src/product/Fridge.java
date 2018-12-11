package product;

public class Fridge extends Product {

	/**
	 * Fridge constructor with the 3 arguments of the Product class and the 2 additional arguments for the Fridge class
	 * @param name The name
	 * @param description The description
	 * @param price The price
	 * @param liter The liter
	 * @param freezer Is the freezer there?
	 */
	public Fridge(String name, String description, double price, int liter, boolean freezer) {
		super(name, description, price);
		
		this.liter = liter;
		this.freezer = freezer;
	}
	
	//---------------------------------------------------------------------------------------------
	
	/**
	 * Returns an integer which corresponds to the liter
	 * @return The liter
	 */
	public int getLiter() { 
		return this.liter; 
	}
	
	/**
	 * Returns a boolean which corresponds to the freezer presence
	 * @return Is the freezer there?
	 */
	public boolean isFreezer() { 
		return this.freezer; 
	}	
	
	//---------------------------------------------------------------------------------------------
	
	private int liter;
	private boolean freezer;
}
