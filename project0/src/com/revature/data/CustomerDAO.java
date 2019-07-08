package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.Customer;

public interface CustomerDAO {
	
	//creates a new customer in the sql databsase
	public void createNewCustomer(Customer c)
	throws SQLException;
	
	//returns the customers to a data structure java side
	public void returnCustomersSQL()
	throws SQLException;  

}
