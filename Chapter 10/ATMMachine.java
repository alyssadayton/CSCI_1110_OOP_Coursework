import java.util.*;

public class ATMMachine {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Account[] account = new Account[10];
		for(int i = 0; i < account.length; i++) {
			account[i] = new Account();
			account[i].setID(i);
			account[i].setBalance(100);
		}
		int user = 0;
		while(true) {
			System.out.println("Enter Account # 0-9: ");
			int id = input.nextInt();
			while (id < 0 && id > 9) {
				System.out.println("Please enter a valid id");
				System.out.println("Enter Account # 0-9: ");
				id = input.nextInt();
			}
			System.out.println("Main Menu");
			System.out.println("1) Current balance: ");
			System.out.println("2) Withdraw:");
			System.out.println("3) Deposit ");
			System.out.println("4) Exit to main menu");
			user = input.nextInt();
			while (user != 4) {
				if(user == 1) {
					System.out.printf("Your balance is: %3.2f", account[id].getBalance());
					System.out.println();
				}
				if( user == 2) {
					double withdraw = 0;
					System.out.println("Enter the amount to withdraw: ");
					System.out.println();	
					withdraw = input.nextInt();
					System.out.printf("Your balance is: %3.2f",account[id].getBalance());
					System.out.println();
				}
				if(user == 3) {
					double deposit = 0;
					System.out.println("Enter the amount you want to deposit: ");
					System.out.println();
					deposit = input.nextInt();
					account[id].deposit(deposit);
					System.out.printf("Your balance is: %3.2f", account[id].getBalance());
					System.out.println();
				}
			}
		}
	}
}

