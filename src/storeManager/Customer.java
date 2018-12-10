package storeManager;

public class Customer {

	/**
	 * Customer constructor with two arguments of String type
	 * @param fullName The full name
	 * @param address The address
	 */
	public Customer(String fullName, String address) {
		this.fullName = fullName;
		this.address = address;
	}	
	
	//---------------------------------------------------------------------------------------------
	
	/**
	 * Returns a String which corresponds to the full name
	 * @return The full name
	 */
	public String getFullName() { 
		return this.fullName; 
	}
	
	/**
	 * Returns a String which corresponds to the customer address
	 * @return The address
	 */
	public String getAddress() { 
		return this.address; 
	}
	
	//---------------------------------------------------------------------------------------------
	
	private String fullName;
	private String address;
}