package com.codeintelx.bank;
import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.AccountServices;
import java.util.Map;
import java.util.Scanner;
public class Main
{
    public static AccountServices accountServices = new AccountServices();
    public static Account account;

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
            switch (options)
            {
                case 1:
                    System.out.println("Input User Name");
                    String customerName = scanner.next() + " " + scanner.next();
                    String enteredCustomerName = customerName.toUpperCase();
                    System.out.println("Please Enter 'Checking' or 'Savings'");
                    String accountType = scanner.next();
                    String enteredAccountType = accountType.toUpperCase();
                    if (enteredAccountType.toUpperCase().equals("CHECKING") || enteredAccountType.toUpperCase().equals("SAVINGS"))
                    {
                        account = accountServices.createAccount(enteredCustomerName, enteredAccountType, balance);
                        System.out.println(" Account Number: " + account.getAccountNumber() + "\n " + "User Name: " + enteredCustomerName
                                + "\n " + "Account Type: " + enteredAccountType + "\n " +
                                "Balance: $" + balance);
                    } else
                    {
                        System.out.println("Please Enter 'Checking' or 'Savings'");
                    }
                    break;
                case 2:
                    try
                    {
                        System.out.println("Enter Account Number");
                        customerAccount = scanner.next();
                        account = accountServices.getAccount(customerAccount);
                        System.out.println(" Account Number: " + account.getAccountNumber() + "\n " + "User Name: "
                                + account.getCustomerName() +
                                "\n " + "Account Type: " + account.getAccountType() + "\n " +
                                "Balance: $" + account.getBalance());

                    } catch (AccountNotFoundException errorMessage)
                    {
                        System.out.println(errorMessage.getMessage());
                    }
                    break;

                case 3:
                    try
                    {
                        System.out.println("Enter Account Number");
                        customerAccount = scanner.next();
                        System.out.println("How much do you want to withdraw?");
                        double customerAccWithdraw = scanner.nextDouble();
                        if (customerAccWithdraw > 0)
                        {
                            System.out.println("$" + customerAccWithdraw + " has been withdrawn");
                            account = accountServices.withdraw(customerAccount, customerAccWithdraw);
                            System.out.println("Balance: $" + account.getBalance());
                        }
                        else
                        {
                            System.out.println("Withdrawal can't be completed.");
                        }
                    }
                    catch (InsufficientFundsException errorMessage)
                    {
                        System.out.println(errorMessage.getMessage());
                    }
                    catch (AccountNotFoundException errorMessage)
                    {
                        System.out.println(errorMessage.getMessage());
                    }
                    break;

                case 4:
                    try
                    {
                        System.out.println("Enter Account Number");
                        customerAccount = scanner.next();
                        System.out.println("How much do you want to Deposit?");
                        double customerAccDeposit = scanner.nextDouble();
                        if (customerAccDeposit > 0)
                        {
                            account = accountServices.deposit(customerAccount, customerAccDeposit);
                            System.out.println("$" + customerAccDeposit + " has been deposited");
                        }
                        else
                        {
                            System.out.println("Can't deposit non-positive amount");
                        }
                    }
                    catch (AccountNotFoundException errorMessage)
                    {
                        System.out.println(errorMessage.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Do you want to view everyone's Account? 'Yes' or 'No'");
                    String adminView = scanner.next();
                    if (adminView.toLowerCase().equals("yes"))
                    {
                        System.out.println("Account Admin View");
                        for (Map.Entry<String, Account> masterView : accountServices.viewAllAccounts().entrySet())
                        {
                            System.out.println("Account Number: " + masterView.getKey()
                                    + " User Name: " + masterView.getValue().getCustomerName()
                                    + " Account Type: " + masterView.getValue().getAccountType()
                                    + " Balance: " + masterView.getValue().getBalance());
                        }
                    }
                    else if (adminView.toLowerCase().equals("no"))
                    {
                        System.out.println("Return to main menu");
                    }
                    break;
                case 6:
//                    try
//                    {
                        System.out.println("Enter Account Number to Delete");
                        customerAccount = scanner.next();
                        System.out.println("Are you sure you want to delete 'Yes' or 'No'");
                        String deleteOptions = scanner.next();
                        if (deleteOptions.toLowerCase().equals("yes"))
                        {
                            accountServices.removeAccount(customerAccount);
                            System.out.println("Account deleted");
                        }
//                    }
//                    catch (AccountNotFoundException errorMessage)
//                    {
//                        System.out.println(errorMessage.getMessage());
//                    }
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
                + "1. Create a Savings/Checking Account \n"
                + "2. View Account \n"
                + "3. Withdraw from Account \n"
                + "4. Deposit to Account \n"
                + "5. Administrator: Print All Accounts \n"
                + "6. Delete Account \n"
                + "0. Exit \n");
    }
}