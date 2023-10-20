package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Account {
	
	private int id;
	
	private String customerId;
	
	private String branchId;
	
	private Date openingDate;
	
	private BigDecimal currentBalance;
	
	private String accontTypeId;


	public Account() {
		super();
		this.id = 0;
		this.customerId = "";
		this.branchId = "";
		this.openingDate = null;
		this.currentBalance = null;
		this.accontTypeId = "";
	}

	public Account(int id, String customerId, String branchId, Date openingDate, BigDecimal currentBalance,
			String accontTypeId) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.branchId = branchId;
		this.openingDate = openingDate;
		this.currentBalance = currentBalance;
		this.accontTypeId = accontTypeId;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", customerId=" + customerId + ", branchId=" + branchId + ", openingDate="
				+ openingDate + ", currentBalance=" + currentBalance + ", accontTypeId=" + accontTypeId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}

	public Date getOpeningDate() {
		return openingDate;
	}

	public void setOpeningDate(Date openingDate) {
		this.openingDate = openingDate;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAccontTypeId() {
		return accontTypeId;
	}

	public void setAccontTypeId(String accontTypeId) {
		this.accontTypeId = accontTypeId;
	}
	
}

