package com.revature.beans;

import java.util.ArrayList;

public class Customer extends UserBean{


	private int CustomerId;



	public Customer(String userName, String password, String firstName, String lastName) {
		super(userName, password, firstName, lastName);
		
	}
	private double remainingBalance;
	private ArrayList<Car> ownedCars = new ArrayList<Car>();		//an array list for storing all the cars on the lot
	

	public int getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public double getRemainingBalance() {
		return remainingBalance;
	}

	public void setRemainingBalance(double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	
	public void ownACar(Car c) {
		ownedCars.add(c);
	}
	
	public ArrayList<Car> returnOwnedCars() {
		return ownedCars;
	}

	@Override
	public String toString() {
		return "Customer [CustomerId=" + CustomerId + ", getUserName()=" + getUserName() + ", getPassword()="
				+ getPassword() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + "]";
	}
	
	
}
