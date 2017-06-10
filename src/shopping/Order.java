package shopping;

import java.util.ArrayList;

public class Order {
	
	//declaring and creating needed items
	private ArrayList<Item> orderlist;
	private ArrayList<Address> addresslist = new ArrayList<Address>();
	Payment payment;
	private boolean isvalid;
	
	//getter for isvalid boolean
	public boolean isIsvalid() {
		return isvalid;
	}
	//default constructor
	public Order(){
		
	}
	
	//setter for order list to be called in finalise method
	public void setOrderList(ArrayList<Item> list) {
		this.orderlist = list;
		
	}
	
	//getting for orderlist
	public ArrayList<Item> getOrderlist() {
		return orderlist;
	}

	//adding Credit card information to the order
	public void setPayment(Payment p) {
		this.payment = p;
		
	}

	//setter to instantiate Address arrayList and add items
	public void setOrderAddress(Address Addressitem) {
		
		addresslist.add(Addressitem);	
	}
	
	//getter for the Address ArrayList
	public ArrayList<Address> getAddresslist() {
		return addresslist;
	}

	//method to validate payment information passed
	public void validatePayment() throws UnsupportedPaymentMethodException {


		boolean parsable = false;
	    //try catch to see if credit card number only contains numbers
		try{
	        Long.parseLong(payment.getCardNumber());
	        parsable = true;
	    }catch(NumberFormatException e){
	        parsable = false;
	    }
		
		//setting isvalid to true if it passes tests
		if((payment.getCardNumber().length() == 16) && parsable == true){
				this.isvalid = true;
		}
		
		//setting isvalid to false if number card info fails tests and throwing exception
		else{
			this.isvalid = false;
			throw new UnsupportedPaymentMethodException("Unsupported Payment Type");
			
		}
	}

}
