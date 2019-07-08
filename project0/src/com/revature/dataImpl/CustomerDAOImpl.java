package com.revature.dataImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Customer;
import com.revature.data.ConnFactory;
import com.revature.data.CustomerDAO;
import com.revature.services.Login;

public class CustomerDAOImpl implements CustomerDAO {

	//reference to the connection factory
	public static ConnFactory cf = ConnFactory.getInstance();
	
	//creates a new customer and adds them to the database
	@Override
	public void createNewCustomer(Customer c) throws SQLException {
		Connection conn = cf.getConnection();		//establishes the connection to sql
		String sql = "INSERT INTO CAR_Customer VALUES(SQ_CAR_CUSTOMER_PK.NEXTVAL,?,?,?,?)";		//sets the query to a string field
		PreparedStatement ps = conn.prepareStatement(sql);			//stores the query into the preparedStatement
		ps.setString(1,c.getUserName());	//sets customerUsername to first ?
		ps.setString(2, c.getPassword());	//sets customemrPassword to second ?
		ps.setString(3, c.getFirstName());	//sets customerFirstName to third ?
		ps.setString(4, c.getLastName());	//sets customerLastName to fourth ?
		ps.executeUpdate();					//executes the query

	}

	//returns all customers from sql to a data structure
	@Override
	public void returnCustomersSQL() throws SQLException {
		Connection conn = cf.getConnection();	//establishes the connection to sql
		Statement stmt = conn.createStatement();	//creates a statement linked to the connection
		ResultSet rs  = stmt.executeQuery("SELECT * FROM CAR_CUSTOMER");	//executes this query and holds the result set
		Customer c = null;	//new customer object
		while(rs.next()) {//while resultSet has a next
			//construct a new customer using resultset table data
			c = new Customer(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			//adds customer id seperate from the constructor
			c.setCustomerId(rs.getInt(1));
			//populates the login data structure
			Login.populateCustomerLogin(c);
		}
	}
}
