package com.revature.services;

public class EmployeeSwitch {
	while (exitMain != true) {
		
		boolean testInt = false;
		
		System.out.println("Welcome Employee! How can we help you today?");
		System.out.println("1) Add a Car to Lot");
		System.out.println("2) Accept or Reject Customer Offer");
		System.out.println("3) Remove Car from Lot");
		System.out.println("4) View All Payments");
		while (testInt == false) {
			String userInput = sc.nextLine();
			testInt = Utility.tryParseInt(userInput);
			if (testInt == true) {
				switchCase = Integer.parseInt(userInput);
			}
		}

		switch (switchCase) {

		case 1:
			String color;
			String make;
			String model;	
			int year;	
			long mileage;
			System.out.println("Please enter color of the Car: ");
			color = sc.nextLine();	
			System.out.println("Please enter make of the Car: ");
			color = sc.nextLine();	
			System.out.println("Please enter model of the Car: ");
			color = sc.nextLine();	
			System.out.println("Please enter year the Car was manufactured: ");
			int = sc.nextLine();	
			System.out.println("Please enter current mileage of the Car: ");
			long = sc.nextLine();	
			break;

		case 2:
				String nUserName;
				String nPassword;
				
				boolean cChecker;
				
				
				System.out.println("Would you like to accpet or reject offer? ");

				
				cChecker = Login.addNewCustomer(nUserName, nPassword);
				if(cChecker == true) {
					System.out.println("Offer Accepted!");
				}
				else {
					System.out.println("Offer Rejected.");
				}
				
			break;

		case 3:

			CarLot.removeCar();
			break;

			
		case 4:

			CarLot.viewPayments();
			break;


		default:
			exitMain = true;
			break;

		}
}
