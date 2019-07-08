package com.revature.beans;

public class Customer extends UserBean{


	private int CustomerId;		//stores sql's id for the customer


	//constructor
	public Customer(String userName, String password, String firstName, String lastName) {
		super(userName, password, firstName, lastName);
		
	}

	//Getters and Setters
	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}


	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", getUserName()=" + getUserName() + ", getPassword()="
				+ getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + "]";
	}
	
	
}
