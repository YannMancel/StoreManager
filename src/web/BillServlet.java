package web;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import delivery.*;
import product.*;
import storeManager.*;
import write.Writer;

// Connection: http://localhost:8080/bill

public class BillServlet extends HttpServlet {
	
    @Override
    public void init() throws ServletException {
        
    	/* Without a database
		// Products
	    Product cafe   = new Product("Philips HD7866/61",        "Philips SENSEO Quadrante, Noir - 1 ou 2 tasses",  79.99);
	    Product tv     = new Television("TV Samsung UE49MU6292", "Smart TV LED incurvée 49\"",                     599,     49, "LED");
	    Fridge  fridge = new Fridge("BEKO TSE 1042 F",           "Réfrigérateur BEKO 130L - Classe A+ - blanc",    189,    130, false);
	    
	    this.products.add(cafe);
	    this.products.add(tv);
	    this.products.add(fridge);
	    */
    	
    	// With a database in MySQL
        this.products = new ProductDAO().getAll();
    }
    
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	    resp.setContentType("text/html");

	    if (req.getQueryString() == null)
	        this.displayForm(resp);
	    else
	        this.displayBill(req, resp);
    }

	/**
	 * Displays the form for the various choices
	 * @param resp  an HttpServletResponse object that contains the response the servlet sends to the client
	 * @throws IOException
	 */
	private void displayForm(HttpServletResponse resp) throws IOException {

		Product product = null;
		
		for (int i = 0; i < this.products.size(); i++) {
			product = this.products.get(i);
            resp.getWriter().println("<b>" + i + " - " + product.getName() + "</b> : " + product.getPrice() + "<br/>" +
            					     product.getDescription() + "<br/><br/>");
		}

		String form = "<form action=\"bill\">"                                                                      +
				      "<b>nom complet :</b> <input name=\"fullname\"/><br/>"                                        +
					  "<b>adresse :</b> <input name=\"address\"/><br/><br/>"                                        +
					  "<b>livraison :</b> <br/>"                                                                    +
					  "à domicile : <input type=\"radio\" name=\"deliveryMode\" value=\"direct\"/><br/>"            +
					  "express : <input type=\"radio\" name=\"deliveryMode\" value=\"express\"/><br/>"              +
					  "point relais : <input type=\"radio\" name=\"deliveryMode\" value=\"relay\"/><br/>"           +
					  "à retirer : <input type=\"radio\" name=\"deliveryMode\" value=\"takeAway\"/><br/>"           +
					  "<b>Informations livraison</b> (relay et express) : <input name=\"deliveryInfo\"/><br/><br/>" +
					  "<b>liste produits </b> (produit:quantité, un produit par ligne) : <br/>"                     +
					  "<textarea name=\"products\"></textarea><br/>"                                                +
					  "<input type=\"submit\"/>"                                                                    +
					  "</form>";
		
		resp.getWriter().println(form);
	}
	
	/**
	 * Displays the bill
	 * @param req an HttpServletRequest object that contains the request the client has made of the servlet
	 * @param resp an HttpServletResponse object that contains the response the servlet sends to the client
	 */
	private void displayBill(HttpServletRequest req, HttpServletResponse resp) {
		
		// params gets a Map<String, String> object that contains all the parameters and their values
		Map<String, String> params = this.splitParameters(req.getQueryString());
		
		// Customer
		Customer customer = new Customer(params.get("fullname"), params.get("address"));
		
		// Delivery
		Delivery delivery = null;		
		switch(params.get("deliveryMode")) {
		
			case "direct":
				delivery = new DirectDelivery();
				break;
			case "express":
				delivery = new ExpressDelivery(params.get("deliveryInfo"));
				break;
			case "relay":
				delivery = new RelayDelivery (Integer.parseInt(params.get("deliveryInfo")));
				break;
			case "takeAway":
				delivery = new TakeAwayDelivery();
				break;
		}
		
		// Bill
		Bill bill = new Bill(customer, delivery);
		
		// Add the products to the bill
		// %0D%0A = carriage return
		String[] brutProductAndQuantity = params.get("products").split("%0D%0A");
		String[] finalProductAndQuantity = null;
		
		Product product = null;
		Integer integer = null;
		
		for (int i=0 ; i<brutProductAndQuantity.length ; i++) {
			
			// %3A = :
			finalProductAndQuantity = brutProductAndQuantity[i].split("%3A");
			
			product = this.products.get(Integer.parseInt(finalProductAndQuantity[0]));
			integer = Integer.parseInt(finalProductAndQuantity[1]);
			
			bill.addProduct(product, integer);
		}
		
		// Bill establishment
		bill.generate(new Writer() {
			
		    @Override
		    public void start() {}

		    @Override
		    public void writeLine(String line) {

		        try {
		            resp.getWriter().println("<br/>" + line);
		        } catch (IOException e) {
		           e.printStackTrace();
		        }
		    }

		    @Override
		    public void stop() {}
		});
	}
	
	/**
	 * Returns a Map<String, String> object that contains all the parameters and their values
	 * @param queryString an String object (ex: p1=v1&p2=v2)
	 * @return a Map<String, String> object that contains all the parameters and their values
	 */
	public Map<String, String> splitParameters(String queryString) {
		
		// For example: queryString equals to "p1=v1&p2=v2"
		
		// Splits the string to obtain a string array thanks to "&"
		// For example: stringArray[0]="p1=v1" and stringArray[1]="p2=v2"
		String[] stringArray = queryString.split("&");
		
		Map<String, String> params = new HashMap<>();
		
		String[] keyAndValue = null;
		
		for (int i=0 ; i<stringArray.length ; i++) {
			
			keyAndValue = stringArray[i].split("=");
			
			if(keyAndValue.length == 2)
				params.put(keyAndValue[0], keyAndValue[1]);
		}		
		
		return params;
	}
	
	//---------------------------------------------------------------------------------------------
	
	private List<Product> products = new ArrayList<Product>();
}
