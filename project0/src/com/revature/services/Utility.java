package com.revature.services;

import java.util.Scanner;

public class Utility {
	
	ScannerSingleton ss = ScannerSingleton.getInstance();
	Scanner sc = ss.returnScanner();
	
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
	
	public int parsedInt() {
		boolean test = false;
		int result = -1;
		while(test == false) {
			String userInput = sc.nextLine();
			test = Utility.tryParseInt(userInput);
			if(test == true) {
				result = Integer.parseInt(userInput);
			}
		}
		return result;
	}
}
