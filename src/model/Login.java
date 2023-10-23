package model;

public class Login {

	private int customer_id;
	private String password;
	private String role;
	
	
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public Login(int customer_id, String password, String role) {
		super();
		this.customer_id = customer_id;
		this.password = password;
		this.role = role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
