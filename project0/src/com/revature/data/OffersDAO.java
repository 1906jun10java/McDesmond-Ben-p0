package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.OfferBean;


public interface OffersDAO {
	
	//creates a new offer on the sql database
	public void createNewOffer(OfferBean o)
	throws SQLException;
	
	//returns all offers on the sql database
	public void returnOffers()
	throws SQLException;
	
	//removes all offers on a sold car 
	public void deleteOffers(OfferBean o)
	throws SQLException;

}
