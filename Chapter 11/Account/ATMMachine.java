package Account;
import java.util.Scanner;
public class ATMMachine {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account[] account = new Account[10];
		for(int i = 0; i < account.length; i++) {
			account[i] = new Account();
			account[i].setID(i);
			account[i].setBalance(100);
		}
		runATM(account, input);
	}
	public static void runATM(Account[] account, Scanner input) {
		do {
			int id = enterId(account.length, input);
			int choice;
			do {
				choice = enterMenuChoice(account, input);
				if (choice == 1) {
					displayBalance(account, id);
					System.out.println();
				}else if (choice == 2) {
					account[id].withdraw(enterWithdrawalAmount(input));
					System.out.printf("New Balance is $%.2f.\n", account[id].getBalance());
					System.out.println();
				}else if (choice == 3) {
					account[id].deposit(enterDepositAmount(input));
					System.out.printf("New Balance is $%.2f.\n",account[id].getBalance());
					System.out.println();
				}
			} while (choice != 4);
			System.out.println();
		} while (true);
	}
	
	public static void displayBalance(Account[] account, int id) {
		System.out.printf("The balance is $%.2f\n", account[id].getBalance());
	}
	
	public static int enterMenuChoice(Account[] account, Scanner input) {
		displayMenu();
		String choice;
		do {
			System.out.print("Enter a choice: ");
			choice = input.next();
		} while (!InRange(choice));
		return Integer.parseInt(choice);
	}
	
	public static double enterDepositAmount(Scanner input) {
		System.out.print("Enter an amount to deposit: ");
		return input.nextDouble();
	}
	
	public static double enterWithdrawalAmount(Scanner input) {
		System.out.print("Enter an amount to Withdrawl: ");
		return input.nextDouble();
	}
	
	public static int enterId(int n, Scanner input) {
		String id;
		do {
			System.out.print("Enter an id # 0-9: ");
			id = input.next();
		} while (!InRange(id));
		return Integer.parseInt(id);
	}
	
	public static boolean isSingleDigit(String s) {
		if (s.length() != 1) {return false;}
		if (!Character.isDigit(s.charAt(0))) {return false;}
		return true;
	}
	
	public static boolean InRange(String s) {
		if(!isSingleDigit(s)) {return false;}
		int singleDigit = Integer.parseInt(s);
		return singleDigit >= 0 && singleDigit < 10;
	}
	
	public static void displayMenu() {
		System.out.println("Main Menu");
		System.out.println("1) Current balance: ");
		System.out.println("2) Withdraw:");
		System.out.println("3) Deposit ");
		System.out.println("4) Exit to main menu");
	}
	
	public static Account[] getAccounts(int n) {
		Account[] accounts = new Account[n];
		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = new Account(i, 100.0);
		}
		return accounts;
	}
}


