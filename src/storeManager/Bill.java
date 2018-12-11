package storeManager;

import java.util.HashMap;
import java.util.Map;

import delivery.Delivery;
import product.Product;
import write.Writer;

public class Bill {

	/**
	 * Bill constructor with an argument of Customer type
	 * @param customer The Customer of the bill
	 */
	public Bill(Customer customer, Delivery delivery) {
		this.customer = customer;
		this.products = new HashMap<Product, Integer>();
		this.delivery = delivery;
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
	
	/**
	 * Returns a Delivery which corresponds to the delivery type
	 * @return The delivery
	 */
	public Delivery getDelivery() {
		return this.delivery;
	}
	
	/**
	 * Generates the bill summary
	 * @param writer 
	 */
	public void generate(Writer writer) {
		
	    writer.start();

	    writer.writeLine("HomeShop compagnie");
	    writer.writeLine("1 Place Charles de Gaulle, 75008 Paris");
	    writer.writeLine("");
	    writer.writeLine("Facture à l'attention de : ");
	    writer.writeLine(this.customer.getFullName());
	    writer.writeLine(this.customer.getAddress());
	    writer.writeLine("");
	    writer.writeLine("Mode de livraison : " + this.delivery.getInfo());
	    writer.writeLine("");
	    writer.writeLine("Produits : ");
	    writer.writeLine("-----------------------------------------------------");

	    for (Map.Entry<Product, Integer> entry : this.products.entrySet()) {
	        writer.writeLine(entry.getKey().getName() + " - " + entry.getKey().getPrice() + " - " + entry.getValue() + " unité(s)");
	        writer.writeLine(entry.getKey().getDescription());
	        writer.writeLine("");
	    }

	    writer.writeLine("Livraison : " + this.delivery.getPrice());
	    writer.writeLine("-----------------------------------------------------");
	    writer.writeLine("Total : " + this.getTotal());

	    writer.stop();
	}
	
	/**
	 * Returns the total of bill
	 * @return The total
	 */
	public double getTotal() {
		
		// Add the delivery price
		double total = this.delivery.getPrice();
		
		// For each product, product price * quantity
		for (Map.Entry<Product, Integer> entry : this.products.entrySet())
			total += entry.getKey().getPrice() * entry.getValue();
		
		return total;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private Customer customer;
	private Map<Product, Integer> products;
	private Delivery delivery;
}
