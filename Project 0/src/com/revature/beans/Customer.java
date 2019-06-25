package com.revature.beans;

public class Customer extends UserBean{
	

	

	@Override
	public String toString() {
		return "Customer [UserName: " + getUserName() + ", Password: " + getPassword() + "]";
	}

}
