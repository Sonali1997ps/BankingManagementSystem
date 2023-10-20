package dao;

import java.sql.SQLException;
import java.util.List;

import model.Account;

public interface AccountDAO {
	
	int createAccount(Account account) throws SQLException;

	int updateAccount(String columnName, String value, int branchId) throws SQLException;

    void removeAccount(int accountId) throws SQLException;
    
    Account getAccountDetails(int accountId) throws SQLException;

}
