package com.revature.dataImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.PaymentBean;
import com.revature.data.ConnFactory;
import com.revature.data.TransactionDAO;
import com.revature.services.TransactionLedger;

public class TransactionLedgerDAOImpl implements TransactionDAO {

	//reference to the connection factory
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	@Override	//adds a transaction to the database
	public void createNewTranactionSQL(PaymentBean pb) throws SQLException {
		Connection conn = cf.getConnection();		//establishes a connection to the database
		String sql = "INSERT INTO TRANSACTION VALUES(SQ_TRANSACTION_PK.NEXTVAL,?,?,?,?)";	//inserts a new transaction to the datbase
		PreparedStatement ps = conn.prepareStatement(sql);		//creates a new prepared statmemnt
		ps.setInt(1,pb.getCarId());		//stores carId into slot 2
		ps.setString(2, pb.getCustomerUsername());	//stores customer user name into slot 3 
		ps.setDouble(3, pb.getMonthlyPayment());	//stores monthlyPayments into slot 4
		ps.setDouble(4, pb.getRemainingBalance());	//stores the remaining balance into slot 5
		ps.executeUpdate();		//executes update

	}

	@Override	//returns all transactions from the database
	public void returnTransactionLedgerSQL() throws SQLException {
		Connection conn = cf.getConnection();	//establishes a connection to the database
		Statement stmt = conn.createStatement();	//primes a statement
		ResultSet rs  = stmt.executeQuery("SELECT * FROM TRANSACTION");	//queries the database to select all from transaction table
		PaymentBean pb = null;	//new payment bean object
		while(rs.next()) {//while there is a next result set
			//constructs a new payment bean
			pb = new PaymentBean(rs.getInt(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5));
			pb.setAccountId(rs.getInt(1));		//sets accountId separate
			TransactionLedger.populateLedger(pb);	//populates the ledger with the newly constructed transaction
		}

	}

}
