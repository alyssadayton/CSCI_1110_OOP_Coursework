package Account;
import java.util.Date;
public class Account {
	public static void main(String[] args) {
			Account acc1 = new Account(1122, 20000);
			acc1.withdraw(2500);
			acc1.deposit(3000);
			Date datecreated = acc1.getDateCreated();
			System.out.printf("The current balance for account %s is %3.2f. The monthly interest is %3.2f. Date account was created %s",acc1.getId(), acc1.getBalance(), acc1.getMonthlyInterestRate(), acc1.getDateCreated());
		}
		private int id;
		private double balance;
		private double annualInterestRate;
		private Date datecreated;

		public Account() {
			//this(0, 0.0);
		}	
		public Account(int id, double balance) {
			this.id = id;
			this.balance = balance;
			annualInterestRate = 4.5;
			datecreated = new Date();
		}

		// setters
		public void setID(int id) {
			this.id = id;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}

		public void setAnnualInterestRate(double annualInterestRate) {
			this.annualInterestRate = annualInterestRate / 100;
		}

		public int getId() {
			return id;
		}

		public double getBalance() {
			return balance;
		}

		public double getAnnualInterestRate() {
			return annualInterestRate;
		}

		public Date getDateCreated(){
			return datecreated;
		}

		public double getMonthlyInterestRate() {
			return getAnnualInterestRate() / 12;
		}

		// instance methods
		public double getMonthlyInterest() {
			return getBalance() * getMonthlyInterestRate();
		}

		public void withdraw(double amount) {
			setBalance(getBalance() - amount);
		}

		public void deposit(double amount) {
			setBalance(getBalance() + amount);
		}
		
		public String toString() {
			return "balance: " + getBalance() + "\nmonthly interest: " +
					getMonthlyInterest() + "\ndate created: " + getDateCreated();
		}
	}


