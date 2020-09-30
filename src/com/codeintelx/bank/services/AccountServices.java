package com.codeintelx.bank.services;
import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;
import java.util.*;

public class AccountServices {

    private final Map<String, Account> customerAccounts = new HashMap<>();


    public Account createAccount(String customerName, String accountType, double balance)
    {
        UUID uuid = UUID.randomUUID();
        String accountNumber = Long.toString(uuid.getMostSignificantBits()).substring(0, 11).replace("-", "");
        Account customer = new Account(accountNumber, customerName, accountType, balance);
        customerAccounts.put(accountNumber, customer);

        return customer;
    }

    public Account getAccount(String customerAccount) throws AccountNotFoundException
    {

        if (!customerAccounts.containsKey(customerAccount))
        {
            throw new AccountNotFoundException("Account Not Found");
        }
        return customerAccounts.get(customerAccount);
    }

    public Account withdraw(String customerAccount, double withdrawalAmount) throws AccountNotFoundException, InsufficientFundsException
    {
        double newBalance;

        Account foundAccount = getAccount(customerAccount);

        newBalance = foundAccount.getBalance() - withdrawalAmount;

        if (newBalance < 0)
        {
            throw new InsufficientFundsException("Insufficient Funds");
        }
        else
        {
            foundAccount.setBalance(newBalance);
            customerAccounts.put(customerAccount, foundAccount);
        }

        return foundAccount;
    }

    public Account deposit(String customerAccount, double depositAmount) throws AccountNotFoundException
    {
        double newBalance;

        Account foundAccount = getAccount(customerAccount);

        newBalance = foundAccount.getBalance() + depositAmount;
        foundAccount.setBalance(newBalance);
        customerAccounts.put(customerAccount, foundAccount);

        return foundAccount;
    }

    public Account removeAccount(String customerAccount)
    {
            return customerAccounts.remove(customerAccount);
    }

    public Map<String, Account> viewAllAccounts()
    {
        return customerAccounts;
    }

}

