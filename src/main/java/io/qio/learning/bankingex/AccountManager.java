package io.qio.learning.bankingex;

import io.qio.learning.DBManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AccountManager {

    private DBManager dbManager;

    public AccountManager(DBManager dbManager) throws SQLException {
        this.dbManager = dbManager;
        this.dbManager.execute("Create Table if not exists Accounts (account_id int, balance numeric(10,2), created_date date)");
    }

    public void createAccount(Account account) throws SQLException {
        PreparedStatement statement = dbManager.getPreparedStatement("Insert into accounts (account_id, balance, created_date) values (?,?,?)");
        statement.setInt(1, account.getAccountId());
        statement.setDouble(2, account.getBalance());
        statement.setDate(3, new java.sql.Date(account.getCreatedDate().getTime()));
        dbManager.execute(statement);
    }

    public void updateAccount(Account account){

    }

    public void deleteAccount(Account account){

    }

    public Account searchAccount(Account account){
        return null;
    }

    public List<Account> getAllAccounts(Account account){
        return null;
    }
}
