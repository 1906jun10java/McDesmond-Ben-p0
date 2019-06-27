package com.revature.services;

import java.util.HashMap;

import com.revature.beans.Employee;

public class ELogin {
	public static HashMap<String, Employee> employeeLogin = new HashMap<>();
	
	public static void addAdmin() {
		addNewEmployee("admin","admin");
	}
	
	// prompts the employee to login validating their input
	public static boolean loginAttempt(String userName, String password) {
		
		boolean test;
		test = employeeLogin.containsKey(userName);
		if (test == false) {
			System.out.println("Username is not in the database. Did you need to register?");
			return false;
		}

		Employee e = employeeLogin.get(userName);
		if (e.getPassword().equals(password)) {
			return true;
		}

		System.out.println("Invalid password try again");
		return false;
	}
	
	public static boolean addNewEmployee(String userName, String password) {

		if (userName != null) {
			if(password != null) {
				Employee c = new Employee(userName, password);
				employeeLogin.put(c.getUserName(), c);
				return true;
			}
		}
		
		System.out.println("Username and Password cannot be null!");
		return false;

	}
}
