package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.PaymentBean;

public interface TransactionDAO {
	
	//adds a recent transaction to the sql database
	public void createNewTranactionSQL(PaymentBean pb)
	throws SQLException;
	
	//returns all transactions from the sql database
	public void returnTransactionLedgerSQL()
	throws SQLException; 

}
