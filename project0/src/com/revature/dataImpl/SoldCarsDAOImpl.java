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
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void addNewCarSQL(Car c) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CAR_SOLD VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, c.getCarId());
		ps.setString(2,c.getColor());
		ps.setString(3, c.getMake());
		ps.setString(4, c.getModel());
		ps.setInt(5, c.getYear());
		ps.setInt(6, c.getMileage());
		ps.executeUpdate();
		
	}

	@Override
	public void populateSoldCarsSQL() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs  = stmt.executeQuery("SELECT * FROM CAR_SOLD");
		Car c = null;
		while(rs.next()) {
			c = new Car(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
			c.setCarId(rs.getInt(1));
			SoldCars.addCarObject(c);
		}
		
	}

}
