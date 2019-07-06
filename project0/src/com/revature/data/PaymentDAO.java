package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.PaymentBean;


public interface PaymentDAO {
	
	public void addNewAccountSQL(PaymentBean p) 
			throws SQLException;
	
	public void populatePaymentsSQL() 
			throws SQLException;

}
