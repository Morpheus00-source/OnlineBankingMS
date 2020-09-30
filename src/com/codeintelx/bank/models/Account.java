package com.codeintelx.bank.models;
public class Account
{
    private String customerName;
    private double balance;
    private String accountType;
    private String accountNumber;

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
    public void setBalance(double balance)
    {
        this.balance = balance;
    }
}
