package prjBankaccount;

import java.util.*;	
import java.io.*;

public class BankingSystem {

	public static void main(String[] args) throws IOException {
		
		Bank BCS345Bank = new Bank();
		char moreTrans = 'x';
		Scanner keyboard = new Scanner(System.in);
		Date date = new Date(); // the date instance
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int currentyear = 0, currentmonth =0, currentday = 0;
		currentyear = calendar.get(Calendar.YEAR);
		currentmonth = calendar.get(Calendar.MONTH);
		currentday = calendar.get(Calendar.DAY_OF_MONTH);
		String bankAddress = "277 Silver Lane Hicksville, NY 11720";
		String businessPhone = "631-820-1992";
		
		try
		{
		BCS345Bank.welcomeMenu();
		BCS345Bank.loadCustomers();
		BCS345Bank.loadAccounts();
		BCS345Bank.login();	
		do {
		BCS345Bank.showMenu();
		System.out.print("\nWould you like to perform another transaction? (Y/N): ");
		moreTrans = keyboard.next().charAt(0);
	} while (moreTrans == 'Y' || moreTrans == 'y');
		BCS345Bank.writeTrans();
		System.out.println();
		System.out.println("-------------------------------");
		System.out.println("Todays date is: " + currentmonth + "/" + currentday + "/" +currentyear);
		System.out.println("Thank you for banking with, " + BCS345Bank.bankName +  " Banking System!");
		System.out.println(bankAddress);
		System.out.println(businessPhone);
    	System.out.println("-------------------------------");
		}catch (FileNotFoundException e)
		{
			System.out.println("File Not Found, program terminated!");
			System.exit(1000);
		} catch (IOException e)
		{
			System.out.println("Error processing file, program terminated!");
			System.exit(2000);
			e.printStackTrace();
		}
		
		keyboard.close();
		
	}
}

