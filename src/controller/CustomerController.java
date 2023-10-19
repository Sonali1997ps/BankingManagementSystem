package controller;

import java.sql.SQLException;
import java.util.List;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import model.Customer;

public class CustomerController {
	
	CustomerDAO customerDAOImpl = new CustomerDAOImpl();
	
	public int createCustomer(Customer customer) throws SQLException {
		return customerDAOImpl.createCustomer(customer);
	}
	
	public void removeCustomer(String customrId) throws SQLException{
		customerDAOImpl.removeCustomer(customrId);	
	}
	
	public Customer getCustomerOfAccount(String accountNumber){
		
//		To be implemented in service layer
		return null;
		
	}
	
	public Customer findCustomerByID(int id) {
		return null;
		
	}
	
	public List<Customer> findCustomersByName(String name) {
		return null;
		
	}	
}

