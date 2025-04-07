import java.util.Scanner; //for keyboard and files
import java.io.File; //for handling files
import java.util.ArrayList; // for making arraylists
import java.io.IOException; // for handling exceptions in the program.

/**
 * Write a description of class mainProject here.
 *
 * Joseph Tuitupou
 * Version 1.5
 */
public class BankProgram {
    Scanner kb = new Scanner(System.in);
    ArrayList<Account> bankAccounts = new ArrayList<Account>(); //creats arraylist "account" and makes a array list of bank accounts based on the constructors of Account.
    /**
     * Constructor for objects of class mainProject
     */
    public BankProgram() {
        boolean showMenu= loadBank();
        while (showMenu) {
            System.out.println("Welcome to Kawaii Bank Services. Please select an option:");
            System.out.println("Create an account (C)");
            System.out.println("Delete an account (X)");
            System.out.println("Show balance of an account (B)");
            System.out.println("Deposit money into an account (D)");
            System.out.println("Withdraw money from an account (W)");
            System.out.println("Quit/Save Changes (Q)");
            String choice = kb.nextLine().toUpperCase();
            switch (choice) {
                case "C" : //display create account
                    break;
                case "X": //display delete account
                    break;
                case "B": showBalance();
                    break;
                case "W": withdraw();
                    break;
                    
                case "Q": System.out.println("Quitting...");
                          System.exit(0);
                    break;
                default: System.out.println("Erorr. Please open program again.");
            }
        }
    }
    public boolean loadBank() {
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
                double currentBalance = Double.parseDouble(parts[4]); //it is a string because when the reader scans it, it scans in as a string, but needs to be converted to a double.
                if (parts.length != 5){
                    System.out.println("Error reading bank accounts. There are too many fields than expected. Please try again.");
                    return false;
                }
                bankAccounts.add(new Account(name,address,accountType,accountNumber, currentBalance)); //adds the name, address, account type, account number, and current balance to "bankAccounts".
            }
            return true;
         } catch(IOException e) {
            System.out.println("Error: reading bank accounts");
            return false;
        }
    }
    public void showBalance() { //shows the balance of the avalible bank accounts
        boolean tryingToFind = true;
        String name = kb.nextLine();
        for (Account currentAccount : bankAccounts) {
            if (currentAccount.getName().equals(name)) {
                 System.out.println(currentAccount.getName() + " " + currentAccount.getType() + " " + currentAccount.getBalance());
            }    
             }
    }
    public void withdraw() {
        System.out.println("Which account are you withdrawing from?");
        String name = kb.nextLine();
        boolean tryingToFind = true; //trying to find the account; which is true, because we are looking for it.
        for (Account currentAccount : bankAccounts) {
                if (currentAccount.getName().equals(name)) {
                tryingToFind = false; // we found them! 
                System.out.println("Account found. How much are you withdrawing?");
                double newBalance = kb.nextDouble();
                currentAccount.adjustBalance(newBalance);
                System.out.println("Current Balance: " + currentAccount.getBalance());
            } 
        }
    }
    public void deposit() {
    
    }
    public static void writingToFile() { //create account
    
    }
}
