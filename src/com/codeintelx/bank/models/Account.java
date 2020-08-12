package com.codeintelx.bank.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Account
{
    private int accountNumber;
    private String customerName;
    private double balance;
    private String accountType;
   // private ArrayList<String> accountProfile;
    public Account(int accountNumber, String customerName, String accountType, double balance)
    {
        System.out.println("Account constructor with parameters called");
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
    }


//
//    public String getTransactionInfo(int n)
//    {
//        String transaction = transactionSummary[n];
//        if (transaction == null)
//        {
//            return "Cannot Find Transaction Matching This Number";
//        }
//        else {
//            return transaction;
//             }
//    }
    public int getAccountNumber()
    {
        return accountNumber;
    }



    public double getBalance() {
        return balance;
    }


    public String getCustomerName() {
        return customerName;
    }

//    public Account (String customerName, double balance)
//    {
//
//        numOfAccounts ++;
//        transactions = new double[100];
//        accountType = new String [100];
//        transactions[0] = balance;
//        accountType[0] = "A balance of : $" + Double.toString(balance) +
//                " was deposited.";
//        numOfTransactions = 1;
//    }






}
