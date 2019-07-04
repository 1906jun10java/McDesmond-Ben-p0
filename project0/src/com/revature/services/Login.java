package com.revature.services;

import com.revature.beans.*;
import com.revature.dataImpl.SQLUtility;

import java.util.HashMap;

public class Login {

	public static HashMap<String, Customer> customerLogin = new HashMap<>(); // hashmap for storing Customers and their login credentials
																			

	// prompts the user to login validating their input
	public static boolean loginAttempt(String userName, String password) {
		
		boolean test;	//stores the result of the login test
		test = customerLogin.containsKey(userName);		//if the customerLogin hashmap contains the username as a key
		if (test == false) {//if hashmap did not contain the username
			System.out.println("Username is not in the database. Did you need to register?");
			return false; //hashmap did not contain the username 
		}

		Customer c = customerLogin.get(userName);	//uses the username as a key to retrieve the customer credentials
		if (c.getPassword().equals(password)) {		//compares the passed password to the password in the customers password field
			System.out.println("Login Successful");		//passwords matched
			return true;								//passwords matched
		}

		System.out.println("Invalid password try again");	//passwords did not match
		return false;										//passwords did not match
	}

	public static boolean addNewCustomer(String userName, String password, String firstName, String lastName) {	//takes a username and password and uses it to create a new customer

		if (userName != null) {		//if username is not null
			if(password != null) {	//if password is not null
				Customer c = new Customer(userName, password,firstName,lastName);	//constructs a new customer with the given username and password
				customerLogin.put(c.getUserName(), c);			//puts the new customer in the customerLogin hashmap  using the username as a key
				SQLUtility.tryCreateNewCustomer(c); 			//adds the customer to the database for future retrieval
				return true;									//successful operation
			}
		}
		
		System.out.println("All required fields must be populated");	//a passed field was null
		return false;			//returns false

	}

	public static Customer returnCustomer(String userName) {
		return customerLogin.get(userName);
	}
	
	
	//Takes a customer from sql and adds them to the hashmap
	public static void populateCustomerLogin(Customer c) {
		String uName = c.getUserName();
		customerLogin.put(uName, c);
		return;
	}
}
