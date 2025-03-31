
/**
 * Write a description of class mainProject here.
 *
 * Joseph Tuitupou
 * Version 1.0
 */
public class main
{
    /**
     * Constructor for objects of class mainProject
     */
    public main(String[] args) {
        System.out.println("Welcome. Please select an option:");
        System.out.println("Create an account (C)");
        System.out.println("Delete an account (X)");
        System.out.println("Show balance of an account (B)");
        System.out.println("Deposit money into an account (D)");
        System.out.println("Withdraw money from an account (W)");
        Bank myBank = new Bank();
        myBank.printBankAccounts();
    }
}
