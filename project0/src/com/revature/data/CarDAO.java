package com.revature.data;

import java.sql.SQLException;

import com.revature.beans.Car;

public interface CarDAO {
	public void addNewCarSQL(Car c)
	throws SQLException;
	
	public void populateCarLotSQL()
	throws SQLException;  
	
}
