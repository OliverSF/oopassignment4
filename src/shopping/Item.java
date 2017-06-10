package shopping;

public class Item {
	
	//creating variables
	private long itemId;
	private int cost;
	
	//constructor
	public Item(long id) {
		this.itemId = id;
	}
	
	//setter for cost
	public void setCost(int cost1) {
		this.cost = cost1;
	}
	
	//getter for cost
	public int getCost() {
	
		return cost;
	}
	
	//getter for item id
	public long getItemId() {
		return itemId;
	}
}
