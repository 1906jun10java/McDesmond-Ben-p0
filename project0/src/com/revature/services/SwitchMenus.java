package com.revature.services;

import com.revature.beans.Customer;

public class SwitchMenus {

	// holds the main menu prompts and switches based on user input
	public static void mainMenu() {
		
		//adds a utility object to give access to non static classes
		Utility ul = new Utility();
		
		//exits the main menu when it turns true
		boolean exitMain = false; 

		//the switch case variable
		int switchCase = 0;

		//while boolean exitMain is not true
		while (exitMain != true) {
			
			//Prints out the main menu
			System.out.println("Welcome to the car lot! How can we help you today?");
			System.out.println("1) View cars on the lot");
			System.out.println("2) Register for a customer account");
			System.out.println("3) Login as a customer");
			System.out.println("4) Employee Login");
			System.out.println("0) Exit the car lot");
			System.out.println("Please select an option: ");
			
			//returns a number from the user to switch on
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
					String nFirstName;	//stores a first name
					String nLastName;	//stores a last name
					
					boolean cChecker;	//checks the result of the login
					
					//sets the username to the value of the next line of user input
					System.out.println("We're glad to have you as a customer");
					System.out.println("Please enter your desired User Name: ");
					nUserName = ul.returnCheckedName();
					
					//sets the user input to the field password
					System.out.println("Now please enter a password: ");
					nPassword = ul.returnCheckedName();
					
					System.out.println("Please enter your first name");
					nFirstName = ul.returnCheckedName();
					
					System.out.println("Finally please enter your last name");
					nLastName = ul.returnCheckedName();
					
					//credential checker to verify customer account creation was successful
					cChecker = Login.addNewCustomer(nUserName, nPassword, nFirstName, nLastName);
					if(cChecker == true) {
						System.out.println("Customer Successfully added to the database");
					}
					else {
						System.out.println("An error occured, try again!");
					}
					
				break;

			case 3://login as a returning customer
				
				String userName;		//stores a username
				String password;		//stores a password
				
				boolean attempt;		//stores the test attempt
				
				//takes the next line from the console and stores it in the username field
				System.out.println("Please enter UserName: ");
				userName = ul.returnCheckedName();
				
				//stores the next line from the console and stores it in the password field
				System.out.println("Please enter Password");
				password = ul.returnCheckedName();
				
				//Attempts to login using the login method passing in a username and password
				attempt = Login.loginAttempt(userName, password);
				
				if(attempt == true) {//attempt was returned as true
					System.out.println("Success");
					Customer customer = Login.returnCustomer(userName);
					CustomerSwitch.customerMenu(customer);
				}
				else {//attempt was returned as false
					System.out.println("Invalid login try again");
				}
				break;
				
			case 4://allows an employee to log in
					String eUserName;	//stores an employee username
					String ePassword;	//stores an employee password
					
					boolean eAttempt;	//stores the attempt to log in
					
					//stores the next line from the console in the username field
					System.out.println("Please enter UserName: ");
					eUserName = ul.returnCheckedName();
					
					//stores the next line in the password field
					System.out.println("Please enter Password");
					ePassword = ul.returnCheckedName();
					
					//attempts to login using the loginAttempt method which returns a boolean true/false
					eAttempt = ELogin.loginAttempt(eUserName, ePassword);
					
					if(eAttempt == true) {//if login was successful
						System.out.println("Login Successful");
						EmployeeSwitch.employeeMenu();
					}
					else {//if login failed
						System.out.println("Error, invalid username or password");
					}
					
					break;
					
			case 0:
				exitMain = true;
				break;

			default:
				System.out.println("Invalid Selection, please try again.");
				break;

			}
		}
	}

}
