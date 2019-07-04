package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.Customer;

public interface CustomerDAO {
	
	public void createNewCustomer(Customer c)
	throws SQLException;
	
	public void returnCustomersSQL()
	throws SQLException;  

}
