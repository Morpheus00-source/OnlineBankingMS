package com.codeintelx.bank.Repository;

import com.codeintelx.bank.models.Account;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class AccountsRepository {

        public Account createAccount(String accountNumber, String customerName, String accountType, double balance) throws SQLException {
            String url = "jdbc:mysql://localhost:3306/OnlineBankingManagementSystem";
            String user = "root";
            String password = "Olddominion15";

            Connection myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();
            String sql = "insert into Accounts values('1234567890', 'Munirr Sesay', 'Checking', 234)";
            ResultSet resultSet = myStmt.executeQuery(sql);

            return null;
        }

//
////        while (rs.next())
////            System.out.println(resultSet.getString("accounts"));
//
//
////    public AccountServices myBankingDatabase()
////    {
////        String url = ;
////        Connection myConn = DriverManager.getConnection(url)
////
////
////    }
//
//
//    public AccountsRepository() throws SQLException
//    {
//    }
}
