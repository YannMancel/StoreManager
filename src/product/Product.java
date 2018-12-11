package product;

import storeManager.Bill;

public class Product {

	/**
	 * Product constructor with two arguments of String type and an argument of double type
	 * @param name The name
	 * @param description The description
	 * @param price The price
	 */
	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	//---------------------------------------------------------------------------------------------
	
	/**
	 * Displays the full description of the product
	 */
	public void look() {
		System.out.println(String.format(this.name + " : " + this.price + "%n" + this.description));
	}
	
	/**
	 * Displays the price of the product
	 * @param bill The concerned bill
	 * @param quantity The quantity to add
	 */
	public void buy(Bill bill, Integer quantity) {
		
	}	
	
	/**
	 * Returns a String which corresponds to the product name
	 * @return The product name
	 */
	public String getName() { 
		return this.name; 
	}
	
	/**
	 * Returns a String which corresponds to the product description
	 * @return The product description
	 */
	public String getDescription() { 
		return this.description; 
	}
	
	/**
	 * Returns a double which corresponds to the product price
	 * @return The product price
	 */
	public double getPrice() { 
		return this.price; 
	}
	
	/**
	 * Modify the price to the product price
	 * @param value The new product price
	 */
	public void setPrice(double value) { 
		this.price = value; 
	}
	
	//---------------------------------------------------------------------------------------------
	
	private String name;
	private String description;
	private double price;
}
