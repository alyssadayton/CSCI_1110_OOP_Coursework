
public class Account {
	public static void main(String[] args) {
	Account acc1 = new Account(1122, 20000, 4.5, 2500, 3000);
	java.util.Date datecreated = acc1.getDateCreated();
	System.out.printf("The current balance for account %s is %3.2f. The monthly interest is %3.2f. Date account was created %s",acc1.getId(), acc1.getBalance(), acc1.getMonthlyInterestRate(), acc1.getDateCreated());
	}
	private double withdrawn;
	private double deposited;
	private double monthlyInterestRate;
	private int id;
	private double balance;
	private double annualInterestRate;
	private java.util.Date datecreated;
	
	public Account() {
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		withdrawn = 0;
		deposited = 0;
		datecreated = new java.util.Date();
	}
	
	public Account(int newId, double newBalance, double newAnnualInterestRate, double newWithdrawn, double newDeposited) {
		id = newId;
		balance = newBalance;
		annualInterestRate = newAnnualInterestRate;
		withdrawn = newWithdrawn;
		deposited = newDeposited;
	
		datecreated = new java.util.Date();
	}
	
	public int getId() {
		return id;
	}
	public double getBalance() {
		return balance - withdrawn + deposited;
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
	public double withdraw() {
		return balance - withdrawn;
	}
	public double deposit() {
		return balance + deposited;
	}
}
