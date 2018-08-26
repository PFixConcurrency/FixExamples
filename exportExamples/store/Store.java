package store;

public class Store {
	private int customerCost;
	
	public Store() {
		customerCost = 0;
	}
	
	//forgot to add 'synchronized' to this function;
	public void consume(int cost) {
synchronized (this){ 		customerCost += cost;
}	}
	
	public int getCost() {
synchronized (this){ 		return customerCost;
}	}
}
