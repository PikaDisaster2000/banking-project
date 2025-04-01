import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
import java.util.Scanner;
/**
 * Write a description of class Bank here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bank
{
     ArrayList<Account> bankAccounts = new ArrayList<Account>(); //creats arraylist "account" and makes a array list of bank accounts based on the constructors of Account.
     Scanner kb = new Scanner(System.in);
    public Bank() {
        File myFile = new File("bankData.csv"); //set up the file
        try {
            Scanner myReader = new Scanner(myFile);
            //read the file one line at a time
            while(myReader.hasNextLine()) {
                String[] parts = myReader.nextLine().split(","); //csv file break the part
                String name = parts[0]; //converts first column (of csv)
                 String address = parts[1]; // converts second column
                String accountNumber = parts[2]; //converts third column
                String accountType = parts[3]; //converts fourth column
                String currentBalance = parts[4]; //it is a string because when the reader scans it, it scans in as a string, but needs to be converted to a double.
                bankAccounts.add(new Account(name,address,accountType,accountNumber, currentBalance)); //adds the name, address, account type, account number, and current balance to "bankAccounts".
            }
         } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void showBalance() { //shows the balance of the avalible bank accounts
        for (Account showBalance : bankAccounts) {
                System.out.println(showBalance.getName() + "  " + showBalance.getType() + "  " + showBalance.getBalance() );
        }
    }
    public static void writingToFile() {
    
    }
    public void withdraw() {
        System.out.println("Which account are you withdrawing from?");
        
    }
    public void deposit() {
    
    }
}
