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

	//reference to the connection factory
	public static ConnFactory cf = ConnFactory.getInstance();
	
	//adds a new employee to the sql database
	@Override
	public void createNewEmployeeSQL(Employee e) throws SQLException {
		Connection conn = cf.getConnection();	//establishes connection to sql
		String sql = "INSERT INTO CAR VALUES(SQ_CAR_Employee_PK.NEXTVAL,?,?,?,?,?,?)";		//the  sql query
		PreparedStatement ps = conn.prepareStatement(sql);		//stores the query in the prepared statement
		ps.setString(1,e.getUserName());		//adds a user name to table column 2
		ps.setString(2, e.getPassword());		//adds a user name to table column 3
		ps.setString(3, e.getFirstName());		//adds a first name to table column 4
		ps.setString(4, e.getLastName());		//adds a last name to table column 5
		ps.executeUpdate();						//executes query

	}

	//returns an employee to the data structure
	@Override
	public void returnEmployeesSQL() throws SQLException {
		Connection conn = cf.getConnection();		//establishes a connection to the sql database
		Statement stmt = conn.createStatement();	//primes the statement variable
		ResultSet rs  = stmt.executeQuery("SELECT * FROM CAR_Employee");	//stores the query and catches the returned result set
		Employee e = null;				//new employee object
		while(rs.next()) {	//while there is still a next result
			//new employee object constructed
			e = new Employee(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			e.setEmployeeId(rs.getInt(1));	//id is inserted into new employee object seperate
			ELogin.populateEmployeeLogin(e);		//adds the object into the data structure
		}
	}
}
