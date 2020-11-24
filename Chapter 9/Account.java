
public class Account {
	public static void main(String[] args) {
	Account acc1 = new Account(1122, 20000, 4.5);
	acc1.withdraw(2500);
	acc1.deposit(3000);
	java.util.Date datecreated = acc1.getDateCreated();
	System.out.printf("The current balance for account %s is %3.2f. The monthly interest is %3.2f. Date account was created %s",acc1.getId(), acc1.getBalance(), acc1.getMonthlyInterestRate(), acc1.getDateCreated());
	}
	private double monthlyInterestRate;
	private int id;
	private double balance;
	private double annualInterestRate;
	private java.util.Date datecreated;
	
	public Account() {
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		datecreated = new java.util.Date();
	}	
	public Account(int newId, double newBalance, double newAnnualInterestRate) {
		id = newId;
		balance = newBalance;
		annualInterestRate = newAnnualInterestRate;
		datecreated = new java.util.Date();
	}
	public void setID(int id) {
		this.id = id;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getId() {
		return id;
	}
	public double getBalance() {
		return balance;
	}
	public double getAnnualInterestRate() {
		return annualInterestRate / 100;
	}
	public java.util.Date getDateCreated(){
		return datecreated;
	}
	public double getMonthlyInterestRate() {
		return annualInterestRate / 12;
	}
	public double getMonthlyInterest() {
		return balance * monthlyInterestRate;
	}
	public void withdraw(double withdrawn) {
		balance = balance - withdrawn;
	}
	public void deposit(double deposited) {
		balance = balance + deposited;
	}
}
