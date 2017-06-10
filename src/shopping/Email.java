package shopping;


public class Email {
	

	//method to print a success order
	public void successMessage(Order o) {

		int totalFinalOrderCost = 0;
		
		System.out.println("Order Summary: ");
		//enhanced for loop to print out the Items (by their id)
		for(Item i : o.getOrderlist()){
			System.out.println("ItemID: " + i.getItemId() + " Item Cost: €" + i.getCost());
			totalFinalOrderCost += i.getCost();
			//Also wants the individual item costs beside the item id
			//should have e.setMessage(i.getItemId() + totalFinalOrderCost); eventually
		}
		System.out.println("\nTotal Cost: €" + Integer.toString(totalFinalOrderCost));
		System.out.println("Order Successful!");
		//System.out.println(e.send());
	}
	
	//method to print a failed order
	public void failMessage(){
		
		System.out.println("Unfortunately your order has being unsuccessful at this time");
	}
}
