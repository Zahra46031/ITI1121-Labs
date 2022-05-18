
public class Account{
	double balance;
	public Account() {
		balance = 0;
	}

	public void deposit(double d) {
		this.balance += d;
		System.out.println(this.balance);
		
	}

	public void withdraw(double d) {
		if(d > this.balance)
			throw new NotEnoughMoneyException(d, balance);
		else {
			this.balance -= d;
			System.out.println(this.balance);
		}
		
	}

	public double getBalance() {
		return balance;
	}


	
}
