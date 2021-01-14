package Account;
import java.util.*;
public class CheckingAccount extends Account{

	private double balance;
	private double overDraft;
	private Date dateCreated;

	public CheckingAccount() {
		super();
	}
	public CheckingAccount(int id, double balance, double overdraft) {
		super(id, balance);
		this.overDraft = overdraft;	
	}
	public void withdraw(double amount) {
		if (amount <= overDraft) {
			System.out.println("Your cannot overdraft that amount, try again");
		}
		else this.setBalance(this.getBalance() - amount);
	}
}

