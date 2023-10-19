package dao;

import java.sql.SQLException;

import model.Employee;

public interface EmployeeDAO {

	int createEmployee(Employee employee) throws SQLException;
	
	int updateEmployee(String columnName, String value) throws SQLException;
	
	void removeEmployee(String employeeId) throws SQLException;
	
	Employee getEmployeeById(String employeeId) throws SQLException;
	
}
