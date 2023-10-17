package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Account {
	
	private int id;
	
	private Customer customer;
	
	private Branch branch;
	
	private Date openingDate;
	
	private BigDecimal currentBalance;
	
	private BigDecimal interestRate;
	
}

