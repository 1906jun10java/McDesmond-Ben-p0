package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.Car;

public interface CarDAO {
	
	//method for adding a new car to the sql database
	public void addNewCarSQL(Car c) throws SQLException;

	//method for populating a data structure with cars
	public void populateCarLotSQL() throws SQLException;

	//method for removing a car from the sql database
	public void removeCarFromLotSQL(Car c) throws SQLException;

}
