package Account;
public class TestSavingsChecking{
	public static void main(String[] args) {
		SavingAccount account = new SavingAccount(1, 300);
		CheckingAccount account1 = new CheckingAccount(1, 400, -100);
		account.withdraw(400.00);
		account1.withdraw(500.00);
		System.out.printf("Savings Account Balance is %3.2f. \nDate Account was Created %s", account.getBalance(), account.getDateCreated());
		System.out.printf("\nChecking Account Balance is %3.2f. \nDate Account was Created %s", account1.getBalance(), account1.getDateCreated());
	}
}