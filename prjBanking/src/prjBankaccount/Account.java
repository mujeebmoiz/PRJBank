package prjBankaccount;

public class Account {
	private int accountNumber;
	private String accountType; 
	private float balance;  
	private String accountID;
	
	public Account() {
		super();
		this.accountNumber = 0;
		this.accountType = "";
		this.balance = 0;
		this.accountID = "";
	}
	
	public Account(int accountNumber, String accountType, float balance, String accountID) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
		this.accountID = accountID;
	}
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getAccountID() {
		return accountID;
	}

	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
    
	
	
}
