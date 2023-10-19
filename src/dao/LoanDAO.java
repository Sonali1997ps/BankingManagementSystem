package dao;

import model.Loan;

public interface LoanDAO {

	Loan createLoan(Loan loan);
	
	void updateLoan(Loan loan);
	
	void removeLoan(int loan_id);
	
	Loan getLoanById(int loan_id);
	
}
