package com.codeintelx.bank.services;
import com.codeintelx.bank.models.Account;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Transactions
{

    Map<String, Account> customerID = new HashMap<>();


    public Account createAccount(String accountNumber, String customerName, String accountType, double balance)
    {
        Account customer = (new Account(accountNumber,customerName, accountType, balance));
        customerID.put(accountNumber, customer);

        return customer;
    }
    public Account viewAccount(String customerAccount)
    {

        if (customerID.containsKey(customerAccount))
        {
            customerID.get(customerAccount);
        }
        else {
           // return null;
            throw new FileSystemNotFoundException();
        }
        return customerID.get(customerAccount);
    }
    public Account withdraw(String customerAccount, double customerAccWithdraw)
    {double customerWithdraw = 0;

            if (customerID.containsKey(customerAccount))
            {
                customerWithdraw = customerID.get(customerAccount).getBalance() - customerAccWithdraw;

                if (customerWithdraw < 0)
                {
                    throw new ArithmeticException();
                } else {
                    customerID.get(customerAccount).setBalance(customerWithdraw);
                }
            } else {
                throw new FileSystemNotFoundException();
            }
            return customerID.get(customerAccount);
    }

    public Account deposit(String customerAccount, double customerAccDeposit) {
        double customerDeposit = 0;
        if (customerID.containsKey(customerAccount)) {
            customerDeposit = customerID.get(customerAccount).getBalance() + customerAccDeposit;
            customerID.get(customerAccount).setBalance(customerDeposit);
        }else {
            throw new FileSystemNotFoundException();
        }
        return customerID.get(customerAccount);
    }
    public Account removeAccount(String customerAccount)
    {
        if (customerID.containsKey(customerAccount))
        {
            return customerID.remove(customerAccount);
        }
        else {
            throw new FileSystemNotFoundException();
        }
    }

    public Account accountIdentity(String customerAccount)
    {
        return customerID.get(customerAccount);
    }

}
