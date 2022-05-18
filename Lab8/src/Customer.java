import java.util.Random;

public class Customer {
	int arrivalTime;
	int initialNumberOfItems;  
	int numberOfItems;
	final int MAX_NUM_ITEMS;

	public Customer(int currentTime) {
		this.arrivalTime = currentTime;
		this.MAX_NUM_ITEMS = 25;
		Random generator;  
		generator = new Random();  
		 
		initialNumberOfItems = generator.nextInt(MAX_NUM_ITEMS-1)+1;
		this.numberOfItems = initialNumberOfItems;
	}

	public int getNumberOfItems() {
		
		return numberOfItems;
	}

	public int getArrivalTime() {
		
		return this.arrivalTime;
	}

	public void serve() {
		this.numberOfItems--;
		
	}

	public int getNumberOfServedItems() {
		
		return this.initialNumberOfItems - this.numberOfItems;
	}

}
