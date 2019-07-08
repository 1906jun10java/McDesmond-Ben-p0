package com.revature.dataImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Car;
import com.revature.data.CarDAO;
import com.revature.data.ConnFactory;
import com.revature.services.CarLot;

public class CarDAOImpl implements CarDAO {

	//reference to the connection factory
	public static ConnFactory cf = ConnFactory.getInstance();

	//adds a new car to the sql database
	@Override
	public void addNewCarSQL(Car c) throws SQLException {
		
		Connection conn = cf.getConnection();	//establishes sql connection
		String sql = "INSERT INTO CAR VALUES(SQ_CAR_PK.NEXTVAL,?,?,?,?,?)";		//SQL QUERY
		PreparedStatement ps = conn.prepareStatement(sql);		//Prepares the statement
		ps.setString(1,c.getColor());		//assigns car color to row 2
		ps.setString(2, c.getMake());		//assigns car make to row 3
		ps.setString(3, c.getModel());		//assigns car model to row 4
		ps.setInt(4, c.getYear());			//assigns car year to row 5
		ps.setInt(5, c.getMileage());		//assigns car mileage to row 6
		ps.executeUpdate();					//executes the prepared statement
	}

	//populates the car lot from sql database
	@Override
	public void populateCarLotSQL() throws SQLException {
		Connection conn = cf.getConnection();			//establishes the sql connection
		Statement stmt = conn.createStatement();		//prepares a statement variable
		ResultSet rs  = stmt.executeQuery("SELECT * FROM CAR");	//stores the result set returned from the query
		Car c = null;	//new car field
		while(rs.next()) {//while there is another result in the result set
			//constructs a new car 
			c = new Car(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
			c.setCarId(rs.getInt(1));		//sets an id separate from the constructor
			CarLot.addCarObject(c);			//adds car to the carlot one at a time
		}
	}

	//removes a car from the sql database
	@Override
	public void removeCarFromLotSQL(Car c) throws SQLException {
		Connection conn = cf.getConnection();		//establishes the connection to sql
		String sql = "DELETE FROM CAR WHERE CAR_ID = ? AND MILEAGE = ?";		//saves the sql query 
		PreparedStatement ps = conn.prepareStatement(sql);						//prepared statement stores and processes the query
		ps.setInt(1, c.getCarId());			//sets carId to first ?
		ps.setInt(2,c.getMileage());		//sets mileage to second ?
		ps.executeUpdate();					//executes the full query
		
	}
}
