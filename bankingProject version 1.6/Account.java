import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Write a description of class accounts here.
 *
 * Joseph Tuitupou
 * 1.6
 */
public class Account //self explanatory but its the class called Account
{
    private String name; // string for names 
    private String address; //string for address
    private String accountType; //string for account type
    private String accountNumber; //string for account number
    private double currentBalance; //double for balance 
    Scanner kb = new Scanner(System.in);
    public Account(String name, String address, String accountType, String accountNumber, double currentBalance) { //class constructor for Account
        this.name = name; //sets the name to whatever the name variable is set up at.
        this.address = address; //sets the address
        this.accountType = accountType; //sets the account type
        this.accountNumber = accountNumber; //sets account number
        this.currentBalance = currentBalance; //sets current balance
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
    void showAccount() {
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Account Type: " + this.address);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Current Balance: " + this.currentBalance);
    }
    public void adjustBalance (double newBalance) {
        if (this.accountType.equals("Everyday") && this.currentBalance >= 0) { //if its an everyday account and you try to go to overdraft (which you cant)...
            System.out.println("Insufficient funds");
        } else if (this.accountType.equals("Savings") && this.currentBalance >=0) { //if its a savings account and you try to go overdraft...
           System.out.println("Insufficient funds");        
           //} else if (this.accountType.equals("Savings") && newBalance <5000) { //if you try withdrawing more than $5000
            //    System.out.println("You cannot withdraw more than $5000. Please try again.");
        //} else if (this.accountType.equals("Current") && kb.nextDouble() <= 5000) { //if you try withdrawing more than $5000
              //  System.out.println("You cannot withdraw more than $5000. Please try again.");
          //  } else if (this.accountType.equals("Everday") && newBalance <5000) { //if you try withdrawing more than $5000
            //    System.out.println("You cannot withdraw more than $5000. Please try again.");
            } else if(this.accountType.equals("Current") && this.currentBalance - newBalance <= -1000) {
               System.out.println("Denied, due to reaching the overdraft limit.");
        } else {
            this.currentBalance = this.currentBalance - newBalance; 
            System.out.println(newBalance + " has been withdrawn from this account.");
        }
    }
}
