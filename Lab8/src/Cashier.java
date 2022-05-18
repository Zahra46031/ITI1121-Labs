
public class Cashier {
	Customer currentCustomer;
	int totalCustomerWaitTime;
	int customersServed;
	int totalItemsServed;
	Queue<Customer> line = new ArrayQueue<Customer>();
	boolean flag = false;
	
	public Cashier() {
		this.customersServed = 0;
		this.totalCustomerWaitTime = 0;
		this.totalItemsServed = 0;
	}

	public void addCustomer(Customer customer) {
		if(customer == null)
			throw new NullPointerException(); 
		line.enqueue(customer);
		
		
	}

	public void serveCustomers(int currentTime) {
		if(line.size() == 0) {
			return;
		}	
		if(!flag) {
			currentCustomer = line.dequeue();
			flag = true;
			
		}
		if(flag) {
			while(currentCustomer.getNumberOfItems() != 0) {
				currentCustomer.serve();
				totalItemsServed++;
			}
			customersServed++;
			flag = false;
	        totalCustomerWaitTime += currentTime - currentCustomer.getArrivalTime();
			
		}	
	}

	public Object getTotalCustomerWaitTime() {

		
		return this.totalCustomerWaitTime;
	}

	public Object getTotalItemsServed() {
		
		return this.totalItemsServed;
	}

	public int getTotalCustomersServed() {
		
		return this.customersServed;
	}

	public Object getQueueSize() {
	
		return line.size();
	}

}
