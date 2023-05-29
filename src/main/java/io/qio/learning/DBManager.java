package io.qio.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/***
    A class to manage database management system
 */
class DBManager {
    private String url;
    private String username;
    private String password;
    private Connection connection;

    // Parametrized Constructor
    public DBManager(String url, String username, String password) throws ClassNotFoundException, SQLException {
        this.url = url;
        this.username = username;
        this.password = password;
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(url, username, password);
    }

    // Disconnect the connection
    public void disconnect() throws SQLException {
        this.connection.close();
    }

    // Execute the sql query
    public void execute(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }

    // Ensure the closing of connection
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        disconnect();
    }
}