package model;

import java.math.BigDecimal;
import java.sql.Date;

public class Loan {

	private int id;
	
	private Customer customer;
	
	private Branch branch;
	
	private Date startingDate;
	
	private Date dueDate;
	
	private BigDecimal amount;
	
}
