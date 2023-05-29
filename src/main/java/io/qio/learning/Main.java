package io.qio.learning;

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
            dbManager.execute("Drop table if exists account");
            // Create a table
            dbManager.execute("Create table account (account_number int, balance numeric(10,2))");


            // Insert Data
            for (int i = 1; i <= 100l; i++) {
                dbManager.execute("INSERT into account values(" + i + "," + random.nextInt(100000) + ")");
            }

            // Retrieve data
            ResultSet resultSet = dbManager.executeQuery("Select * from account");

            while (resultSet.next()) {
                int accountNumber = resultSet.getInt(1);
                double balance = resultSet.getDouble(2);
                System.out.println(accountNumber + "---->" + balance);
            }

            // Disconnect from database system
            dbManager.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}