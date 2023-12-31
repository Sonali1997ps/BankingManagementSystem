package dao;

import model.Employee;

public interface EmployeeDAO {

	Employee createEmployee(Employee employee);
	
	boolean updateEmployee(Employee employee);
	
	boolean removeEmployee(Employee employee);
	
	boolean setManager(Employee employee);
	
	Employee getEmployeeById(int employe_id);
	
}
