package com.revature.beans;


public class Customer extends UserBean{




	public Customer(String userName, String password, String firstName, String lastName) {
		super(userName, password, firstName, lastName);
		
	}
	private double remainingBalance;
	
	@Override
	public String toString() {
		return "Customer [getUserName()=" + getUserName() + ", getPassword()=" + getPassword() + ", getFirstName()="
				+ getFirstName() + ", getLastName()=" + getLastName() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
