package testJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import delivery.Delivery;
import delivery.RelayDelivery;

class RelayDeliveryTest {

	@Test
	@DisplayName("Configuration: price=0.0 when number=[1 to 22]")
	final void testGetPrice_0() {
		Delivery delivery = new RelayDelivery(1);
		assertEquals(0.0, delivery.getPrice(), 0.01);
	}
	
	@Test
	@DisplayName("Configuration: price=2.99 when number=[23 to 47]")
	final void testGetPrice_1() {
		Delivery delivery = new RelayDelivery(30);
		assertEquals(2.99, delivery.getPrice(), 0.01);
	}

	@Test
	@DisplayName("Configuration: price=4.99 when number is not in [1 to 47]")
	final void testGetPrice_2() {
		Delivery delivery = new RelayDelivery(0);
		assertEquals(4.99, delivery.getPrice(), 0.01);
	}
}
