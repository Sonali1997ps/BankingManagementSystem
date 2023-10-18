package dao;

import java.util.List;

import model.Account;
import model.Customer;

public interface CustomerDAO {
	
	Customer createCustomer();
	
	boolean removeCustomer(Customer customer);
	
	void updateCustomer(Customer customer);
	
	Customer getCustomerOfAccount(Account account);
	
	Customer findCustomerByID(int id);
	
	List<Customer> findCustomersByName(String name);
	
}
