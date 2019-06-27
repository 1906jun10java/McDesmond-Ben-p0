package com.revature.services;
import java.util.Scanner;

import com.revature.beans.Car;

public class EmployeeSwitch {

	
	public static void employeeMenu() {
		
		ScannerSingleton ss = ScannerSingleton.getInstance();
		Scanner sc = ss.returnScanner();
		Utility ul = new Utility();

		boolean exitMain = false;

		while (exitMain != true) {
			
			int switchCase;

			System.out.println("Welcome Employee! How can we help you today?");
			System.out.println("1) Add a Car to Lot");
			System.out.println("2) View Customer Offers");
			System.out.println("3) Remove Car from Lot");
			System.out.println("4) View All Payments");
			switchCase = ul.parsedInt();

			switch (switchCase) {

			case 1:
				String color;
				String make;
				String model;

				int year;
				int mileage;
				
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
				
				Car c = new Car(color,make,model,year,mileage);
				CarLot.carLot.add(c);
				
				System.out.println("Car successfully added");
				break;

			case 2:

				System.out.println("Current number of offers on a car");
				CarLot.viewOffers();



				break;

			case 3:
				System.out.println("Select a car's id number from the lot");
				CarLot.printTheLot();
				int cId = ul.parsedInt();
				Car car = CarLot.returnCar(cId);
				CarLot.removeCar(car);
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