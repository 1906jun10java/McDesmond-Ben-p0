package com.revature.dataImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.beans.Employee;
import com.revature.data.ConnFactory;
import com.revature.data.EmployeeDAO;
import com.revature.services.ELogin;

public class EmployeeDAOImpl implements EmployeeDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createNewEmployeeSQL(Employee e) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO CAR VALUES(SQ_CAR_Employee_PK.NEXTVAL,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1,e.getUserName());
		ps.setString(2, e.getPassword());
		ps.setString(3, e.getFirstName());
		ps.setString(4, e.getLastName());
		ps.executeUpdate();

	}

	@Override
	public void returnEmployeesSQL() throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs  = stmt.executeQuery("SELECT * FROM CAR_Employee");
		Employee e = null;
		while(rs.next()) {
			e = new Employee(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			e.setEmployeeId(rs.getInt(1));
			ELogin.populateEmployeeLogin(e);
		}
	}
}
