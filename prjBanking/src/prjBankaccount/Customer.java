package prjBankaccount;

public class Customer {
	
	
	private String customerName;
	private String customerID;
	private String customerEmail;
	private String customerPhone;
	private String customerAddress;
	private int customerPin;
	
	public Customer() {
		super();
		this.customerName = "";
		this.customerID = "";
		this.customerEmail = "";
		this.customerPhone = "";
		this.customerAddress = "";
		this.customerPin = 0; 
	}
	
	public Customer(String customerName, String customerID, String customerEmail, String customerPhone,
			String customerAddress, int customerPin) {
		super();
		this.customerName = customerName;
		this.customerID = customerID;
		this.customerEmail = customerEmail;
		this.customerPhone = customerPhone;
		this.customerAddress = customerAddress;
		this.customerPin = customerPin;
	}

	public int getCustomerPin() {
		return customerPin;
	}

	public void setCustomerPin(int customerPin) {
		this.customerPin = customerPin;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	
	
}
