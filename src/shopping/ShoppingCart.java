package shopping;

//inporting necessary packages
import java.util.*;

public class ShoppingCart {
	
	//creating ArrayList to hold multiple items
	private ArrayList<Item> list;
	
	//constructor
	public ShoppingCart(){
		list = new ArrayList<Item>(5);
	}
	
	
	//method to add items to array list
	public void addItem(Item item1) {
		this.list.add(item1);
		
	}

	//method to get total of the cart
	public int getTotal() {
		int total = 0;
		
		for(Item it : list){
			
			total=total + it.getCost();
		}
		
		return total;
	}

	//method to remove item from cart
	public void remove(Item item4) {
		list.remove(item4);
		
	}

	//method to get total items in cart
	public int getTotalItems() {
		
		int itemCount = list.size();
		
		return itemCount;
	}

	//finalise method to create an order and pass all items from cart to it
	public Order finalise() {
		
		Order order1 = new Order();
		
		order1.setOrderList(list);
		
		return order1;
	}

}
