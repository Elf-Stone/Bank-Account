/*Name : Colin Redpath
  Date : 11/10/16
  Class: CSC-151
*/

//Import JOptionPane
import javax.swing.JOptionPane;
import java.io.*;
import java.text.DecimalFormat;
/*
This program creates an instance of the SavingsAccount class and calls its methods to calculate and display an account balance. 
*/
public class SavingsAccountDemo
{
	public static void main(String[] args) throws IOException 
	{
		JOptionPane.showMessageDialog(null,"Welcome. This program will calculate the total balance of your Savings Account.");
		
		//Create an instance of the SavingsAccount Class
		SavingsAccount funds = new SavingsAccount(500.00);
		
		//Read and sum the Withdrawals and Deposits
		funds.setWithdrawals();
		funds.setDeposits();
		
		DecimalFormat formatter = new DecimalFormat("#0.00");
		
		//Display Results
		JOptionPane.showMessageDialog(null,"Your total balance before adding your monthly interest is $" + formatter.format(funds.calcWithAndDep()) + ".");
		
		JOptionPane.showMessageDialog(null,"Your total interest earned for this month is $" + 
		formatter.format(funds.getMonthlyInt(12)) + ".");
		
		JOptionPane.showMessageDialog(null,"Your total balance after adding monthly interest is $" + formatter.format(funds.finalBalance()) + ".");
		
	
	}

}