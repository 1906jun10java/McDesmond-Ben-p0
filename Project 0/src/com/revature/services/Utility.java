package com.revature.services;

public class Utility {
	
	//clears the console
	public static void cls() {
		System.out.flush();
	}
	
	//trys to parse a string into an int returns false if exception occurs
	public static boolean tryParseInt(String userInput) {

		try {
			Integer.parseInt(userInput);
		}
		catch(Exception e){
			System.out.println("Input is not a number try again");
			return false;
		}
		return true;
	}
}
