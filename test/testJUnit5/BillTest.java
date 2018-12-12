package testJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import delivery.Delivery;
import delivery.RelayDelivery;

import product.Fridge;
import product.Product;
import product.Television;

import storeManager.Bill;
import storeManager.Customer;
import storeManager.NoProductInBillException;

import write.Writer;

class BillTest {

	@Test
	@DisplayName("generate")
	final void testGenerate() {
		
		Bill bill = new Bill(customer, lowCostRelayDelivery);

		bill.addProduct(cafe, 1);
		bill.addProduct(tv,   1);
		
		bill.generate(writerMock);
		
        assertEquals(20, output.split("\n").length);		
	}
	
	@Test
	@DisplayName("generate an empty bill")
	final void testGenerateEmptyBill() {
		
		Bill bill = new Bill(customer, lowCostRelayDelivery);
		
		assertThrows(NoProductInBillException.class, () -> bill.generate(writerMock));	
	}
	
	@Test
	@DisplayName("getTotal")
	final void testGetTotal() {
		
		Bill bill = new Bill(customer, lowCostRelayDelivery);

		bill.addProduct(cafe,   1);
		bill.addProduct(tv,     1);
		bill.addProduct(fridge, 1);
		
		// 79.99*1 + 599*1 + 189*1 + 2.99 = 870.98
		assertEquals(870.98, bill.getTotal(), 0.01);
	}
	
	//---------------------------------------------------------------------------------------------
	
	private String output;
	private Writer writerMock = new Writer() {

		@Override
	    public void start() {
			output = "";
		}

		@Override
		public void writeLine(String line) {
			output += line + "\n";
		}

		@Override
		public void stop() {
			
		}
	};
	
	// Products
    private Product cafe   = new Product("Philips HD7866/61",        "Philips SENSEO Quadrante, Noir - 1 ou 2 tasses",  79.99);
    private Product tv     = new Television("TV Samsung UE49MU6292", "Smart TV LED incurvée 49\"",                     599,     49, "LED");
    private Fridge  fridge = new Fridge("BEKO TSE 1042 F",           "Réfrigérateur BEKO 130L - Classe A+ - blanc",    189,    130, false);

    // Customer
    private Customer customer = new Customer("Juste Leblanc", "19 rue Germain Pilon, Paris");

    // Delivery
    private Delivery lowCostRelayDelivery = new RelayDelivery(27);
}
