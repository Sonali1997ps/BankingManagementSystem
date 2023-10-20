package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Loan {

	private int loanId;
	
	private int customerId;
	
	private int branchId;
	
	private Date startingDate;
	
	private Date dueDate;
	
	private BigDecimal amount;

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Loan(int loanId, int customerId, int branchId, Date startingDate, Date dueDate, BigDecimal amount) {
		super();
		this.loanId = loanId;
		this.customerId = customerId;
		this.branchId = branchId;
		this.startingDate = startingDate;
		this.dueDate = dueDate;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Loan [loanId=" + loanId + ", customerId=" + customerId + ", branchId=" + branchId + ", startingDate="
				+ startingDate + ", dueDate=" + dueDate + ", amount=" + amount + "]";
	}

	
}
