package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.OfferBean;


public interface OffersDAO {
	public void createNewOffer(OfferBean o)
	throws SQLException;
	
	public void returnOffers()
	throws SQLException;
	
	public void deleteOffers(Double offer)
	throws SQLException;

}
