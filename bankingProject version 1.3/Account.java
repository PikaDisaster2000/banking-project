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
    private String currentBalance; //double for balance 
    public Account(String name, String address, String accountType, String accountNumber, String currentBalance) { //class constructor for Account
        this.name = name; //sets the name to whatever the name variable is set up at.
        this.address = address; //sets the address
        this.accountType = accountType; //sets the account type
        this.accountNumber = accountNumber; //sets account number
        this.currentBalance = currentBalance; //sets current balance
    }
    public String getName() {
        return(this.name);
    }
    public String getBalance() {
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
}
