package com.revature.services;

import java.util.HashMap;

import com.revature.beans.Employee;

public class ELogin {
	public static HashMap<String, Employee> employeeLogin = new HashMap<>();		//a hashmap containing an employee object keyed with a username
	
	//adds a default employee 
	public static void addAdmin() {
		addNewEmployee("admin","admin");
	}
	
	// prompts the employee to login validating their input
	public static boolean loginAttempt(String userName, String password) {
		
		//tests an employees login credentials against all other username keys in the hashmap
		boolean test;		//holds the result of the contains key method
		test = employeeLogin.containsKey(userName);		//tests if the employeeLogin hashmap contains a key that matches the passed username
		if (test == false) {//if the employee username key is not found in the hashmap
			System.out.println("Username is not in the database. Did you need to register?");		
			return false;	//username key was not found in the login key
		}
		
		//if the username was found uses it as a key to access the employee object in the hashmap
		Employee e = employeeLogin.get(userName);
		if (e.getPassword().equals(password)) {	//pulls the password from the employee object and compares it to the input password
			return true;	//passwords match
		}

		System.out.println("Invalid password try again");
		return false;	//passwords did not match
	}

	//adds a new employee to the employeeLogin hashmap
	public static boolean addNewEmployee(String userName, String password) {

		if (userName != null) {	//makes sure username is not null
			if(password != null) {	//makes sure password is not null
				Employee c = new Employee(userName, password);		//adds the username and password to a new employee object
				employeeLogin.put(c.getUserName(), c);				//puts the new employee object and username key into the hashmap
				return true;										//success
			}
		}
		
		System.out.println("Username and Password cannot be null!");
		return false;	//username or password were null

	}
}
