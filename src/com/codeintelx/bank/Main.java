package com.codeintelx.bank;
import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.Transactions;

import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class Main
{
    public static Transactions transactions = new Transactions();
    public static Account customerID;


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int options;
        boolean quit = false;
        double balance = 0;
        String customerAccount;

        do {
            printInstructions();
            options = scanner.nextInt();
            if (options < 0 || options > 6)
            {
                System.out.println("Invalid option. Please select options 1-5");
            }
            switch (options) {
                case 1:
                    System.out.println("Select 2-5");
                    break;

                case 2:
                    System.out.println("Input User Name");
                    String customerName = scanner.next();
                    String enteredCustomerName = customerName.toUpperCase();
                    String accountType;
                    String enteredAccountType;
                    UUID uuid = UUID.randomUUID();
                    String accountNumber = Long.toString(uuid.getMostSignificantBits()).substring(0, 11).replace("-", "");
                    do {
                        System.out.println("Please Enter 'Checking' or 'Savings'");
                        accountType = scanner.next();
                        enteredAccountType = accountType.toUpperCase();
                    }
                    while (!enteredAccountType.equals("CHECKING") && !enteredAccountType.equals("SAVINGS"));

                    transactions.createAccount(accountNumber, enteredCustomerName, enteredAccountType, balance);
                    System.out.println(" Account Number: " + accountNumber + "\n " + "User Name: " + enteredCustomerName
                            + "\n " + "Account Type: " + enteredAccountType + "\n " +
                            "Balance: $" + balance);
                    break;

                case 3:
                    try {
                        System.out.println("Enter Account Number");
                        customerAccount = scanner.next();
                    customerID = transactions.viewAccount(customerAccount);
                        System.out.println(" Account Number: " + customerID.getAccountNumber() + "\n " + "User Name: "
                                + customerID.getCustomerName() +
                                "\n " + "Account Type: " + customerID.getAccountType() + "\n " +
                                "Balance: $" + customerID.getBalance());

                        } catch (AccountNotFoundException errorMessage) {
                        System.out.println(errorMessage.getMessage());
                       }
                    break;

                case 4:
                    try {
                        System.out.println("Enter Account Number");
                        customerAccount = scanner.next();
                        System.out.println("How much do you want to withdraw?");
                        double customerAccWithdraw = scanner.nextDouble();
                        customerID = transactions.withdraw(customerAccount, customerAccWithdraw);

                    System.out.println("$" + customerAccWithdraw + " has been withdrawn");
                    if (customerAccWithdraw > 0)
                    {
                        System.out.println("Balance $" + customerID.getBalance());
                    } else {
                        System.out.println("Withdrawal can't be completed.");
                    }
                    } catch (InsufficientFundsException errorMessage)
                   {
                       System.out.println(errorMessage.getMessage());
                      // System.out.println("Insufficient Funds");
                   } catch (AccountNotFoundException errorMessage)
                   {
                       System.out.println(errorMessage.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println("Enter Account Number");
                        customerAccount = scanner.next();
                        System.out.println("How much do you want to Deposit?");
                        double customerAccDeposit = scanner.nextDouble();
                        transactions.deposit(customerAccount, customerAccDeposit);
                        if (customerAccDeposit > 0) {
                            System.out.println("$" + customerAccDeposit + " has been deposited");
                        } else {
                            System.out.println("Can't deposit non-positive amount");
                        }
                    } catch (AccountNotFoundException errorMessage)
                    {
                        System.out.println(errorMessage.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Do you want to view everyone's Account? 'Yes' or 'No'");
                    //method should have a 'for loop'
                    String adminView = scanner.next();
                    adminView.toLowerCase();
                    if (adminView.equals("yes"))
                    {
                        System.out.println("Account Admin View");
                        System.out.println(transactions.masterViewAccount());

                    }

                    else if (adminView.equals("no")) {
                        System.out.println("Return to main menu");
                    }
                    else{
                        System.out.println("Invalid Option: Return to main menu");
                    }
                    break;



                case 7:
                    try {
                        System.out.println("Enter Account Number to Delete");
                        customerAccount = scanner.next();
                        System.out.println("Are you sure you want to delete 'Yes' or 'No'");
                        String deleteOptions = scanner.next();
                        deleteOptions.toLowerCase();
                    if (deleteOptions.equals("yes"))
                    {
                        transactions.removeAccount(customerAccount);
                        System.out.println("Account deleted");
                    }
                       else if (deleteOptions.equals("no")) {
                        System.out.println("Return to main menu");
                     }
                       else{
                        System.out.println("Invalid Option: Return to main menu");
                    }
                    } catch (AccountNotFoundException errorMessage)
                    {
                        System.out.println(errorMessage.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Exiting Program: Goodbye");
                    quit = true;
                    break;
            }
        }
        while (!quit);
    }


    public static void printInstructions()
    {
        System.out.println("----------------------------------------Welcome!---------------------------------------- \n"
                + "Type Number for Options \n"
                + "1. Display Options \n"
                + "2. Create a Savings/Checking Account \n"
                + "3. View Account \n"
                + "4. Withdraw from Account \n"
                + "5. Deposit to Account \n"
                + "6. Administrator: Print All Accounts \n"
                + "7. Delete Account \n"
                + "0. Exit \n");


    }
}