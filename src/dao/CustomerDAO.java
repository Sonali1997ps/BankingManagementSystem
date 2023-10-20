package dao;

import java.sql.SQLException;
import java.util.List;

import model.Account;
import model.Customer;

public interface CustomerDAO {
	
	int createCustomer(Customer customer) throws SQLException;
	
	void removeCustomer(int customerID)throws SQLException;
	
	int updateCustomer(String columnName, int value, int customerId)throws SQLException;
	
	Customer findCustomerByID(int customer_id)throws SQLException;
	
}
