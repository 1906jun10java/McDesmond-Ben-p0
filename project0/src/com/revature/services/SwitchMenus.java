package com.revature.services;

import java.util.Scanner;

public class SwitchMenus {

	// holds the main menu prompts and switches based on user input
	public static void mainMenu() {

		//returns a reference to the static ScannerSingleton class
		ScannerSingleton ss = ScannerSingleton.getInstance();
		
		//returns a reference to the static scanner in ScannerSingleton
		Scanner sc = ss.returnScanner();
		
		//Adds a default admin user to the employee hashmap
		ELogin.addAdmin();
		
		Utility ul = new Utility();
		
		//exits the main menu when turns true
		boolean exitMain = false; 

		//the switch case variable
		int switchCase = 0;

		//while boolean exitMain is not true
		while (exitMain != true) {
			
			//used to test user input for a string parse
			boolean testInt = false;
			
			//Prints out the main menu
			System.out.println("Welcome to the car lot! How can we help you today?");
			System.out.println("1) View cars on the lot");
			System.out.println("2) Register for a customer account");
			System.out.println("3) Login as a customer");
			System.out.println("4) Employee Login");
			System.out.println("0) Exit the car lot");
			System.out.println("Please select an option: ");
			
			//while the user input is not a number
			switchCase = ul.parsedInt();
			
			//declares a switch on the user input parsed above
			switch (switchCase) {					

			case 1://user wants to see selection of cars on the lot
				//refers to a method in the CarLot class in com.revature.services
				CarLot.printTheLot();
				break;

			case 2://customer wishes to make an account with the company 
					String nUserName;	//stores a username
					String nPassword;	//stores a password
					
					boolean cChecker;	//checks the result of the login
					
					//sets the username to the value of the next line of user input
					System.out.println("We're glad to have you as a customer");
					System.out.println("Please enter your desired User Name: ");
					nUserName = sc.nextLine();
					
					//sets the user input to the field password
					System.out.println("Now please enter a password: ");
					nPassword = sc.nextLine();
					
					//credential checker to verify customer account creation was successful
					cChecker = Login.addNewCustomer(nUserName, nPassword);
					if(cChecker == true) {
						System.out.println("Customer Successfully added to the database");
					}
					else {
						System.out.println("An error occured, try again!");
					}
					
				break;

			case 3:

				String userName;
				String password;
				
				boolean attempt;

				System.out.println("Please enter UserName: ");
				userName = sc.nextLine();
				
				System.out.println("Please enter Password");
				password = sc.nextLine();
				
				attempt = Login.loginAttempt(userName, password);
				
				if(attempt == true) {
					System.out.println("Success");
				}
				else {
					System.out.println("Invalid login try again");
				}
				break;
				
			case 4:
					String eUserName;
					String ePassword;
					
					boolean eAttempt;
					
					System.out.println("Please enter UserName: ");
					eUserName = sc.nextLine();
					
					System.out.println("Please enter Password");
					ePassword = sc.nextLine();
					
					eAttempt = ELogin.loginAttempt(eUserName, ePassword);
					
					if(eAttempt == true) {
						System.out.println("Login Successful");
						EmployeeSwitch.employeeMenu();
					}
					else {
						System.out.println("Error, invalid username or password");
					}
					
					break;

			default:
				exitMain = true;
				break;

			}
		}
	}

}