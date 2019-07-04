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

	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createNewCustomer(Customer c) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CAR_Customer VALUES(SQ_CAR_CUSTOMER_PK.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,c.getUserName());
		ps.setString(2, c.getPassword());
		ps.setString(3, c.getFirstName());
		ps.setString(4, c.getLastName());
		ps.executeUpdate();

	}


	@Override
	public void returnCustomersSQL() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs  = stmt.executeQuery("SELECT * FROM CAR_CUSTOMER");
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			c.setCustomerId(rs.getInt(1));
			Login.populateCustomerLogin(c);
		}
	}
}
