package com.codeintelx.bank;

import com.codeintelx.bank.models.Account;
import com.codeintelx.bank.services.Transactions;

import java.util.Scanner;


public class Main {
   public static Transactions transactions = new Transactions();

    public static void main(String[] args) {
      //  printInstructions();
        Scanner scanner = new Scanner(System.in);

        int options;
        boolean quit = false;
        double accountNumber = Math.random();
        double balance = 0;
        do {
//        {
//            System.out.println("Invalid option. Please select options 1-5");
//            scanner.nextInt();
//        }
            printInstructions();
            options = scanner.nextInt();

            switch (options) {
                case 1:
                    printInstructions();
                   scanner.nextInt();

                    break;
                case 2:
                    System.out.println("Input User Name");
                    String customerName = scanner.next();
                    String accountType = "Savings";
                    transactions.createAccount(accountNumber, customerName, accountType,balance);
                    break;
                case 3:
                    System.out.println("Input User Name");
                    customerName = scanner.next();
                    accountType = "Checking";
                    transactions.createAccount(accountNumber, customerName, accountType,balance);
                    break;
                case 4:
                    System.out.println("Enter Account Number");
                    double customerAccount = scanner.nextDouble();
                    transactions.viewAccount(customerAccount);
                   // transactions.createAccount(accountNumber, customerName, accountType,balance);
                    //Code for Account Information);
                    break;
                case 5:
                    System.out.println("Enter Account Number");
                    double customerAccWithdraw = scanner.nextDouble();
                    System.out.println("How much do you want to withdraw?");
                    double withdrawAmmt = scanner.nextDouble();
                    transactions.withdraw(customerAccWithdraw, withdrawAmmt);

                    //code to withdraw from selected account
                    break;
                case 6:
                    System.out.println("Enter Account Number");
                    double customerAccDeposit = scanner.nextDouble();
                    System.out.println("How much do you want to Deposit?");
                    double depositAmmt = scanner.nextDouble();
                    //code to deposit from selected account
                    transactions.deposit(customerAccDeposit,depositAmmt);
                    break;
                case 0:
                    System.out.println("Goodbye");
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
        + "2. Create a Savings Account \n"
        + "3. Create a Checking Account \n"
        + "4. View Account \n"
        + "5. Withdraw from Account \n"
        + "6. Deposit to Account \n"
        + "0. Exit \n");


    }
  // public static switch (printInstructions) {

//    }
//    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//    System.out.println("Enter username");
//
//    String userName = myObj.nextLine();  // Read user input
//    System.out.println("Username is: " + userName);  // Output user input
}
