import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Write a description of class bankAccounts here.
 *
 * Joseph
 * Version 0
 */
public class bankAccounts
{
    ArrayList<bankInfo> customerAccounts = new ArrayList<bankInfo>();
    public static void bankAccounts()
    {
        try {
        File myFile = new File("bankData.csv");
        Scanner accountReader = new Scanner(myFile);
        while(accountReader.hasNextLine()) {
            String line = accountReader.nextLine();
            String [] accounts = line.split(",");
            bankInfo.add(new Account(accounts[0], accounts[1], accounts[2], accounts[3], accounts[4]));
        }
    } catch (IOException e) {
        System.out.println("Error: could not write to file");
    }
}
}