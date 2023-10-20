package model;

import java.sql.Date;

public class Employee extends Person{
	
	private String position;
	
	private Employee manager;
	
	private Branch branch;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Employee(int id, String login, int passhash, String name, String phone, String email, Date registrationDate,
			String position, Employee manager, Branch branch) {
		super(id, login, passhash, name, phone, email, registrationDate);
		this.position = position;
		this.manager = manager;
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Employee [position=" + position + ", manager=" + manager + ", branch=" + branch + super.toString();
	}
	
}

