package com.revature.services;

import java.util.Scanner;

public class Utility {
	
	//creates an instance of the Scanner for use in this class
	ScannerSingleton ss = ScannerSingleton.getInstance();
	Scanner sc = ss.returnScanner();
	
	//trys to parse a string into an int returns false if exception occurs
	public static boolean tryParseInt(String userInput) {

		try {
			Integer.parseInt(userInput);		//Attempts to use the wrapper class to parse an int into a string
			
		}
		catch(Exception e){		//when the user input throws an exception
			System.out.println("Input is not a number try again");		
			return false;	//parse failed
		}
		return true;		//parse succeeded
	}
	
	public int parsedInt() {		//passes user input into the tryParseInt method loops until the user adds an int
		boolean test = false;		//test variable
		int result = -1;			//initialized with a non 0 number
		while(test == false) {		//while the tryParseInt returns false(or on first run)
			String userInput = sc.nextLine();		//takes the next line from the user
			test = Utility.tryParseInt(userInput);	//runs my tryParseInt method
			if(test == true) {						//if the parse test passes
				result = Integer.parseInt(userInput);	//sets the parsed userInput into the value of the result
			}
		}
		return result;		//returns the result of the tryParseInt function
	}
	
	//checks the user input for null and empty and returns true if none exist
	public static boolean checkName(String name) {
		
		if(!name.isEmpty()) {					//if name is not empty
			if(!name.contains(" ")) {			//if name contains no whitespace
				return true;					//good name
			}
		}
		System.out.println("Error: names must be free of white space!");
		return false;							//bad name
	}
	
	//loops until a user inputs a valid name string then returns the name
	public String returnCheckedName() {
		boolean test = false;						//initialize the test
		String result = null;						//initialize the result 
		while(test == false) {						//while the test is false
			String userInput = sc.nextLine();		//take user input from the next line and store it
			test = Utility.checkName(userInput);	//run the check name method
			if(test == true) {						//if check name returns true
				result = userInput;					//set the result to the checked name
			}	
		}
		return result;								//returns a valid name 
	}

	//trys to parse a string into an double returns false if exception occurs
	public static boolean tryParseDouble(String userInput) {

			try {
				Double.parseDouble(userInput);		//Attempts to use the wrapper class to parse a double into a string
				
			}
			catch(Exception e){		//when the user input throws an exception
				System.out.println("Input is not a number try again");		
				return false;	//parse failed
			}
			return true;		//parse succeeded
		}
		
		//passes user input into the tryParseDouble method loops until the user adds a double
	public double parsedDouble() {		
			boolean test = false;		//test variable
			double result = -1;			//initialized with a non 0 number
			while(test == false) {		//while the tryParseInt returns false(or on first run)
				String userInput = sc.nextLine();		//takes the next line from the user
				test = Utility.tryParseDouble(userInput);	//runs my tryParseDouble method
				if(test == true) {						//if the parse test passes
					result = Double.parseDouble(userInput);	//sets the parsed userInput into the value of the result
				}
			}
			return result;		//returns the result of the tryParseDouble function
		}
}
