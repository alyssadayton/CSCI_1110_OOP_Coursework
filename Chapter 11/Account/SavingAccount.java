package Account;
	public class SavingAccount extends Account{
	
	
		public SavingAccount() {
			super();
		}
		public SavingAccount(int id, double balance) {
			super(id,balance);
		}
		public void withdraw(double amount) {
			if (amount >= this.getBalance()) {
				System.out.println("That would overdraft your account, not allowed");
			}
			else this.setBalance(this.getBalance() - amount);
		}

	}


