package com.revature.data;

import java.sql.SQLException;
import com.revature.beans.Employee;

public interface EmployeeDAO {
	
	//creates a new employee entry sql side
	public void createNewEmployeeSQL(Employee c)
	throws SQLException;
	
	//populates a data structure of employees java side
	public void returnEmployeesSQL()
	throws SQLException;  
}
