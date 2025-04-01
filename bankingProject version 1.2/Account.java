import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Write a description of class accounts here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Account //self explanatory but its the class called Account
{
    private String name; // string for names 
    private String address; //string for address
    private String accountType; //string for account type
    private String accountNumber; //string for account number
    private double currentBalance; //double for balance 
    private String currentBalanceText = String.valueOf(currentBalance); //to display the balance
    // ArrayList<Account> myAccounts = new ArrayList<Account>(); //creats arraylist "account" and makes a array list of bank accounts based on the constructors of Account.
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
    public String getcurrentBalance() {
       return(this.name); //substitute for now; I dont know how I can parse the double into a showable string yet.
    }
    void showAccount() {
        System.out.println("Name: " + this.name);
        System.out.println("Address: " + this.address);
        System.out.println("Account Type: " + this.address);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Current Balance: " + this.currentBalance);
    }
    public static void writingToFile() {
    
    }
}
