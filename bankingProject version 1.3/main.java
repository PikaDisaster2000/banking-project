import java.util.Scanner; //for keyboard and files
import java.io.File;
/**
 * Write a description of class mainProject here.
 *
 * Joseph Tuitupou
 * Version 1.0
 */
public class main {
    Scanner kb = new Scanner(System.in);
    /**
     * Constructor for objects of class mainProject
     */
    public main(String[] args) {
        Bank myBank = new Bank();
        System.out.println("Welcome. Please select an option:");
        System.out.println("Create an account (C)");
        System.out.println("Delete an account (X)");
        System.out.println("Show balance of an account (B)");
        System.out.println("Deposit money into an account (D)");
        System.out.println("Withdraw money from an account (W)");
        String choice = kb.nextLine().toUpperCase();
        switch (choice) {
            case "C" : //display create account
                break;
            case "X": //display delete account
                break;
            case "B": myBank.showBalance();
                    break;
            default: System.out.println("error");
        }
        
    }
}
