package com.codeintelx.bank;
import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.Transactions;
import java.util.Scanner;

public class Main
{
    public static Transactions transactions = new Transactions();

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
                    String customerName = (scanner.next());
                    String accountType;
                    String enteredAccountType;
                    do {
                        System.out.println("Please Enter 'Checking' or 'Savings'");
                        accountType = scanner.next();
                        enteredAccountType = accountType.toLowerCase();
                    }
                    while (!enteredAccountType.equals("checking") && !enteredAccountType.equals("savings"));

                    transactions.createAccount(customerName, enteredAccountType, balance);

                    break;

                case 3:
                    System.out.println("Enter Account Number");
                    customerAccount = scanner.next();
                    transactions.viewAccount(customerAccount);

                    break;

                case 4:
                    System.out.println("Enter Account Number");
                    customerAccount = scanner.next();
                    System.out.println("How much do you want to withdraw?");
                    double customerAccWithdraw = scanner.nextDouble();
                    transactions.withdraw(customerAccount, customerAccWithdraw);

                    break;

                case 5:///Run it!
                    System.out.println("Enter Account Number");
                    customerAccount = scanner.next();
                    System.out.println("How much do you want to Deposit?");
                    double customerAccDeposit = scanner.nextDouble();
                    transactions.deposit(customerAccount, customerAccDeposit);

                    break;

                case 6:
                    System.out.println("Are you sure you want to delete 'Yes' or 'No'");
                    String deleteOptions = scanner.next();
                    deleteOptions.toLowerCase();

                    if (deleteOptions.equals("yes"))
                    {
                        System.out.println("Enter Account Number");
                        customerAccount = scanner.next();
                        transactions.removeAccount(customerAccount);
                        System.out.println("Account deleted");
                    }
                       else if (deleteOptions.equals("no")) {
                        System.out.println("Return to main menu");
                     }
                       else{
                        System.out.println("Type 'Yes or 'No'");
                    }
                    //New method

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
                + "6. Delete Account \n"
                + "0. Exit \n");


    }
}