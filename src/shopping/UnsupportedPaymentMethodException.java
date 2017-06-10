package shopping;

public class UnsupportedPaymentMethodException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9188680845811517874L;
	
	
	public UnsupportedPaymentMethodException (String msg){
		super(msg);
	}
}
