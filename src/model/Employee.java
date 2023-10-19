package model;

import java.sql.Date;

public class Employee extends Person{
	
	private String position;
	
	private String managerId;
	
	private String branchId;

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public Employee(int id, String name, String phone, String email, Date registrationDate,
			String position, String managerId, String branchId) {
		super(id, name, phone, email, registrationDate);
		this.position = position;
		this.managerId = managerId;
		this.branchId = branchId;
	}

	public Employee() {
		super(0, "", "", "", null);
		this.position = "";
		this.managerId = "";
		this.branchId = "";
	}

	@Override
	public String toString() {
		return "Employee [position=" + position + ", managerId=" + managerId + ", branchId=" + branchId + super.toString();
	}
	
}

