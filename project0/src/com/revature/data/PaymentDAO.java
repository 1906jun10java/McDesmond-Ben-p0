package com.revature.data;

import java.sql.SQLException;


public interface PaymentDAO {
	public void createNewPurchase(double offer,int customerID,int carID)
	throws SQLException;
	
	public double returnMonthlyPayment(int transactionID)
	throws SQLException;
	
	public double returnTotalBalance(int transactionID)
	throws SQLException;
	
	public void clearPaidCar(int transactionID)
	throws SQLException;

}
