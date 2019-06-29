package com.revature.services;
import java.util.Scanner;

import com.revature.beans.Car;

public class EmployeeSwitch {

	
	public static void employeeMenu() {
		
		//creates an instance of the static scanner in the menu
		ScannerSingleton ss = ScannerSingleton.getInstance();
		Scanner sc = ss.returnScanner();
		
		//creates an instance of the utility class for the non static methods in there
		Utility ul = new Utility();

		//exit boolean for the main menu
		boolean exitMain = false;

		//exit condition for the main menu
		while (exitMain != true) {
			
			
			int switchCase;		//the switch int for the main menu

			//main menu prompts
			System.out.println("Welcome Employee! How can we help you today?");
			System.out.println("1) Add a Car to Lot");
			System.out.println("2) View Customer Offers");
			System.out.println("3) Remove Car from Lot");
			System.out.println("4) View All Payments");
			switchCase = ul.parsedInt();		//requests user input in the form of an int and checks it

			//switch block for the main menu
			switch (switchCase) {

			case 1://Add a car to the lot
				
				String color;	//elements for the car constructor
				String make;	//elements for the car constructor
				String model;	//elements for the car constructor

				int year;		//elements for the car constructor
				int mileage;	//elements for the car constructor
				
				//takes user input and stores them in the instance fields above
				System.out.println("Please enter color of the Car: ");
				color = sc.nextLine();
				System.out.println("Please enter make of the Car: ");
				make = sc.nextLine();
				System.out.println("Please enter model of the Car: ");
				model = sc.nextLine();
				System.out.println("Please enter year the Car was manufactured: ");
				year = ul.parsedInt();
				System.out.println("Please enter current mileage of the Car: ");
				mileage = ul.parsedInt();
				
				//constructs a new car and stores it in the CarLot
				Car c = new Car(color,make,model,year,mileage);
				CarLot.carLot.add(c);
				
				//car was added 
				System.out.println("Car successfully added");
				break;

			case 2://prints offers and allows employee to accept or reject an offer
				
				System.out.println("Current number of offers on a car");
				CarLot.viewOffers();	//prints all offers on every car in the lot


				break;

			case 3://remove car from the lot 
				System.out.println("Select a car's id number from the lot");
				CarLot.printTheLot();				//prints the car lot 
				int cId = ul.parsedInt();			//asks the user for an int and parses it
				Car car = CarLot.returnCar(--cId);	//takes the parsed id and returns a car object
				CarLot.removeCar(car);				//takes the returned car 
				System.out.println("Car successfully removed");
				break;

			case 4:

				//CarLot.viewPayments();
				break;

			default:
				exitMain = true;
				break;

			}
		}
	}
}