package com.codeintelx.bank.exceptions;

public class InsufficientFundsException extends Exception
{
    public InsufficientFundsException (String errorMessage)  {
        super(errorMessage);
    }
}
