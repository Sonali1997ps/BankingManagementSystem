package model;

import java.sql.Date;

public class Person {
	
	private int id;
	
	private String name;
	private String phone;
	private String email;
	
	private Date registrationDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Person(int id, String name, String phone, String email, Date registrationDate) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", phone="+ phone + ", email=" + email + 
				", registrationDate=" + registrationDate + "]";
	}


}
