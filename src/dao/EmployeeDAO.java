package dao;

import java.sql.SQLException;

import model.Employee;

public interface EmployeeDAO {

	int createEmployee(Employee employee) throws SQLException;
	
	int updateEmployee(String columnName, int value, int employeeId) throws SQLException;
	
	void removeEmployee(int employeeId) throws SQLException;
	
	Employee getEmployeeById(int employeeId) throws SQLException;
	
}
