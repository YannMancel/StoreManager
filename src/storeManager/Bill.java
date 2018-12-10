package storeManager;

import java.util.Map;

public class Bill {

	/**
	 * Bill constructor with an argument of Customer type
	 * @param customer The Customer of the bill
	 */
	public Bill(Customer customer) {
		this.customer = customer;
		
		this.products = null;
	}	
	
	//---------------------------------------------------------------------------------------------
	
	/**
	 * Add a product with a quantity in the bill
	 * @param product The Product
	 * @param quantity The quantity
	 */
	public void addProduct(Product product, Integer quantity) {
		this.products.put(product, quantity);
	}
	
	/**
	 * Returns a Customer of the bill
	 * @return The Customer
	 */
	public Customer getCustomer() {
		return this.customer;
	}
	
	/**
	 * Returns a Map which corresponds to the product and the associated quantity
	 * @return The product and the associated quantity
	 */
	public Map<Product, Integer> getProducts() {
		return this.products;
	}	
	
	//---------------------------------------------------------------------------------------------
	
	private Customer customer;
	private Map<Product, Integer> products;
}
