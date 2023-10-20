package model;

public class Branch {
	
	private int id;
	
	private String address;
	
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Branch [id=" + id + ", address=" + address + ", phone=" + phone + "]";
	}

	public Branch(int id, String address, String phone) {
		super();
		this.id = id;
		this.address = address;
		this.phone = phone;
	}

	public Branch() {
		// TODO Auto-generated constructor stub
		this.id = 0;
		this.address = "";
		this.phone = "";
	}
}

