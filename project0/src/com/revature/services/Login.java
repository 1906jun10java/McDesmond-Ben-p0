package com.revature.services;

import com.revature.beans.*;
import java.util.HashMap;
import java.util.Scanner;

public class Login {

	public static HashMap<String, Customer> customerLogin = new HashMap<>(); // hashmap for storing Customers and their
																				// login credentials

	// prompts the user to login validating their input
	public static boolean loginAttempt(String userName, String password) {
		
		boolean test;
		test = customerLogin.containsKey(userName);
		if (test == false) {
			System.out.println("Username is not in the database. Did you need to register?");
			return false;
		}

		Customer c = customerLogin.get(userName);
		if (c.getPassword().equals(password)) {
			System.out.println("Login Successful");
			return true;
		}

		System.out.println("Invalid password try again");
		return false;
	}

	public static boolean addNewCustomer(String userName, String password) {

		if (userName != null) {
			if(password != null) {
				Customer c = new Customer(userName, password);
				customerLogin.put(c.getUserName(), c);
				return true;
			}
		}
		
		System.out.println("Username and Password cannot be null!");
		return false;

	}

}
