package main;

import delivery.Delivery;
import delivery.RelayDelivery;

import product.Fridge;
import product.Product;
import product.Television;

import storeManager.Bill;
import storeManager.Customer;
import storeManager.NoProductInBillException;

import write.FileWriter;

public class Main {

	public static void main(String[] args) {
		
		// Products
	    Product cafe   = new Product("Philips HD7866/61",        "Philips SENSEO Quadrante, Noir - 1 ou 2 tasses",  79.99);
	    Product tv     = new Television("TV Samsung UE49MU6292", "Smart TV LED incurvée 49\"",                     599,     49, "LED");
	    Fridge  fridge = new Fridge("BEKO TSE 1042 F",           "Réfrigérateur BEKO 130L - Classe A+ - blanc",    189,    130, false);

	    // Customer
	    Customer customer = new Customer("Juste Leblanc", "19 rue Germain Pilon, Paris");

	    // Delivery
	    Delivery lowCostRelayDelivery = new RelayDelivery(27);
	    
	    // Bill
		Bill bill = new Bill(customer, lowCostRelayDelivery);

		bill.addProduct(cafe,   1);
		bill.addProduct(tv,     1);
		bill.addProduct(fridge, 1);
		
		try {
			bill.generate(new FileWriter("Other/Bill.txt"));
		}
		catch(NoProductInBillException e) {
			System.err.println(e.getMessage());
		}
	}
}
