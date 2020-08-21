package com.codeintelx.bank.services;
import com.codeintelx.bank.models.Account;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Transactions
{

    Map<String, Account> customerID = new HashMap<>();


    public Account createAccount(String customerName, String accountType, double balance)
    {
        UUID uuid = UUID.randomUUID();
        String accountNumber = Long.toString(uuid.getMostSignificantBits()).substring(0,11).replace("-", "");

        Account customer = (new Account(customerName, accountType, balance));
        customerID.put(accountNumber, customer);
        System.out.println("Account Number: " + accountNumber + "\n " + "User Name: " + customerID.get(accountNumber).getCustomerName() + "\n " +
                "Account Type: " + "\n " + customerID.get(accountNumber).getAccountType() +
                "Balance: " + "\n " + customerID.get(accountNumber).getBalance());
        return customer;
    }


    public String viewAccount(String customerAccount)
    {
            if (customerID.containsKey(customerAccount))
            {
                System.out.println("Account Number: " + customerAccount + "\n " + "User Name: " + customerID.get(customerAccount).getCustomerName() +
                        "\n " + "Account Type: " + customerID.get(customerAccount).getAccountType() + "\n " +
                        "Balance: " + customerID.get(customerAccount).getBalance());
            } else
            {
                return "Account Not Found";
            }
        return null;
    }

    public double deposit(String customerAccount, double customerAccDeposit)
    {double customerDeposit=0;
            if (customerID.containsKey(customerAccount))
            {
                customerDeposit = customerID.get(customerAccount).getBalance() + customerAccDeposit;
                customerID.get(customerAccount).setBalance(customerDeposit);
                System.out.println("$" + customerAccDeposit + "has been deposited");
            } else if (customerAccDeposit < 0)
            {
                System.out.println("Can't deposit non-positive amount");
            }

                return customerDeposit;

    }

    public double withdraw(String customerAccount, double customerAccWithdraw)
    {double customerWithdraw = 0;

            if (customerID.containsKey(customerAccount))
            {
                customerWithdraw = customerID.get(customerAccount).getBalance() - customerAccWithdraw;
                customerID.get(customerAccount).setBalance(customerWithdraw);
                System.out.println("$" + customerAccWithdraw + " has been withdrawn");
                if (customerAccWithdraw > 0)
                {
                    System.out.println("Balance " + customerWithdraw);
                } else {
                    System.out.println("Withdrawal can't be completed.");
                }

            }


        return customerWithdraw;
    }

    public Account removeAccount(String customerAccount)
    {
           return customerID.remove(customerAccount);
           // return
    }

    public Account accountIdentity(String customerAccount)
    {
        return customerID.get(customerAccount);
    }

}
