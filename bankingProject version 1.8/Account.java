import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Write a description of class accounts here.
 *
 * Joseph Tuitupou
 * 1.7
 */
public class Account //self explanatory but its the class called Account
{
    private String name; // string for names 
    private String address; //string for address
    private String accountType; //string for account type
    private String accountNumber; //string for account number
    private double currentBalance; //double for balance 
    Scanner kb = new Scanner(System.in);
    final int MAXWITHDRAW = 5000;
    public Account(String name, String address, String accountType, String accountNumber, double currentBalance) { //class constructor for Account
        this.name = name; //sets the name to whatever the name variable is set up at.
        this.address = address; //sets the address
        this.accountType = accountType; //sets the account type
        this.accountNumber = accountNumber; //sets account number
        this.currentBalance = currentBalance; //sets current balance
    }
    public String getAddress() {
        return(this.address);
    }
    public String getAccountNumber() {
        return(this.accountNumber);
    }
    public String getName() {
        return(this.name);
    }
    public double getBalance() {
        return(this.currentBalance);
    }
    public String getType() {
        return(this.accountType);
    }
    public void adjustBalance (double withdrawAmount) {
        if (this.accountType.equals("Everyday") && this.currentBalance <= -1) { //if its an everyday account and you try to go to overdraft (which you cant)...
            System.out.println("Insufficient funds");
        } else if (this.accountType.equals("Savings") && this.currentBalance <= -1) { //if its a savings account and you try to go overdraft...
           System.out.println("Insufficient funds");        
            } else if(this.accountType.equals("Current") && this.currentBalance - withdrawAmount <= -1000) {
               System.out.println("Transaction denied, due to reaching the overdraft limit.");
        }   else if (withdrawAmount == MAXWITHDRAW) {
                System.out.println("Transaction denied due to reaching the max withdrawl limit ($5000)."); 
        }
        else {
            this.currentBalance = this.currentBalance - withdrawAmount; 
            System.out.println(withdrawAmount + " has been withdrawn from this account.");
        }
    }
}
