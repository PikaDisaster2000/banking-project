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
    private String currentBalanceText; //string for current balanc
    private double currentBalance; //double for balance 
    ArrayList<Account> bankAccounts = new ArrayList<Account>(); //creats arraylist "account" and makes a array list of bank accounts based on the constructors of Account.
    public Account(String name, String address, String accountType, String accountNumber, double currentBalance) { //class constructor for Account
        this.name = name;
        this.address = address;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
    }
    
    public Account() { // it is a constructor so that the Arraylist and objects know its reading from the file.
        File myFile = new File("bankData.csv"); //set up the file
        try {
            Scanner myReader = new Scanner(myFile);
            //read the file one line at a time
            while(myReader.hasNextLine()) {
                String[] parts = myReader.nextLine().split(","); //csv file break the part
                String name = parts[0]; //converts first column (of csv)
                String address = parts[1]; // converts second column
                String accountType = parts[2]; //converts third column
                String accountNumber = parts[3]; //converts fourth column
                String currentBalance = parts[4]; //it is a string because when the reader scans it, it scans in as a string, but needs to be converted to a double.
                bankAccounts.add(new Account(name,address,accountType,accountNumber, Double.parseDouble(currentBalance)));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
