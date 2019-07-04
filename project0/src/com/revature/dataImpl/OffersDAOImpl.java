package com.revature.dataImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.beans.OfferBean;
import com.revature.data.ConnFactory;
import com.revature.data.OffersDAO;
import com.revature.services.Offers;

public class OffersDAOImpl implements OffersDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createNewOffer(double offer, Customer customer, Car car) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO OFFERS VALUES(SQ_OFFERS_PK.NEXTVAL,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, customer.getCustomerId());
		ps.setInt(2, car.getCarId());
		ps.setDouble(3, offer);
		ps.executeUpdate();
	}

	@Override
	public  void returnOffers() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs  = stmt.executeQuery("SELECT * FROM OFFERS");
		OfferBean o = null;
		while(rs.next()) {
			o = new OfferBean(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
			Offers.populateOfferMap(o);
		}
	}

	@Override
	public void deleteOffers(Double offer) throws SQLException {
		// TODO Auto-generated method stub

	}

}
