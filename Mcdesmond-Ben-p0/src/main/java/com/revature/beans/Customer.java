package com.revature.beans;

public class Customer extends UserBean{




	public Customer(String userName, String password) {
		super(userName, password);
		
	}

	@Override
	public String toString() {
		return "Customer [UserName: " + getUserName() + ", Password: " + getPassword() + "]";
	}

}
