package com.revature.beans;

public class Employee extends UserBean {

	private int EmployeeId;			//holds the sql value employee id
	
	
	public Employee(String userName, String password, String firstName, String lastName) {
		super(userName, password, firstName, lastName);

	}

	//Getters and Setters
	public int getEmployeeId() {
		return EmployeeId;
	}


	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", getUserName()=" + getUserName() + ", getPassword()="
				+ getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + "]";
	}



}
