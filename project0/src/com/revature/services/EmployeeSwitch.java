package com.revature.services;
import java.util.Scanner;

public class EmployeeSwitch {

	public static void employeeMenu() {

		ScannerSingleton ss = ScannerSingleton.getInstance();
		Scanner sc = ss.returnScanner();

		Utility ul = new Utility();

		boolean exitMain;

		while (exitMain != true) {

			boolean testInt = false;

			System.out.println("Welcome Employee! How can we help you today?");
			System.out.println("1) Add a Car to Lot");
			System.out.println("2) Accept or Reject Customer Offer");
			System.out.println("3) Remove Car from Lot");
			System.out.println("4) View All Payments");
			int switchCase = ul.parsedInt();

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
				color = sc.nextLine();
				System.out.println("Please enter model of the Car: ");
				color = sc.nextLine();
				System.out.println("Please enter year the Car was manufactured: ");
				// year = sc.nextLine();
				System.out.println("Please enter current mileage of the Car: ");
				// mileage = sc.nextLine();
				break;

			case 2:
				String nUserName;
				String nPassword;

				boolean cChecker;

				System.out.println("Would you like to accpet or reject offer? ");

				cChecker = Login.addNewCustomer(nUserName, nPassword);
				if (cChecker == true) {
					System.out.println("Offer Accepted!");
				} else {
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
	}
}