package com.revature.services;

import java.util.Scanner;

public class SwitchMenus {
	
	
	//holds the main menu prompts and switches based on user input
	public void mainMenu() {
		Scanner sc = new Scanner(System.in);
		
		boolean exitMain = false;			//ends main when true
		boolean testInt = false;			//
		
		int switchCase = 0;
		
		while(exitMain != true) {
			
			//Utility.cls();
			System.out.println("Welcome to the car lot! How can we help you today?");
			System.out.println("1) View cars on the lot");
			System.out.println("2) Register for a customer account");
			System.out.println("3) Login as a customer");
			System.out.println("4) Employee Login");
			System.out.println("0) Exit the car lot");
			System.out.println("Please select an option: ");
			//while(testInt != true) {
				//String userInput = sc.next();
				//testInt = Utility.tryParseInt(userInput);
				//if(testInt == true) {
					switchCase = Integer.parseInt(sc.next());
				//}
			//}
			
			switch(switchCase) {
			
			case 1 :
				CarLot.printTheLot();
				break;
			
			case 2:
				break;
				
				
			case 3:
				break;
				
			default: exitMain = true;
					break;
				
				
			}
		}
		sc.close();
	}

}
