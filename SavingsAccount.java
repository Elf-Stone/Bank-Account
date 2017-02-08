/*Name : Colin Redpath
  Date : 11/10/16
  Class: CSC-151
*/

import java.util.Scanner; //Needed for Scanner class.
import java.io.*; //Needed for File and IOException.


// This class reads and calculates a Banking Account
public class SavingsAccount
{
	//Fields
	private double balance;
	private double withdrawals;
	private double deposits;
	private double monthlyInt;
	


/*Constructor 1 
@param startingBal The starting balance of the account
*/
public SavingsAccount(double startingBal)
{
	balance = startingBal;
	withdrawals = 0;
	deposits = 0;
	monthlyInt = 0;
}

//No args Constructor
public SavingsAccount()
{
	balance = 0;
	withdrawals = 0;
	deposits = 0;
	monthlyInt = 0;
}


/*
The setWithdrawals method reads the withdrawls stored in a text file, adds them, and assigns the value to the withdraws field.
@param myFile The Withdraws file handle.
*/
public void setWithdrawals() throws FileNotFoundException
{
	File myFile = new File("Withdrawals.txt");
	Scanner inputFile = new Scanner(myFile);
	
	double sum = 0;
	while (inputFile.hasNext())
	{
		double number = inputFile.nextDouble();
		
		sum += number;
	}
	
	inputFile.close();
	
	withdrawals = sum;
}


/* 
The setDeposits method reads, sums, and assigns the value of deposits from a text file to the deposits field.
@param myFile The Deposits file handle.
*/ 
public void setDeposits() throws FileNotFoundException
{
	File myFile = new File("Deposits.txt");
	Scanner inputFile = new Scanner(myFile);
	
	double sum = 0;
	while (inputFile.hasNext())
	{
		double number = inputFile.nextDouble();
		
		sum += number;
	}
	
	inputFile.close();
	
	deposits = sum;
}


/*
The calcWithAndDep method calculates the total balance by subtracting the total withdraws and adding the total deposits.
@return The total balance.
*/
public double calcWithAndDep()
{
	balance = (balance - withdrawals) + deposits;
	
	return balance;
}


/*
The getMonthlyInt method calculates the monthly interest.
@param anualInt The anual interest rate. 
@return The monthly interest rate. 
*/
public double getMonthlyInt(double anualInt)
{
	monthlyInt = (anualInt / 12) * .01;
	monthlyInt = monthlyInt * balance;
	
	return monthlyInt;
	
}


/*
The finalBalance method calculates the total balance of the account by summing the monthly interest to the account. 
@return The final balance.
*/
public double finalBalance()
{
	balance += monthlyInt;
	
	return balance;
}

}