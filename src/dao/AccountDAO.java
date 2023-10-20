package dao;

import java.sql.SQLException;
import java.util.List;

import model.Account;

public interface AccountDAO {
	
	int createAccount(Account account) throws SQLException;

	int updateAccount(String columnName, String value, String branchId) throws SQLException;

    void removeAccount(String accountId) throws SQLException;
    
    Account getAccountDetails(String accountId) throws SQLException;

}
