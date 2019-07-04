package com.revature.data;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Car;
import com.revature.beans.Customer;


public interface OffersDAO {
	public void createNewOffer(double offer,Customer customer,Car car)
	throws SQLException;
	
	public List<Double> returnOffers()
	throws SQLException;
	
	public void deleteOffers(Double offer)
	throws SQLException;

}
