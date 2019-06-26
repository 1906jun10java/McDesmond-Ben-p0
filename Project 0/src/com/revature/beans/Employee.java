package com.revature.beans;

public class Employee extends UserBean {

	public Employee(String userName, String password) {
		super(userName, password);

	}

	@Override
	public String toString() {
		return "Employee [getUserName: " + getUserName() + ", getPassword: " + getPassword() + "]";
	}

}
