package com.revature.services;

import com.revature.beans.*;
import java.util.HashMap;
import java.util.Scanner;

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

	public static boolean addNewCustomer(String userName, String password) {	//takes a username and password and uses it to create a new customer

		if (userName != null) {		//if username is not null
			if(password != null) {	//if password is not null
				Customer c = new Customer(userName, password);	//constructs a new customer with the given username and password
				customerLogin.put(c.getUserName(), c);			//puts the new customer in the customerLogin hashmap  using the username as a key
				return true;									//successful operation
			}
		}
		
		System.out.println("Username and Password cannot be null!");	//a passed field was null
		return false;			//returns false

	}

}
