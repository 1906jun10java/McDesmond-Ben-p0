package com.revature.dataImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Car;
import com.revature.data.ConnFactory;
import com.revature.data.SoldCarsDAO;
import com.revature.services.SoldCars;

public class SoldCarsDAOImpl implements SoldCarsDAO {
	
	//reference to the connection factory
	public static ConnFactory cf = ConnFactory.getInstance();

	//adds a new sold car to the database
	@Override
	public void addNewCarSQL(Car c) throws SQLException {
		Connection conn = cf.getConnection();		//establishes a connection to the database
		String sql = "INSERT INTO CAR_SOLD VALUES(?,?,?,?,?,?)";		//inserts into car sold table
		PreparedStatement ps = conn.prepareStatement(sql);				//prepared statement primer
		ps.setInt(1, c.getCarId());			//stores carID into slot 2
		ps.setString(2,c.getColor());		//stores color into slot 3
		ps.setString(3, c.getMake());		//stores make into slot 4
		ps.setString(4, c.getModel());		//stores model into slot 5
		ps.setInt(5, c.getYear());			//stores year into slot 6
		ps.setInt(6, c.getMileage());		//stores mileage into slot 7
		ps.executeUpdate();					//Executes the update
		
	}

	//populates sold cars data structure
	@Override
	public void populateSoldCarsSQL() throws SQLException {
		Connection conn = cf.getConnection();		//establishes a connection to the database
		Statement stmt = conn.createStatement();	//statement primer
		ResultSet rs  = stmt.executeQuery("SELECT * FROM CAR_SOLD");	//selects all from cars sold
		Car c = null;		//creates a new car object
		while(rs.next()) {		//while there is another result set
			//constructs a new car object
			c = new Car(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
			c.setCarId(rs.getInt(1));		//stores the carId separate from the constructor
			SoldCars.addCarObject(c);		//adds car to the data structure
		}
		
	}

}
