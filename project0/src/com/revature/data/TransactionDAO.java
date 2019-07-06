package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.PaymentBean;

public interface TransactionDAO {
	
	public void createNewTranactionSQL(PaymentBean pb)
	throws SQLException;
	
	public void returnTransactionLedgerSQL()
	throws SQLException; 

}
