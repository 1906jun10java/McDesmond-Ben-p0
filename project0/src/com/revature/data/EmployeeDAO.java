package com.revature.data;

import java.sql.SQLException;
import com.revature.beans.Employee;

public interface EmployeeDAO {
	public void createNewEmployeeSQL(Employee c)
	throws SQLException;
	
	public void returnEmployeesSQL()
	throws SQLException;  
}
