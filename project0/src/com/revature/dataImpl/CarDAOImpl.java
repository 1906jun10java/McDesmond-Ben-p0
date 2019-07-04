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

	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public void addNewCarSQL(Car c) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CAR VALUES(SQ_CAR_PK.NEXTVAL,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,c.getColor());
		ps.setString(2, c.getMake());
		ps.setString(3, c.getModel());
		ps.setInt(4, c.getYear());
		ps.setInt(5, c.getMileage());
		ps.setString(6, "false");
		ps.executeUpdate();
	}

	@Override
	public void populateCarLotSQL() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs  = stmt.executeQuery("SELECT * FROM CAR");
		Car c = null;
		while(rs.next()) {
			c = new Car(rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
			c.setCarId(rs.getInt(1));
			CarLot.addCarObject(c);
		}
	}
}
