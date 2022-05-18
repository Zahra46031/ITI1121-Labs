
public class NotEnoughMoneyException extends IllegalStateException {
	private double withdraw;
	private double b;
	public NotEnoughMoneyException(double d, double balance) {
		withdraw = d;
		b = balance;
	}
	public double getAmount() {
		
		return withdraw;
	}
	public double getBalance() {
		
		return b;
	}
	public double getMissingAmount() {
		return withdraw - b;
	}
	
	public String getMessage(){
		return ("You do not have enough money to withdraw " + b + "$");
	}


}
