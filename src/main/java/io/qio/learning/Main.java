package io.qio.learning;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        try {
            // Load the postgres database driver in memory
            Class.forName("org.postgresql.Driver");
            // Create a connection
            String host = "localhost";
            String port = "5432";
            String database = "postgres";
            String username = "postgres";
            String password = "myPassword123";
            Connection connection = DriverManager.getConnection("jdbc:postgresql://"+host+":"+port+"/"+database, username, password);
            // ----- Your database code goes here
            System.out.println(connection.getMetaData().getDatabaseProductName());
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}