package controller;

import java.sql.SQLException;
import java.util.List;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import model.Account;

public class AccountController {
	AccountDAO accountDAOImpl = new AccountDAOImpl();
	public int createAccount(Account account) throws SQLException{
		return accountDAOImpl.createAccount(account);
	}
	
	public int updateAccount(String columnName, String value, int accountId) throws SQLException{
		return accountDAOImpl.updateAccount(columnName, value, accountId);		
	}
	
	public void removeAccount(int accountId) throws SQLException{
		accountDAOImpl.removeAccount(accountId);
	}
	
	public List<Account> getAccountsOfCustomer(int customer_id) {
//		To be implemented in service layer
		return null;
	}
	
	public Account getAccountDetails(int accountId) throws SQLException {
		return accountDAOImpl.getAccountDetails(accountId);
	}
}
