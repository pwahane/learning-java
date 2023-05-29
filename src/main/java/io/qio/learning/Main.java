package io.qio.learning;

public class Main {
    public static void main(String[] args) {
        try {
            String host = "localhost";
            String port = "5432";
            String database = "postgres";
            String username = "postgres";
            String password = "myPassword123";
            String url = "jdbc:postgresql://"+host+":"+port+"/"+database;

            // Create a DBManager instance
            DBManager dbManager = new DBManager(url, username, password);
            // Create a table
            dbManager.execute("Create table account (account_number int)");
            // Insert Data
            dbManager.execute("INSERT into account values(1)");
            // Disconnect from database system
            dbManager.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}