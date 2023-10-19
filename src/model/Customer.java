package model;

import java.sql.Date;
import java.util.Set;

public class Customer extends Person{
	
	private Set<Account> accounts;
	
	private Set<Loan> loans;

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}

	public Customer(int id, String name, String phone, String email, Date registrationDate,Set<Account> accounts, Set<Loan> loans) {
		super(id, name, phone,email, registrationDate);
		this.accounts = accounts;
		this.loans = loans;
	}

	public Customer() {
		super(0, "", "", "", null);
		this.accounts = null;
		this.loans = null;
	}
	
	@Override
	public String toString() {
		return "Customer [accounts=" + accounts + ", loans=" + loans + super.toString() ;
	}
	
}

