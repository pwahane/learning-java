package io.qio.learning;

import io.qio.learning.bankingex.Account;
import io.qio.learning.bankingex.AccountManager;

import java.sql.ResultSet;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            String host = "localhost";
            String port = "5432";
            String database = "postgres";
            String username = "postgres";
            String password = "myPassword123";
            String url = "jdbc:postgresql://" + host + ":" + port + "/" + database;

            Random random = new Random();

            // Create a DBManager instance
            DBManager dbManager = new DBManager(url, username, password);
            AccountManager accountManager = new AccountManager();

            accountManager.createAccount(new Account(1,100));

            // Disconnect from database system
            dbManager.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}