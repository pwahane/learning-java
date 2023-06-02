package io.qio.learning;

import java.sql.*;

/***
    A class to manage database management system
 */
public class DBManager {
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
    public Boolean execute(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.execute(sql);
    }

    public ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    public PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return this.connection.prepareStatement(sql);
    }

    public int execute(PreparedStatement preparedStatement) throws SQLException {
        return preparedStatement.executeUpdate();
    }

    // Ensure the closing of connection
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        disconnect();
    }
}