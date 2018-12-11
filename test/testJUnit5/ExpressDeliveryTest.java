package testJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import storeManager.*;

class ExpressDeliveryTest {

	@Test
	@DisplayName("Configuration: price=6.99 when city=Paris")
	final void testGetPrice_0() {
		Delivery delivery = new ExpressDelivery("Paris");
		assertEquals(6.99, delivery.getPrice(), 0.01);
	}
	
	@Test
	@DisplayName("Configuration: price=9.99 when city is not Paris")
	final void testGetPrice_1() {
		Delivery delivery = new ExpressDelivery("London");
		assertEquals(9.99, delivery.getPrice(), 0.01);
	}
}
