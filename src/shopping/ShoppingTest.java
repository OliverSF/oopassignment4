package shopping;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShoppingTest {
	
	//declaring variables
	Customer customer;
	ShoppingCart cart;
	Order o;
	Payment p;
	Email e;
	
	int cost1;
	int cost2;
	int cost3;
	int cost4;
	
	Item item1;
	Item item2;
	Item item3;
	Item item4;
	
	
	@Before
	public void setUp() throws Exception {
		
		//initialising varables
		customer = new Customer();
		cart  = new ShoppingCart();
		customer.addCart(cart);
		e = new Email();
		p = new Payment();
		
		
		//setting costs to be added to items
		cost1 = 15;
		cost2 = 30;
		cost3 = 10;
		cost4 = 10;
		
		//creating items
		item1 = new Item(12345666L);
		item2 = new Item(123453456L);
		item3 = new Item(33334566L);
		item4 = new Item(444333222L);
		
		//setting cost for items
		item1.setCost(cost1);
		item2.setCost(cost2);
		item3.setCost(cost3);
		item4.setCost(cost4);
		
		//adding items to cart
		cart.addItem(item1);
		cart.addItem(item2);
		cart.addItem(item3);
	}
	
	@Test
	public void totalcosttest() {
		
		//setting expected results
		int expectedTotal = 55;
		
		//results returned from code
		int actualTotal = cart.getTotal();
		
		//asserting that the expectedTotal '55' should equal the returned actualTotal
		assertEquals(expectedTotal, actualTotal);
	}
	
	@Test
	public void totalCartItemsAdd() {

		// adding 4th item to shopping cart
		cart.addItem(item4);
		
		//setting expected results
		int expectedTotalItems = 4;
		
		//results returned from code
		int actualTotalItems = cart.getTotalItems();
		
		//asserting that the expectedTotalItems 4, should equal actualTotalItems
		assertEquals(expectedTotalItems, actualTotalItems);
	}
	
	@Test
	public void newCartTotal (){
		
		// adding 4th item to shopping cart
		cart.addItem(item4);
		
		//setting expected results
		int expectedTotal = 65;
				
		//results returned from code
		int actualTotal = cart.getTotal();
		
		//asserting that the new expectedTotal '65' should equal the returned actualTotal
		assertEquals(expectedTotal, actualTotal);
		
	}
	
	
	@Test
	public void totalCartItemsRemove(){
		
		cart.remove(item2);
		
		//setting expected results
		int expectedTotalItems = 2;
				
		//results returned from code
		int actualTotalItems = cart.getTotalItems();
				
		//asserting that the expectedTotalItems 2, should equal actualTotalItems
		assertEquals(expectedTotalItems, actualTotalItems);
	}
	
	@Test
	public void checkOrderTotal(){
		
		int expectedTotal = 55;
		
		//creating new order by calling finalise method
		o = cart.finalise();
		
		//initialising variable
		int totalOrderCost = 0;
		
		//using enhanced for loop to iterate over new ArrayList to check total is still correct
		for(Item p : o.getOrderlist()){
			totalOrderCost += p.getCost();
		}
		
		//asserting that the total from order is the same that was in cart
		assertEquals(expectedTotal, totalOrderCost);
	}
	
	@Test
	public void addressTest(){
		
		String expectedAddress = "address1";
		//creating new order by calling finalise method
		Order o = cart.finalise();
		//creating new Address object, setting and adding to order
		Address billingAddress = new Address();
		billingAddress.setAddress("address1");
		o.setOrderAddress(billingAddress);
		
		//enhanced for loop to get Address object
		for(Address p : o.getAddresslist()){
			String actualAddress = p.getFulladdress();
			
			//asserting that the expected address equals the actual address
			assertEquals(expectedAddress, actualAddress);
		}	
	}
	
	@Test
	public void paymentVerification(){
		
		//creating new order by calling finalise method
		o = cart.finalise();
		
		//adding a string of numbers 
		p.setCardNumber("1231231213113111");
		o.setPayment(p);
		
		//try catch to validate payment
		try{
			o.validatePayment();
		}
		catch(UnsupportedPaymentMethodException i){
			System.out.println(i.getMessage());
		}
		
		//asserting that the payment method is correct
		assertTrue(o.isIsvalid());
	}
	
	
	@Test
	public void paymentVerificationFailure(){
		
		//creating new order by calling finalise method
		o = cart.finalise();
		
		//adding a string of numbers 
		p.setCardNumber("ABC231213113111");
		o.setPayment(p);
		
		//try catch to validate payment
		try{
			o.validatePayment();
		}
		catch(UnsupportedPaymentMethodException i){
			System.out.println(i.getMessage());
		}
		
		//asserting that the payment method is incorrect due to letters in card number
		assertFalse(o.isIsvalid());
	}
	
	@Test
	public void paymentVerificationFailureNumbers(){
		
		//creating new order by calling finalise method
		o = cart.finalise();
		
		//adding a string of numbers 
		p.setCardNumber("13113111");
		o.setPayment(p);
		
		//try catch to validate payment
		try{
			o.validatePayment();
		}
		catch(UnsupportedPaymentMethodException i){
			System.out.println(i.getMessage());
		}
		
		//asserting that the payment method is incorrect due to few card numbers
		assertFalse(o.isIsvalid());
	}
	
	@Test
	public void testUnsupportedPayment() {
		boolean exceptionThrown = false;
		
		//creating new order by calling finalise method
		o = cart.finalise();
				
		//adding a string of numbers 
		p.setCardNumber("12AB231213113111");
		o.setPayment(p);
		
		//try catch to validate payment
		try{
			o.validatePayment();
		}
		catch(UnsupportedPaymentMethodException i){
			System.out.println(i.getMessage());
			exceptionThrown = true; // if the Exception is thrown and caught 
		}
		assertTrue(exceptionThrown);
	
	}
	
}
