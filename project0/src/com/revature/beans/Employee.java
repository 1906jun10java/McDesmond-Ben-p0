package com.revature.beans;

public class Employee extends UserBean {

	public Employee(String userName, String password, String firstName, String lastName) {
		super(userName, password, firstName, lastName);

	}

	@Override
	public String toString() {
		return "Employee [getUserName()=" + getUserName() + ", getPassword()=" + getPassword() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
