package com.codeintelx.bank.services;

import com.codeintelx.bank.models.Account;

import java.util.ArrayList;

public class Transactions {
    public Transactions() {
    }

    private double withdrawalAmount;
    private double depositAmount;
    ArrayList<Account> customer = new ArrayList<>(); //can pull from variables from the Account Class

    public String createAccount(double accountNumber, String customerName, String accountType, double balance) {
        customer.add(new Account(accountNumber, customerName,
                accountType, balance));
        System.out.println("Account: " + accountNumber + "\n" + "User Name: " + customerName + "\n"
                + "Account Type: " + accountType + "\n" + "Balance: " + balance + "\n");
    return null;
    }


    //("Input User Name");


    public String viewAccount(double customerAccount) {
        for (int i = 0; i < customer.size(); i++) {
            if (customerAccount == (customer.get(i).getAccountNumber())) {
                System.out.println("Account Number: " + customer.get(i).getAccountNumber() + "User Name:" + customer.get(i).getCustomerName()
                        + "Account Type:" + customer.get(i).getAccountType() + "Balance:" + customer.get(i).getBalance());
            } else {
                return "Account Not Found";
            }
        }
        return null;
    }

    //
//
//
    public void deposit(double customerAccDeposit, double depositAmmt) {
        for (int i = 0; i < customer.size(); i++) {
            if (customerAccDeposit == (customer.get(i).getAccountNumber())) {
                depositAmmt += customer.get(i).getBalance();
                customer.get(i).setBalance(depositAmmt);
                System.out.println("$" + depositAmmt + "has been deposited");
            } else if (depositAmmt < 0) {
                System.out.println("Can't deposit non-positive amount");
            }
        }
    }

    //
    public void withdraw(double customerAccWithdraw, double withdrawAmtt) {
        for (int i = 0; i < customer.size(); i++) {
            if (customerAccWithdraw == (customer.get(i).getAccountNumber())) {
               double withdraw = customer.get(i).getBalance() - withdrawAmtt;
                customer.get(i).setBalance(withdraw);
                System.out.println("$" + withdrawAmtt + " has been withdrawn");
             if (withdraw >0)
             {
                 System.out.println("Balance " + withdraw );
             }
             else
                 {
                 System.out.println("Withdrawal can't be completed.");
             }
            }// else if (withdrawAmtt < 0 || withdrawAmtt > customer.get(i).getBalance()) {


            }

        }
    }

