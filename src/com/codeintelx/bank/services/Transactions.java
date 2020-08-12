package com.codeintelx.bank.services;

import com.codeintelx.bank.models.Account;

import java.util.ArrayList;

public class Transactions
{
    private double withdrawalAmount;
    private double depositAmount;
    ArrayList<Account> customer = new ArrayList<> (); //can pull from variables from the Account Class

    public String createAccount (int accountNumber, String customerName, String accountType)
    {

        System.out.println("Input User Name");
        System.out.println("Input Phone Number?");

        return null ;
    }

//    public String viewAccount ()
//    {
//        return "Account Number: " + accountNumber +
//                "\n Customer Name: " + customerName +
//                "\n Balance: " + balance + "\n";
//    }
//
//
//    public void withdrawal(double withdrawalAmount)
//    {
//        if(customer.get().getBalance() - withdrawalAmount <= 0)
//        {
//            System.out.println("Only " + customer.get().getBalance() + " available. Withdrawal not processed");
//        }
//        else
//        {
//            customer.get().getBalance() -= withdrawalAmount;
//            System.out.println("Withdrawal of " + withdrawalAmount + " processed, Remaining balance = " + customer.get().getBalance() );
//        }
//    }
//    public void deposit(double depositAmount)
//    {
//        customer.get().getBalance()  += depositAmount;
//    }
//
//    public void deposit(double depositAmount)
//    {
//        customer.get().getBalance() += depositAmount;
//        System.out.println("Deposit of " + depositAmount + " made. New balance is " + customer.get().getBalance() );
//    }

}
