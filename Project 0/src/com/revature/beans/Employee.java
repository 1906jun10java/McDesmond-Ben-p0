package com.revature.beans;

public class Employee extends UserBean {

	@Override
	public String toString() {
		return "Employee [getUserName: " + getUserName() + ", getPassword: " + getPassword() + "]";
	}

}
