package product;

public class Television extends Product {

	/**
	 * Television constructor with the 3 arguments of the Product class and the 2 additional arguments for the Television class
	 * @param name The name
	 * @param description The description
	 * @param price The price
	 * @param size The size
	 * @param slabType The slab Type
	 */
	public Television(String name, String description, double price, int size, String slabType) {
		super(name, description, price);
		
		this.size = size;
		this.slabType = slabType;
	}
	
	//---------------------------------------------------------------------------------------------
	
	/**
	 * Returns an integer which corresponds to the size
	 * @return The size
	 */
	public int getSize() { 
		return this.size; 
	}
	
	/**
	 * Returns a String which corresponds to the slab Type
	 * @return The slab Type
	 */
	public String getSlabType() { 
		return this.slabType; 
	}	
	
	//---------------------------------------------------------------------------------------------
	
	private int size;
	private String slabType;
}
