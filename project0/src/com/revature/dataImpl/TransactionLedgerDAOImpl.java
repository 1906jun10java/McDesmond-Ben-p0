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

	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	
	@Override	//adds a transaction to the database
	public void createNewTranactionSQL(PaymentBean pb) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO TRANSACTION VALUES(SQ_TRANSACTION_PK.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1,pb.getCarId());
		ps.setString(2, pb.getCustomerUsername());
		ps.setDouble(3, pb.getMonthlyPayment());
		ps.setDouble(4, pb.getRemainingBalance());
		ps.executeUpdate();

	}

	@Override	//returns all transactions from the database
	public void returnTransactionLedgerSQL() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs  = stmt.executeQuery("SELECT * FROM TRANSACTION");
		PaymentBean pb = null;
		while(rs.next()) {
			pb = new PaymentBean(rs.getInt(2),rs.getString(3),rs.getDouble(4),rs.getDouble(5));
			pb.setAccountId(rs.getInt(1));
			TransactionLedger.populateLedger(pb);
		}

	}

}
