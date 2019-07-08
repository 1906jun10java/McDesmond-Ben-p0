package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.Car;

public interface SoldCarsDAO {
	
	//adds a sold car to the sql database
	public void addNewCarSQL(Car c)
	throws SQLException;
	
	//returns all sold cars to the java data structure
	public void populateSoldCarsSQL()
	throws SQLException;  

}
