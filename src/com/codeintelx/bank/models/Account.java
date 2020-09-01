package com.codeintelx.bank.models;

import java.util.Map;
import java.util.UUID;

public class Account
{
    private String customerName;
    private double balance;
    private String accountType;
    private String accountNumber;
    private String masterView;

    public String getMasterView() {
        return masterView;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public Account(String accountNumber, String customerName, String accountType, double balance)
    {
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getAccountType()
    {
       return accountType;
    }


    public double getBalance()
    {
        return balance;
    }


    public String getCustomerName()
    {
        return customerName;
    }
    public String getAccountNumber()
    {
        return accountNumber;
    }


}
