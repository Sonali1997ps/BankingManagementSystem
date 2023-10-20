package model;

import java.sql.Date;

public class Employee extends Person{
	
	private String position;
	
	private int managerId;
	
	private int branchId;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public Employee(int id, String name, String phone, String email, Date registrationDate,
			String position, int managerId, int branchId) {
		super(id, name, phone, email, registrationDate);
		this.position = position;
		this.managerId = managerId;
		this.branchId = branchId;
	}

	public Employee() {
		super(0, "", "", "", null);
		this.position = "";
		this.managerId = 0;
		this.branchId = 0;
	}

	@Override
	public String toString() {
		return "Employee [position=" + position + ", managerId=" + managerId + ", branchId=" + branchId + super.toString();
	}
	
}

