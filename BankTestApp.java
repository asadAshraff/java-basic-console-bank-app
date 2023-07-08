
import java.util.Scanner;

public class BankTestApp{
	
	public static void main(String[] args){
		
		// initializing input
		Scanner input = new Scanner(System.in);
		// initializing object
		bankaccount obj = new bankaccount();
		
		// Getting the name on console
		System.out.println("Please Enter Your Name: ");
		obj.name = input.nextLine();
		
		
		
		// initializing counting variables
		int withdrawCount = 0;
		int depositCount = 0;
		
		
		// printing the menu
		System.out.println("Welcome " + obj.name);
			// initial deposit on console
		System.out.println("Please enter amount of your initial deposit.");
		double initialDeposit = input.nextDouble();
		obj.setBalance(initialDeposit);
		depositCount = 1;
		
		// Validating the input
		int menuSelection = 0;
		
		// Loop for prompt
		while(menuSelection != 4){
			System.out.println("Main Menu: \nPress 1: To Deposit an amount \nPress 2: To Withdraw an amount \nPress 3: To View the current balance \nPress 4: To Close this program");
			menuSelection = input.nextInt();

			// Menu Selection 1
			if (menuSelection == 1){
				System.out.println("Enter the amount you want to deposit.");
				double deposit = input.nextInt();
				obj.deposit(deposit);
				depositCount++;
				System.out.printf("You have successfully depositted %.2f RS, your new Bank Balance is %.2f.\n", deposit, obj.getBalance());
			}

			// Menu Selection 2
			else if (menuSelection == 2){
				System.out.println("Enter the amount you want to withdraw.");
				double withdraw = input.nextInt();
				
				if(withdraw > obj.getBalance()){
					System.out.println("Not enough balance.");
					menuSelection = 4;
				}
				
				// Verifying balance < 50000 (implementing a policy)
				else if (withdraw < obj.getBalance()) {
					if(obj.getBalance() <= 50000){
					System.out.println("Are you sure you want to withdraw, it would make your balance below 50,000. Press 1 to continue and 0 to abort.");
					int confirmTax = input.nextInt();
					if(confirmTax == 1){
						obj.withdraw(withdraw);
						withdrawCount++;
						System.out.printf("You have successfully withdraw %.2f RS, your new Bank Balance is %.2f.\n", withdraw, obj.getBalance());
					}
					else{
						menuSelection = 4;
					}
				}
					
				}
				else {
					obj.withdraw(withdraw);
					withdrawCount++;
					System.out.printf("You have successfully withdraw %.2f RS, your new Bank Balance is %.2f.\n", withdraw, obj.getBalance());
				}
				
			}

			// Menu Selection 3
			else if (menuSelection == 3){
				System.out.printf("Account Balance: %.2f\n", obj.getBalance());
			}

			// Menu Selection 4
			else if (menuSelection == 4){
				System.out.printf("Account Title: %s \nTotal Deposits: %d \nTotal Withdraws: %d \nAccount Balance: %.2f \n", obj.name, depositCount, withdrawCount, obj.getBalance());
				System.out.println("Have a great day!");
			}
		}
	}
}