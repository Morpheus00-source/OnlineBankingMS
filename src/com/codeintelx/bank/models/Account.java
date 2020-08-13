package com.codeintelx.bank.models;

import java.util.ArrayList;
import java.util.Scanner;

public class Account
{
    private double accountNumber;
    private String customerName;
    private double balance;
    private String accountType;

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    // private ArrayList<String> accountProfile;
    public Account(double accountNumber, String customerName, String accountType, double balance)
    {
        //Account constructor with parameters called
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
    }

    public double getAccountNumber()
    {
        // accountNumber = Math.random();
        return accountNumber;
    }

    public String getAccountType()
    {
       return accountType;
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
