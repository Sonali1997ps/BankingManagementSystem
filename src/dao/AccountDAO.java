package dao;

import java.util.List;

import model.Account;

public interface AccountDAO {
	
	int createAccount(Account account);

	boolean updateAccount(Account account);

    boolean removeAccount(int id);

    List<Account> getAccountsOfCustomer(int customer_id);
    
    Account getAccountDetails(int id);

}
