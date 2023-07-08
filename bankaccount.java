public class bankaccount{


	// instance variables
	String name;
	private double balance;
	int accountPin = 1234;
	int pin;
	boolean standardAccount = true;
	boolean premiumAccount = true;
	
	// Set Methods
	public void setBalance(double balance){
		if (balance >= 500){
			this.balance = balance;
		}
		else {
			System.out.println("Initial deposit cannot be less than 500 RS.");
		}
	}
	
	// Get Methods
	public double getBalance(){
		return balance;
	}
	

	// behaviour/methods
	double deposit(double amount){
		if(balance >= 100000){
			balance = balance + amount + (amount * 0.01);
		}
		else{
			balance = balance + amount;
		}
		return balance;
	}
	
	double withdraw(double amount){
		if(balance <= 50000){
			balance = balance - amount - (amount * 0.02);
		}
		else{
			balance = balance - amount;
		}
		return balance;
	}
}