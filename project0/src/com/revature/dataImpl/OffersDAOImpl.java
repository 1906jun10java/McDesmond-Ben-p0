package com.revature.dataImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.OfferBean;
import com.revature.data.ConnFactory;
import com.revature.data.OffersDAO;
import com.revature.services.Offers;

public class OffersDAOImpl implements OffersDAO {

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void createNewOffer(OfferBean o) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO OFFERS VALUES(SQ_OFFERS_PK.NEXTVAL,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, o.getCarId());
		ps.setDouble(2, o.getOfferAmount());
		ps.setString(3, o.getCustomerUserName());
		ps.executeUpdate();
	}

	@Override
	public void returnOffers() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFERS");
		OfferBean o = null;
		while (rs.next()) {
			o = new OfferBean(rs.getInt(2), rs.getInt(3), rs.getString(4));
			o.setOfferId(rs.getInt(1));
			Offers.populateOfferMap(o);
		}
	}

	@Override
	public void deleteOffers(OfferBean o) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "DELETE FROM OFFERS WHERE CAR_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, o.getCarId());
		ps.executeUpdate();
	}
}
