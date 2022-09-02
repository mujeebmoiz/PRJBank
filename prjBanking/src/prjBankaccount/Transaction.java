package prjBankaccount;


public class Transaction
{
	private int transNumber;
	private int custNumer;
	private int accNumber;
	private char transType;
	private String transDate;
	private float transAmount;
	
	
	public Transaction(int transNumber, int custNumer, int accNumber, char transType, String transDate,
			float transAmount)
	{
		super();
		this.transNumber = transNumber;
		this.custNumer = custNumer;
		this.accNumber = accNumber;
		this.transType = transType;
		this.transDate = transDate;
		this.transAmount = transAmount;
	}


	public int getTransNumber()
	{
		return transNumber;
	}


	public void setTransNumber(int transNumber)
	{
		this.transNumber = transNumber;
	}


	public int getCustNumer()
	{
		return custNumer;
	}


	public void setCustNumer(int custNumer)
	{
		this.custNumer = custNumer;
	}


	public int getAccNumber()
	{
		return accNumber;
	}


	public void setAccNumber(int accNumber)
	{
		this.accNumber = accNumber;
	}


	public char getTransType()
	{
		return transType;
	}


	public void setTransType(char transType)
	{
		this.transType = transType;
	}


	public String getTransDate()
	{
		return transDate;
	}


	public void setTransDate(String transDate)
	{
		this.transDate = transDate;
	}


	public float getTransAmount()
	{
		return transAmount;
	}


	public void setTransAmount(float transAmount)
	{
		this.transAmount = transAmount;
	}
	
	
	
	
}
