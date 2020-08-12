package com.codeintelx.bank;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
      //  printInstructions();
        Scanner scanner = new Scanner(System.in);
        printInstructions();
        int options = scanner.nextInt();
        do {
//        {
//            System.out.println("Invalid option. Please select options 1-5");
//            scanner.nextInt();
//        }

            switch (options) {
                case 1:
                    printInstructions();
                //    scanner.nextInt();
                    break;
                case 2:
                    System.out.println("Input User Name");
                    String customerName = scanner.next();
                    System.out.println("Input Account Type (Savings or Checking)");
                    String accountType = scanner.next();
                    //code to store input to map
                    break;
                case 3:
                    System.out.println("Enter Account Name or Number");
                    //Code for Account Information);
                    break;
                case 4:
                    System.out.println("Enter Account Name or Number");
                    System.out.println("Withdraw from Checking Account (1) or Savings Account (2)?");
                    //code to withdraw from selected account
                    break;
                case 5:
                    System.out.println("Enter Account Name or Number");
                    System.out.println("Deposit from Checking Account (1) or Savings Account (2)?");
                    //code to deposit from selected account
                    break;


            }
        }
        while (options < 1 || options > 5);
    }



    public static void printInstructions()
    {
        System.out.println("----------------------------------------Welcome!---------------------------------------- \n"
        + "Type Number for Options \n"
        + "1. Display Options \n"
        + "2. Create an Account \n"
        + "3. View Account \n"
        + "4. Withdraw from Account \n"
        + "5. Deposit to Account \n");


    }
  // public static switch (printInstructions) {

//    }
//    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//    System.out.println("Enter username");
//
//    String userName = myObj.nextLine();  // Read user input
//    System.out.println("Username is: " + userName);  // Output user input
}
