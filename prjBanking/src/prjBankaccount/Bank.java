package prjBankaccount;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.*;

class Bank {
		int selUser;
		int transNumber;
		final int C_SIZE = 3;
		final int A_SIZE = 6;
		Customer clients[];
	    Account accts[];
	    BufferedReader input;
	    ArrayList<Transaction> transactions;
	    String bankName;
	    String bankAddress;
	    String businessPhone;
	    
	    public Bank() {
	    	selUser = 0; 
	    	clients = new Customer[C_SIZE];
		    accts = new Account[A_SIZE];
		    input = new BufferedReader(new InputStreamReader(System.in));
		    transactions = new ArrayList<Transaction>();
		    bankName = "Moix";
		    bankAddress = "277 Silver Lane Hicksville, NY 11720";
		    businessPhone = "631-820-1992";
	    }
	  
	//LoadCustomers.dat
	public void loadCustomers() throws IOException {
	    	
			      FileReader myCust = new FileReader("customers.dat");
			      BufferedReader custReader = new BufferedReader(myCust);
			      
			      int cusCode = 0;
			      int ai = 0; 
			      String cusName = "", cusPhone = "", cusEmail = "", cusAddress = "", cusID = "";
			      
				  
		    	  String eachLine = "";
		    	  StringTokenizer st;
		    	  
		    	  eachLine = custReader.readLine();
		    	  
			  while (eachLine != null) {
				 
				  st = new StringTokenizer(eachLine, ",");
				  while(st.hasMoreTokens()) 
				  {   	  		  
				    	  //public Customer(String customerName, String customerID, String customerEmail, String customerPhone,
				    		//		String customerAddress, int customerPin)
						      
					  		  cusName = st.nextToken();
				    		  cusID = st.nextToken();
				    		  cusEmail = st.nextToken();
				    		  cusPhone = st.nextToken();
				    		  cusAddress = st.nextToken();
				    		  cusCode = Integer.parseInt(st.nextToken());
				    		  
				    		  
				    		  clients[ai] = new Customer(cusName,cusID,cusEmail,cusPhone,cusAddress,cusCode);
						      ai++;
						      eachLine = custReader.readLine();
			      }
			  }
			      custReader.close();
			      System.out.println("Customers loaded");

			    } 
	//LoadAccounts.dat
	public void loadAccounts() throws IOException {
			
			      FileReader myAcct = new FileReader("accounts.dat");
			      BufferedReader acctsReader = new BufferedReader(myAcct);
			      
			      int i = 0; 
			      int acctNumber = 0;
		    	  String acctType = "";
		    	  float acctBalance = 0f;
		    	  String acctID = "";
			      
			      String each = "";
		    	  StringTokenizer sti;
		    	  each = acctsReader.readLine();
		   
			      while (each != null) {
			    	  sti = new StringTokenizer(each, ",");
	    	  
			    	  while(sti.hasMoreTokens()) {
			    		  
			    	
			    	  //public Account(int accountNumber, String accountType, float balance, String customerID)
			    	  
			    	  acctNumber = Integer.parseInt(sti.nextToken());
			    	  acctType = sti.nextToken();
			    	  acctBalance = Float.parseFloat(sti.nextToken());
			    	  acctID = sti.nextToken();
			    	  
			    	  accts[i]= new Account(acctNumber,acctType,acctBalance,acctID);
			    	  i++;
			      	each = acctsReader.readLine();
			    	  }//Close of inner while 
			      }//Close of outer while
			      acctsReader.close();
			      System.out.println("Accounts loaded");
			      System.out.println();
			    } 
		
	//Welcome Menu
	public void welcomeMenu() {
			
		   
		    System.out.println("Welcome to " + bankName + " Banking System"); 
		    
		}
		
	//Update Transactions
	void updateTransactions(int accNumber, char transType, float transAmount)
	{	
		LocalDateTime currentDT = LocalDateTime.now(); 
		String transDate = currentDT.toString(); 
		transactions.add(new Transaction(transNumber,selUser,accNumber,transType,transDate,transAmount));
		

	}

	//Write transactions
	void writeTrans() throws IOException
	{
		 FileWriter transWriter = new FileWriter("transactions.txt", true); //open the file for appending
		 BufferedWriter bw = new BufferedWriter(transWriter);

		 for (int i = 0; i <transactions.size(); i++)
		{
			 bw.write(transactions.get(i).getTransNumber() + "," + 
							 transactions.get(i).getAccNumber() +"," + 
							 transactions.get(i).getTransAmount() + "," + 
							 transactions.get(i).getTransType() +"," +
			 				 transactions.get(i).getTransDate() + "\n");
		}
	    bw.close();
		System.out.println("Transaction File Written!");
		
	}
		
	//Show Menu
	void showMenu() throws IOException{
		
		String option2 = ""; 
		int option = 0;
		Date date = new Date(); // the date instance
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int currentyear = 0, currentmonth =0, currentday = 0;
		currentyear = calendar.get(Calendar.YEAR);
		currentmonth = calendar.get(Calendar.MONTH);
		currentday = calendar.get(Calendar.DAY_OF_MONTH);
		
		
		System.out.println("What type of transaction would you like to process?");
		System.out.println();
		System.out.println("1. Make a deposit");
		System.out.println("2. Make a withdrawl");
		System.out.println("3. Check your Accounts");
		System.out.println("4. Make a transfer");
		System.out.println("5. Exit");
		System.out.println();
		System.out.print("Enter an option: ");
		
			option2 = input.readLine();
			 option = Integer.parseInt(option2);
			
			// 1 - Deposit, 2- Withdraw, 3- show account, 4 - transfer 5 - exit 	
		
			switch(option) {
			case (1):
				deposit();
				break;
			
			case (2):
				withDraw();
				break;
			
			case (3): 
				showAccount();				
				break;
			
			case (4):
				if(withDraw()) {
					deposit();
				}
				
				break;

			case (5):
				writeTrans();
				System.out.println();
				System.out.println("-------------------------------");
				System.out.println("Todays date is: " + currentmonth + "/" + currentday + "/" +currentyear);
				System.out.println("Thank you for banking with, " + bankName +  " Banking System!");
				System.out.println(bankAddress);
				System.out.println(businessPhone);
	        	System.out.println("-------------------------------");
				System.exit(0);
				break;
				
			default:
				System.out.println("Error: invalid option. Please enter 1-5 to access services");
				break;
			}//End of Switch Statement 
		//End of While
		}//End of ShowMenu
		
	//Deposit
	void deposit() throws IOException {
			String option = "";
			int choice = 0;
			float amount = 0f;
			String selType = "";
			String choice2 = "";
			
			System.out.println("Which account would you like to deposit in?");
			System.out.println();
			System.out.println("1.Checking");
			System.out.println("2.Savings"); 
			System.out.println();
			
			
			System.out.print("Enter an option: ");
			choice2 = input.readLine();
			choice = Integer.parseInt(choice2);

			
			if (choice == 1)
			{
				System.out.println("You have selected your Checking Account");
				selType = "Checking";

			} else if (choice == 2)
			{
				System.out.println("You have selected your Savings Account");
				selType = "Savings";
			}
			
			
				System.out.println();
				System.out.print("Enter an amount to deposit: ");
				option = input.readLine();
				amount = Float.parseFloat(option);
			
			for (int i = 0; i < A_SIZE; i++)
		{
				if(clients[selUser].getCustomerID().equals(accts[i].getAccountID()) && selType.equals(accts[i].getAccountType())) {
			if(amount != 0){
				accts[selUser].setBalance(accts[selUser].getBalance() + amount);
				updateTransactions(accts[i].getAccountNumber(),'D', amount);
				transNumber++;
				System.out.println();
				System.out.println("Deposit Successful\n");
			}
			
		}	
		}
		}
		
	//Withdraw
	boolean withDraw() throws IOException {
			float amount = 0f;
			String option = "";
			String selType = "";
			String choice2 = "";
			int choice = 0;
			System.out.println();
			System.out.println("Which account would you like to withdraw from?");
			System.out.println();
			System.out.println("1.Checking");
			System.out.println("2.Savings"); 
			System.out.println();
			
			System.out.print("Enter an option: ");
			choice2 = input.readLine();
			choice = Integer.parseInt(choice2);
			
			if (choice == 1)
			{
				System.out.println("You have selected your Checking Account");
				selType = "Checking";

			} else if (choice == 2)
			{
				System.out.println("You have selected your Savings Account");
				selType = "Savings";
			}
			
			System.out.println();
			System.out.print("Enter an amount to withdraw: ");
			option = input.readLine();
			amount = Float.parseFloat(option);
			for (int i = 0; i < A_SIZE; i++)
			{
				if(clients[selUser].getCustomerID().equals(accts[i].getAccountID()) && selType.equals(accts[i].getAccountType())) {
			if(amount <= accts[selUser].getBalance()){
				accts[selUser].setBalance(accts[selUser].getBalance() - amount);
				updateTransactions(accts[i].getAccountNumber(),'W', amount);
				transNumber++;
				System.out.println();
				System.out.println("Withdraw Successful\n");
			
			}	
			else {
				System.out.println();
				System.out.println("Insufficent funds\n");
				return false;
			}
				}
			
			}
			return true;
		}
		
	//Show Account
	 void showAccount() {
			
		 			System.out.println("-------------------------------");
		        	System.out.println("Name of account holder: " + clients[selUser].getCustomerName());  
		            
		        	System.out.println("-------------------------------");
		        	for(int i = 0; i < accts.length; i++) {
		        		if(clients[selUser].getCustomerID().equals(accts[i].getAccountID())) {
		        				System.out.println("Account no.: " + accts[i].getAccountNumber());  
		        				System.out.println("Account type: " + accts[i].getAccountType());  
		        				System.out.println("Balance: $" + accts[i].getBalance());  
		        				System.out.println("-------------------------------");
		        		}
		        	}
		        	System.out.println("-------------------------------");
		    }
	 
	 //Login
	 public void login() throws IOException {
			int numattempts = 0;
		    boolean isPassValid = false;
			String option = "";
		    
		    
		    
		    do {
		    	
		    	System.out.println();
		    	System.out.print("Please enter your customer ID: ");
				String cin = input.readLine(); 
				
				
				System.out.println();
				System.out.print("Please enter your pin: ");
				option = input.readLine();
				int pin = Integer.parseInt(option);
				
				
				
				for (int i = 0; i < clients.length; i++) 
				{
					if(cin.equals(clients[i].getCustomerID()) && pin == clients[i].getCustomerPin()) {
						isPassValid = true; 
						System.out.println("Login Successful!");
						System.out.println(" ");
						System.out.println("Welcome " + clients[i].getCustomerName());
						System.out.println(" ");
						selUser = i;
					}	
				}
				
				if (!isPassValid) {
					System.out.println(" ");
					System.out.println("Username or Password invalid, please try again!");
				}
				numattempts++; 
				if (numattempts == 3 && !isPassValid) {
					System.out.println("Number of attempts exceeded, program terminated!");
					System.exit(0);
				}
				
				}while(!isPassValid &&numattempts <=3);
		    	
		    	
		    }
	 		
			
	
			
	  }







