package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.PaymentBean;


public interface PaymentDAO {
	
	//adds a new account on the sql server
	public void addNewAccountSQL(PaymentBean p) 
			throws SQLException;
	
	//adds recent payments to the java data structure
	public void populatePaymentsSQL() 
			throws SQLException;
	
	//removes all previous payments from the database
	public void removeFromPayment(PaymentBean pb) 
			throws SQLException;
}
