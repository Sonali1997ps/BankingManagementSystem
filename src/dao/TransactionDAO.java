package dao;

import model.Transaction;

public interface TransactionDAO {

	int createTransaction(Transaction transaction);
	
	void updateTransaction(Transaction transaction);

    void removeTransaction(int transaction_id);
    
    Transaction getTransactionById(int transaction_id);
    
}
