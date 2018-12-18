package testJUnit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import web.BillServlet;

class BillServletTest {

	@Test
	@DisplayName("splitParameters: p1=v1 p2=v2")
	void test_1() {
		
		BillServlet billServlet = new BillServlet();		
		Map<String, String> params = billServlet.splitParameters("p1=v1&p2=v2");

		assertEquals(2, params.size());
		assertEquals("v1", params.get("p1"));
		assertEquals("v2", params.get("p2"));
	}
	
	@Test
	@DisplayName("splitParameters: p1=Not p2=v2")
	void test_2() {
		
		BillServlet billServlet = new BillServlet();		
		Map<String, String> params = billServlet.splitParameters("p1=&p2=v2");

		assertEquals(1, params.size());
		assertEquals("v2", params.get("p2"));
	}
	
	@Test
	@DisplayName("splitParameters: Nothing")
	void test_3() {
		
		BillServlet billServlet = new BillServlet();		
		Map<String, String> params = billServlet.splitParameters("text");

		assertEquals(0, params.size());
	}
}
