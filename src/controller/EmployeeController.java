package controller;

import java.sql.SQLException;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

public class EmployeeController {
	EmployeeDAO employeeDAOImpl = new EmployeeDAOImpl();
	public int createEmployee(Employee employee) throws SQLException{
		return employeeDAOImpl.createEmployee(employee);		
	}
	
	public int updateEmployee(String columnName, int value, int employeeId) throws SQLException{
		return employeeDAOImpl.updateEmployee(columnName, value, employeeId);		
	}
	
	public void removeEmployee(int employeeId) throws SQLException{
		employeeDAOImpl.removeEmployee(employeeId);
	}
	
	public boolean setManager(){
//		To be implemented in service class
		return false;
		
	}

}
