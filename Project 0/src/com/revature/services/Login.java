package com.revature.services;

import com.revature.beans.*;
import java.util.HashMap;
import java.util.Scanner;

public class Login {

	private String userName;		//used in loginPrompts to store the validated username
	private String password;		//used in loginPrompts to store the validated password

	public static HashMap<String,Customer> customerLogin = new HashMap<>();		//hashmap for storing Customers and their login credentials
	
	//prompts the user to login validating their input 
	public void loginPrompts() {
			
		String userName;		//holds an unchecked username
		String password;		//holds an unchecked password
		
		boolean uTest = false;		//test for if username matches something
		boolean pTest = false;		//test for if password matches something
		
		Scanner sc = new Scanner(System.in);

		//relies on the checker to say if the username is invalid
		System.out.println("Please login to continue");
		System.out.println("Enter UserName:");
		while (uTest != true) {
			userName = sc.next();
			uTest = Login.userNameChecker(userName);
			if (uTest == true) {
				this.userName = userName;
			}
		}
		//relies on the checker to say if password is invalid
		System.out.println("Enter Password: ");
		while(pTest = false) {
			password = sc.next();
			pTest = Login.passwordChecker(password);
			if(pTest == true) {
				this.password = password;
			}
		}
		
		sc.close();
	}
	
	
	//eventually checks username against data in the hashmap
	public static boolean userNameChecker(String userName) {
		boolean test ;
		test = customerLogin.containsKey(userName);
		if(test == false) {
			System.out.println("Username is not in the database. Did you need to register?");
		}
		return test;
	}

	//eventually checks password against data in the hashmap
	public static boolean passwordChecker(String password) {
		return true;
	}

}
