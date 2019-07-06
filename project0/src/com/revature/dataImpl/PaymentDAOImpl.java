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

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void addNewAccountSQL(PaymentBean p) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO PAYMENT VALUES(SQ_PAYMENT_PK.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, p.getCarId());
		ps.setDouble(2, p.getMonthlyPayment());
		ps.setDouble(3, p.getRemainingBalance());
		ps.setString(4, p.getCustomerUsername());
		ps.executeUpdate();

	}

	@Override
	public void populatePaymentsSQL() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM PAYMENT");
		PaymentBean p = null;
		while (rs.next()) {
			p = new PaymentBean(rs.getInt(2), rs.getString(5), rs.getDouble(3), rs.getDouble(4));
			p.setAccountId(rs.getInt(1));
			PaymentMap.createNewPaymentAccount(p);
		}
	}
	@Override
	public void removeFromPayment(PaymentBean pb) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM Payment WHERE ACCOUNT_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, pb.getAccountId());
		ps.executeUpdate();
		
	}

}
