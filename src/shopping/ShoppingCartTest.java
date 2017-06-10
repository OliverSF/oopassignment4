package shopping;

public class ShoppingCartTest {

	public static void main(String[] args) {
		
		//creating customer a shopping cart object
		Customer customer = new Customer();
		ShoppingCart cart  = new ShoppingCart();
		
		//adding cart to customer
		customer.addCart(cart);
		
		//creating cost variables
		int cost1 = 15;
		int cost2 = 30;
		int cost3 = 10; //total will be 55
		
		//creating cost items and setting cost
		Item item1 = new Item(12345666L);
		item1.setCost(cost1);
		
		Item item2 = new Item(12345345L);
		item2.setCost(cost2);
		
		Item item3 = new Item(33334566L);
		item3.setCost(cost3);
		
		//adding items to cart
		cart.addItem(item1);
		cart.addItem(item2);
		cart.addItem(item3);
		
		//setting total equal to total cost of items
		int total = cart.getTotal();
		
		//adding up items in basket to get cost
		int actual = cost1 + cost2 + cost3;
		
		//testing if actual and total are the same
		if(total == actual){
			System.out.println("getTotal is correct");
		}
		else{
			System.out.println("getTotal is wrong");
			System.out.println("expected" + actual);
			System.out.println("returned" +  total);
		}
		
		//creating 4th item to be added to cart as per instructions
		Item item4 = new Item(444333222L);
		
		//creating cost for 4th item
		int cost4 = 10;
		//setting cost of 4th item
		item4.setCost(cost4);
		
		//adding 4th item to shopping cart
		cart.addItem(item4);
		
		//setting total equal to new cart cost total
		total = cart.getTotal();
		
		//adding up items to get actual cost
		actual = cost1 + cost2 + cost3 + cost4;
		
		//testing if actual and total are the same
		if(total == actual){
			System.out.println("getTotal is correct");
		}
		else{
			System.out.println("getTotal is wrong");
			System.out.println("expected" + actual);
			System.out.println("returned" +  total);
		}
		
		//removing item from cart
		cart.remove(item4);
		
		//Small test in main, full in unit test
		int totalItems = cart.getTotalItems();
		
		int actualItems = 3;
		
		if(totalItems == actualItems){
			System.out.println("getTotalItems is correct");
		}
		else{
			System.out.println("getTotalItems is wrong");
		}
		
		//creating new order by calling finalise method
		Order o = cart.finalise();
		
		//initialising variable
		int totalOrderCost = 0;
		
		//using enhanced for loop to iterate over new ArrayList to check total is still correct
		for(Item p : o.getOrderlist()){
			System.out.println(p.getCost());		
			totalOrderCost += p.getCost();
			
		}
		System.out.println(totalOrderCost);
		
		//creating new Address object, setting and adding to order
		Address billingAddress = new Address();
		billingAddress.setAddress("Knocknacarra Rd, Knocknacarra, Galway");
		o.setOrderAddress(billingAddress);
		
		//creating new Address object, setting and adding to order
		Address deliveryAddress = new Address();
		deliveryAddress.setAddress("Lettergesh, Renvyle, Galway");
		o.setOrderAddress(deliveryAddress);
		
		//enhanced for loop to print address
		for(Address a : o.getAddresslist()){
			System.out.println(a.getFulladdress());
		}
		
		System.out.print("\n");
		//creating new payment object
		Payment p = new Payment();
		
		//adding a string of numbers so that these can be parsed for ints later as a test (16 digits)
		p.setCardNumber("1231231211113111");
		
		o.setPayment(p);
		
		//creating a new email object
		Email e = new Email();
		
		//try catch to validate payment and get Exception if unsuccessful 
		try{
			o.validatePayment();
		}
		catch(UnsupportedPaymentMethodException i){
			System.out.println(i.getMessage());
		}
		
		//if validatePayment is successful calling successMessage
		if(o.isIsvalid()){	
	
			e.successMessage(o);

		}
		//if validatePayment is unsuccessful calling failMessage
		else{
			
			e.failMessage();

		}
	}
		
}

