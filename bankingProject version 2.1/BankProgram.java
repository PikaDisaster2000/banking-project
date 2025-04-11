import java.util.Scanner; //for keyboard and files
import java.io.File; //for handling files
import java.util.ArrayList; // for making arraylists
import java.io.IOException; // for handling exceptions in the program.
import java.io.FileWriter;

/**
 * Write a description of class mainProject here.
 *
 * Joseph Tuitupou
 * Version 1.9
 */
public class BankProgram {
    Scanner kb = new Scanner(System.in);
    ArrayList<Account> bankAccounts = new ArrayList<Account>(); //creats arraylist "account" and makes a array list of bank accounts based on the constructors of Account.
    String[] splitCustomerNumber; 
    String customerID;
    String accountTypeNum;
    String branchNumber;
    private ArrayList<String> customerIDs = new ArrayList<>();
    private ArrayList<String> accountTypeNumbers = new ArrayList<>();
    
    /**
     * Constructor for objects of class mainProject
     */
    public BankProgram() {
        boolean showMenu= loadBank(); //the menu doesnt show unless the csv file has loaded.
        while (showMenu) { //while showing the menu...
            System.out.println("=================================================================");
            System.out.println("Welcome to Kawaii Bank Services. Please select an option:");
            System.out.println("Create an account (C)");
            System.out.println("Delete an account (X)");
            System.out.println("Show balance of an account (B)");
            System.out.println("Deposit money into an account (D)");
            System.out.println("Withdraw money from an account (W)");
            System.out.println("Quit/Save Changes (Q)");
            System.out.println("=================================================================");
            String choice = kb.nextLine().toUpperCase(); //next choice on menu.
            switch (choice) { //
                case "C" : createAccount();
                    break;
                case "X": deleteAccount();//display delete account
                    break;
                case "B": showBalance();
                    break;
                case "W": withdraw();
                    break;
                case "D": deposit();
                    break;
                case "Q": System.out.println("Quitting...");
                          System.exit(0);
                    break;
                default: System.out.println("Erorr,  reloading menu...");
                
            }
        }
    }
    public boolean loadBank() {
        File myFile = new File("bankData.csv"); //set up the file
        try {
            Scanner myReader = new Scanner(myFile);//read the file one line at a time
            while(myReader.hasNextLine()) {
                String[] parts = myReader.nextLine().split(","); //csv file break the part
                String name = parts[0]; //converts first column (of csv)
                String address = parts[1]; // converts second column
                String accountType = parts[2]; //converts third column
                String accountNumber = parts[3]; //converts fourth column
                double currentBalance = Double.parseDouble(parts[4]); //it is a string because when the reader scans it, it scans in as a string, but needs to be converted to a double.
                if (parts.length != 5){
                    System.out.println("Error reading bank accounts. There are too many fields than expected. Please try again.");
                    return false;
                }
                bankAccounts.add(new Account(name,address,accountType,accountNumber, currentBalance)); //adds the name, address, account type, account number, and current balance to "bankAccounts".
           }
            for (Account accounts : bankAccounts) {
                splitCustomerNumber = accounts.getAccountNumber().split("-");
                if (splitCustomerNumber.length != 4) {
                    System.out.println("Error loading customer account ID. Please try again.");
                    System.out.println(accounts.getAccountNumber());
                    return false;
                }
                
                branchNumber= splitCustomerNumber[1];
                customerID = splitCustomerNumber[2];
                accountTypeNum = splitCustomerNumber[3];
                
                customerIDs.add(customerID);
                accountTypeNumbers.add(accountTypeNum);
           }
           return true;
         } catch(IOException e) {
            System.out.println("Error: reading bank accounts");
            return false;
        }
    }
    public void showBalance() { //shows the balance of the avalible bank accounts
        System.out.println("Which account do you want to see a balance of? Please type your Customer ID. (your customer number is formatted as a 7 digit number (XXXXXXX).");
        boolean tryingToFind = true;
        String inputCustomerNum = kb.nextLine().trim(); //trim removes any spaces.
        for (Account currentAccount : bankAccounts) {
            splitCustomerNumber = currentAccount.getAccountNumber().split("-");
            if (splitCustomerNumber.length == 4) {
                     customerID = splitCustomerNumber[2];
            }
            if (getCustomerIDs().equals(inputCustomerNum)) {
                try {
                    tryingToFind = false; //we found them 
                    System.out.println("Name: " + currentAccount.getName());
                    System.out.println("Account type: " + currentAccount.getType());
                    System.out.println("Current Balance: " + currentAccount.getBalance());
                } catch (Exception a) {
                    System.out.println("Sorry, we couldn't find the account you were looking for. Please try again later.");
                } 
                      }    
             }
    }
    public void withdraw() {
        System.out.println("Which account are you withdrawing from? Please type your Customer ID. (your customer number is formatted as a 7 digit number (XXXXXXX).");
        String inputCustomerNum = kb.nextLine();
        boolean tryingToFind = true; //trying to find the account; which is true, because we are looking for it.
        for (Account currentAccount : bankAccounts) {
            splitCustomerNumber = currentAccount.getAccountNumber().split("-");
            if (splitCustomerNumber.length == 4) {
                     customerID = splitCustomerNumber[2];
            }    
            if (getCustomerIDs().equals(inputCustomerNum)) {
                    try{
                        tryingToFind = false; // we found them! 
                        System.out.println("Account found. How much are you depositing?");
                        double withdrawAmount = kb.nextDouble();
                        currentAccount.adjustWithdraw(withdrawAmount);
                        System.out.println("Current Balance: " + currentAccount.getBalance());
                        writeToFile();
                        } 
                        catch (Exception e) {
                        System.out.println("Either couldn't find the account you were looking for, or you typed in a invalid input. Please try again.");
                        }
                } 
        }
    }
    public void deposit() {
        System.out.println("Which account are you depositing money to? Please type your Customer ID. (your customer number is formatted as a 7 digit number (XXXXXXX).");
        String inputCustomerNum = kb.nextLine().trim();
        boolean tryingToFind = true; //trying to find the account; which is true, because we are looking for it.
        for (Account currentAccount : bankAccounts) {
            splitCustomerNumber = currentAccount.getAccountNumber().split("-");
            if (splitCustomerNumber.length == 4) {
                     customerID = splitCustomerNumber[2];
            }    
            if (getCustomerIDs().equals(inputCustomerNum)) {
                    try{
                        tryingToFind = false; // we found them! 
                        System.out.println("Account found. How much are you withdrawing?");
                        double depositAmount = kb.nextDouble();
                        
                        currentAccount.adjustDeposit(depositAmount);
                        System.out.println("New Balance: " + currentAccount.getBalance());
                        writeToFile();
                        } 
                        catch (Exception e) {
                        System.out.println("Either couldn't find the account you were looking for, or you typed in a invalid input. Please try again.");
                        }
                } 
        }
        
    }
    public void deleteAccount() {
        System.out.println("Enter the account number you want to delete in its entirety:");
        String accountNumberToDelete = kb.nextLine().trim();
        Account accountToDelete = null;
        for (Account currentAccount : bankAccounts) {
            if(currentAccount.getAccountNumber().equals(accountNumberToDelete)) {
                accountToDelete = currentAccount;
                break;
            }
        }
        if (accountToDelete != null) {
            System.out.println("Are you sure you want to delete this account?");
            System.out.println("Name: " + accountToDelete.getName());
            System.out.println("Address: " + accountToDelete.getAddress());
            System.out.println("Account Number: " + accountToDelete.getAccountNumber());
            System.out.println("Account Type: " + accountToDelete.getType());
            System.out.println("Current Balance: " + accountToDelete.getBalance());
            System.out.println("Type YES if so. Otherwise, any other input will cancel the Account deletion.");
            String confirmation = kb.nextLine().toUpperCase().trim();
            if (confirmation.equals("YES")) {
                bankAccounts.remove(accountToDelete);
                System.out.println("Account deleted sucessfully.");
                writeToFile();
            } else {
                System.out.println("Account Deletion cancelled.");
            }
        } else {
            System.out.println("No account found with the provided account number.");
        }
    }
    public void createAccount() { //create account
        System.out.println("Do you want to make an account? (Y/N)");
        String createChoice = kb.nextLine().toUpperCase();
        switch (createChoice) {
            case "Y": 
            System.out.println("ok!");
             System.out.println("Enter your account details");  
            System.out.println("Enter name: ");
            String name = kb.nextLine();
            System.out.println("Enter Address (DO NOT ADD COMMA'S)");
            String address = kb.nextLine();
            if (address.equals(",")) {
                        System.out.println("account creation failed because you included a comma on your address. Please try again.");
                        break;
            }
            System.out.println("Please enter your branch number. (it is a 4 digit number)");
            String branchNumInput = kb.nextLine().trim();
             //generate a random 7 digit customer ID for the new account
            int customerID = (int)(Math.random() * 10000000); // Random 7-digit number
            String customerIDString = String.format("%07d", customerID);
           
            
            System.out.println("Enter Account Type (01 - Current, 02 - Savings, 03 - Everyday): ");
            String accountTypeInput = kb.nextLine().trim();
            String accountType;
            switch (accountTypeInput) {
                case "01":
                    accountType = "Current";
                    break;
                case "02": 
                    accountType = "Savings";
                    break;
                case "03":
                    accountType = "Everyday";
                    break;
                default: System.out.println("Invalid account type. Please try again.");
                    return;
            }
           
           
            
            System.out.println("Enter inital balance: ");
            double currentBalance = kb.nextDouble(); 
            if (accountType.equals("Everyday") || accountType.equals("Savings")) {
             if (currentBalance <0) {
                 System.out.println("Error: The initial balance for a Savings or Everyday account cannot be less than 0. Please try again.");
                 return;
                }
            }
            if (accountType.equals("Current")) {
                if (currentBalance < -1000) {
                    System.out.println("Error: The initial balance for a Current account cannot be less than -1000 (in overdraft). Please try again.");
                    return;
                }
            }
            
            String accountNumber = "08" + "-" + branchNumInput.trim() + "-" + customerIDString + "-" + accountTypeInput.trim();
            Account newAccount = new Account(name, address, accountType, accountNumber, currentBalance);
            bankAccounts.add(newAccount);
            System.out.println("Account created sucessfully");
            System.out.println("Your account number is: " + accountNumber);
            writeToFile();
                    break;    
            case"N": 
                System.out.println("ok cancelling making an account.");
                    break;
            default: System.out.println("Invalid input. Please try again (you must press Y for yes or N for no).");
                     break;
        }
    }
    public void writeToFile() {
        try {
            FileWriter accountWriter = new FileWriter(("bankData.csv"), false);
            for (Account account : bankAccounts) {
                String accountData = account.getName() + "," +
                                     account.getAddress() + "," +
                                     account.getType() + "," +
                                     account.getAccountNumber() + "," +
                                     account.getBalance();
                accountWriter.write(accountData + "\n");
            }
            accountWriter.close();
            System.out.println("Data has been saved. Please make sure to press Q when leaving to reinforce data or you may lose it.");
        } catch (IOException e) {
            System.out.println("An error occured while writing to the file. Please press Q to ensure minimal data loss.");
            e.printStackTrace();
        }
    }
    public String getCustomerIDs() {
        return this.customerID;
    }
    public String getAccountTypeNums(){
        return this.accountTypeNum;
    }
}
