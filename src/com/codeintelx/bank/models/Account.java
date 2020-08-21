package com.codeintelx.bank.models;

public class Account
{
    private String customerName;
    private double balance;
    private String accountType;
    private String removeAccount;


    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public Account(String customerName, String accountType, double balance)
    {
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
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

}
