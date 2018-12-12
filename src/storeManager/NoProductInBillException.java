package storeManager;

public class NoProductInBillException extends RuntimeException {

	/**
	 * NoProductInBillException constructor with the an argument of String type
	 * @param message The message
	 */
	public NoProductInBillException(String message) {
		super(message);
	}
}
