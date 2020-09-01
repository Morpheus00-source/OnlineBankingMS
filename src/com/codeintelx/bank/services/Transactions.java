package com.codeintelx.bank.services;
import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transactions
{

   private Map<String, Account> customerID = new HashMap<>();


    public Account createAccount(String accountNumber, String customerName, String accountType, double balance)
    {
        Account customer = (new Account(accountNumber,customerName, accountType, balance));
        customerID.put(accountNumber, customer);

        return customer;
    }
    public Account viewAccount(String customerAccount) throws AccountNotFoundException
    {

        if (customerID.containsKey(customerAccount))
        {
            customerID.get(customerAccount);
        }
        else {
            throw new AccountNotFoundException("Account Not Found");
        }
        return customerID.get(customerAccount);
    }
    public Account withdraw(String customerAccount, double customerAccWithdraw) throws AccountNotFoundException, InsufficientFundsException
    {double customerWithdraw;

            if (customerID.containsKey(customerAccount))
            {
                customerWithdraw = customerID.get(customerAccount).getBalance() - customerAccWithdraw;

                if (customerWithdraw < 0)
                {
                    throw new InsufficientFundsException("You Broke");

                } else {
                    customerID.get(customerAccount).setBalance(customerWithdraw);
                }
            } else {
                throw new AccountNotFoundException("Account Not Found");
            }
            return customerID.get(customerAccount);
    }

    public Account deposit(String customerAccount, double customerAccDeposit) throws AccountNotFoundException{
        double customerDeposit;
        if (customerID.containsKey(customerAccount)) {
            customerDeposit = customerID.get(customerAccount).getBalance() + customerAccDeposit;
            customerID.get(customerAccount).setBalance(customerDeposit);
        }else {
            throw new AccountNotFoundException("Account Not Found");
        }
        return customerID.get(customerAccount);
    }
    public Account removeAccount(String customerAccount) throws AccountNotFoundException
    {
        if (customerID.containsKey(customerAccount))
        {
            return customerID.remove(customerAccount);
        }
        else {
            throw new AccountNotFoundException("Account Not Found");
        }
    }
    public String masterViewAccount ()
    {
        for (Map.Entry<String,Account> masterView : customerID.entrySet())
        {
            System.out.println("Account Number: " + masterView.getKey() + " User Name: " + masterView.getValue().getCustomerName()
                    + " Account Type: " + masterView.getValue().getAccountType() + " Balance: " + masterView.getValue().getBalance());

        }
       return "error occurred";
    }

    public Account accountIdentity(String customerAccount)
    {
        return customerID.get(customerAccount);
    }

}
