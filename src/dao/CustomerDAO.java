package dao;

import java.sql.SQLException;
import java.util.List;

import model.Account;
import model.Customer;

public interface CustomerDAO {
	
	int createCustomer(Customer customer) throws SQLException;
	
	void removeCustomer(String customerID)throws SQLException;
	
	int updateCustomer(String columnName, String value)throws SQLException;
	
	Customer findCustomerByID(String customer_id)throws SQLException;
	
}
