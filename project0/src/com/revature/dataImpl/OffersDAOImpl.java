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

	//reference to the connection factory
	public static ConnFactory cf = ConnFactory.getInstance();

	//creates a new offer record in the sql database
	@Override
	public void createNewOffer(OfferBean o) throws SQLException {
		Connection conn = cf.getConnection();		//connects to the sql database
		String sql = "INSERT INTO OFFERS VALUES(SQ_OFFERS_PK.NEXTVAL,?,?,?)";	//stores the query in a string
		PreparedStatement ps = conn.prepareStatement(sql);		//stores the prepared statement 
		ps.setInt(1, o.getCarId());			//inserts the car id 
		ps.setDouble(2, o.getOfferAmount());		//inserts the offer amount 
		ps.setString(3, o.getCustomerUserName());	//inserts the customers name
		ps.executeUpdate();		//execute query
	}

	//returns all offers from the sql data structure
	@Override
	public void returnOffers() throws SQLException {
		Connection conn = cf.getConnection();		//establishes a connection to the sql database
		Statement stmt = conn.createStatement();	//primes the statement
		ResultSet rs = stmt.executeQuery("SELECT * FROM OFFERS");	//stores the result set from the query
		OfferBean o = null;		//creates a new offer object
		while (rs.next()) {		//while there is another offer
			//constructs a new offer
			o = new OfferBean(rs.getInt(2), rs.getInt(3), rs.getString(4));
			o.setOfferId(rs.getInt(1));		//stores the offerId seperate
			Offers.populateOfferMap(o);		//populates the offer map with an object
		}
	}

	//deletes any offers that match the car id
	@Override
	public void deleteOffers(OfferBean o) throws SQLException {
		Connection conn = cf.getConnection();		//establishes a connection to the sql database
		String sql = "DELETE FROM OFFERS WHERE CAR_ID = ?";		//stores a query delete all offers that match the car id
		PreparedStatement ps = conn.prepareStatement(sql);		//prepares the statement
		ps.setInt(1, o.getCarId());		//sets the car id to the database
		ps.executeUpdate();				//executes the update
	}
}
