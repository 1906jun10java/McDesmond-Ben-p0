package com.revature.dataImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.PaymentBean;
import com.revature.data.ConnFactory;
import com.revature.data.PaymentDAO;
import com.revature.services.PaymentMap;


public class PaymentDAOImpl implements PaymentDAO {

	//reference to the connection factory
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void addNewAccountSQL(PaymentBean p) throws SQLException {
		Connection conn = cf.getConnection();		//connection established to sql
		String sql = "INSERT INTO PAYMENT VALUES(SQ_PAYMENT_PK.NEXTVAL,?,?,?,?)";		//inserts into the payment table and iterates pk
		PreparedStatement ps = conn.prepareStatement(sql);		//primes the prepared statement
		ps.setInt(1, p.getCarId());					//stores the carId in slot 2
		ps.setDouble(2, p.getMonthlyPayment());		//stores the monthlyPayments to slot 3
		ps.setDouble(3, p.getRemainingBalance());	//stores the remainingBalance into slot4
		ps.setString(4, p.getCustomerUsername());	//stores the customers username into slot 5
		ps.executeUpdate();							//executes update

	}
	
	//populates the payment data structure from the sql server
	@Override
	public void populatePaymentsSQL() throws SQLException {
		Connection conn = cf.getConnection();		//establishes a connection to the database
		Statement stmt = conn.createStatement();	//primes a statement
		ResultSet rs = stmt.executeQuery("SELECT * FROM PAYMENT");	//selects all from payment and returns a result set
		PaymentBean p = null;	//creates a new payment bean object
		while (rs.next()) {	//while the result set has another
			
			//constructs a new payment object
			p = new PaymentBean(rs.getInt(2), rs.getString(5), rs.getDouble(3), rs.getDouble(4));
			p.setAccountId(rs.getInt(1));		//sets the account id separate
			PaymentMap.createNewPaymentAccount(p);		//stores the new object in the data structure
		}
	}
	
	//removes a payemnt record that matches the payment objects accountID
	@Override
	public void removeFromPayment(PaymentBean pb) throws SQLException {
		Connection conn = cf.getConnection();		//establishes a connection to the database
		String sql = "DELETE FROM Payment WHERE ACCOUNT_ID = ?";		//deletes from payment where accountId = something
		PreparedStatement ps = conn.prepareStatement(sql);		//primes the prepared statement
		ps.setInt(1, pb.getAccountId());						// stores the accountID into the query
		ps.executeUpdate();		//execute update
		
	}

}
