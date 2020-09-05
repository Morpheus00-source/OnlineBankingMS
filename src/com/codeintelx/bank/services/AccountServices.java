package com.codeintelx.bank.services;
import com.codeintelx.bank.exceptions.AccountNotFoundException;
import com.codeintelx.bank.exceptions.InsufficientFundsException;
import com.codeintelx.bank.models.Account;
import java.util.*;

public class AccountServices
{

   private final Map<String, Account> customerAccounts = new HashMap<>();


    public Account createAccount(String customerName, String accountType, double balance)
    {
        UUID uuid = UUID.randomUUID();
        String accountNumber = Long.toString(uuid.getMostSignificantBits()).substring(0, 11).replace("-", "");
        Account customer = (new Account(accountNumber,customerName, accountType, balance));
        customerAccounts.put(accountNumber, customer);

        return customer;
    }
    public Account viewAccount(String customerAccount) throws AccountNotFoundException
    {

        if (customerAccounts.containsKey(customerAccount))
        {
            customerAccounts.get(customerAccount);
        }
        else {
            throw new AccountNotFoundException("Account Not Found");
        }
        return customerAccounts.get(customerAccount);
    }
    public Account withdraw(String customerAccount, double customerAccWithdraw) throws AccountNotFoundException, InsufficientFundsException
    {double customerWithdraw;

            if (customerAccounts.containsKey(customerAccount))
            {
                customerWithdraw = customerAccounts.get(customerAccount).getBalance() - customerAccWithdraw;

                if (customerWithdraw < 0)
                {
                    throw new InsufficientFundsException("Insufficient Funds");

                } else {
                    customerAccounts.get(customerAccount).setBalance(customerWithdraw);
                }
            } else {
                throw new AccountNotFoundException("Account Not Found");
            }
            return customerAccounts.get(customerAccount);
    }

    public Account deposit(String customerAccount, double customerAccDeposit) throws AccountNotFoundException{
        double customerDeposit;
        if (customerAccounts.containsKey(customerAccount))
        {
            customerDeposit = customerAccounts.get(customerAccount).getBalance() + customerAccDeposit;
            customerAccounts.get(customerAccount).setBalance(customerDeposit);
        }else
        {
            throw new AccountNotFoundException("Account Not Found");
        }
        return customerAccounts.get(customerAccount);
    }
    public Account removeAccount(String customerAccount) throws AccountNotFoundException
    {
        if (customerAccounts.containsKey(customerAccount))
        {
            return customerAccounts.remove(customerAccount);
        }
        else {
            throw new AccountNotFoundException("Account Not Found");
        }
    }
    public Map<String, Account> viewAllAccounts ()
    {
        return customerAccounts;
    }

    public Account accountIdentity(String customerAccount)
    {
        return customerAccounts.get(customerAccount);
    }

}
