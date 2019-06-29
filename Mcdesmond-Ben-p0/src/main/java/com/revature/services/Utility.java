package com.revature.services;

import java.util.Scanner;

import com.sun.tools.sjavac.Log;

public class Utility {
	
	//creates an instance of the Scanner for use in this class
	ScannerSingleton ss = ScannerSingleton.getInstance();
	Scanner sc = ss.returnScanner();
	
	//try to parse a string into an integer returns false if exception occurs
	public static boolean tryParseInt(String userInput) {

		try {
			Integer.parseInt(userInput);		//attempts to use the wrapper class to parse an int into a string
			
		}
		catch(Exception e){		//when the user input throws an exception
			System.out.println("Input is not a number try again");
			Log.error("Invalid non number user input");
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
}
