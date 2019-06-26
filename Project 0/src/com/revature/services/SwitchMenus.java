package com.revature.services;

import java.util.Scanner;

public class SwitchMenus {

	// holds the main menu prompts and switches based on user input
	public void mainMenu() {

		ScannerSingleton ss = ScannerSingleton.getInstance();
		Scanner sc = ss.returnScanner();
		
		ELogin.addAdmin();
		
		boolean exitMain = false; // ends main when true
		 //

		int switchCase = 0;

		while (exitMain != true) {
			
			boolean testInt = false;
			
			System.out.println("Welcome to the car lot! How can we help you today?");
			System.out.println("1) View cars on the lot");
			System.out.println("2) Register for a customer account");
			System.out.println("3) Login as a customer");
			System.out.println("4) Employee Login");
			System.out.println("0) Exit the car lot");
			System.out.println("Please select an option: ");
			while (testInt == false) {
				String userInput = sc.nextLine();
				testInt = Utility.tryParseInt(userInput);
				if (testInt == true) {
					switchCase = Integer.parseInt(userInput);
				}
			}

			switch (switchCase) {

			case 1:
				CarLot.printTheLot();
				break;

			case 2:
					String nUserName;
					String nPassword;
					
					boolean cChecker;
					
					System.out.println("We're glad to have you as a customer");
					
					System.out.println("Please enter your desired User Name: ");
					nUserName = sc.nextLine();
					
					System.out.println("Now please enter a password: ");
					nPassword = sc.nextLine();
					
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
