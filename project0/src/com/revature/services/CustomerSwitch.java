package com.revature.services;

import com.revature.beans.Car;
import com.revature.beans.Customer;

public class CustomerSwitch {
	
	public static void customerMenu(Customer customer){
		
		//grants access to all non static methods in the Utility class
		Utility ul = new Utility();
		
		//exits this menu when it turns true
		boolean exitMenu = false;
		
		//the switch case variable
		int switchCase = 0;
		
		while(exitMenu != true) {
			
			//prints out customer menu
			System.out.println("Welcome valued customer "+customer.getFirstName()+" , How can we help you today?");
			System.out.println("1) View cars on the lot");
			System.out.println("2) Make an offer on a car");
			System.out.println("3) View your new car");
			System.out.println("4) Make a payment on your new car");
			System.out.println("0) Log out");
			System.out.println("Please select an option: ");
			
			//returns a number for the user to switch on
			switchCase = ul.parsedInt();
			
			switch(switchCase) {
			
			case 1://view cars on the lot
				CarLot.printTheLot();
				break;
				
			case 2://Make an offer on a car
				
				Offers.createNewOffer(customer);
					
				break;
				 
				 
			case 3://view your new car
				if(customer.returnOwnedCars().equals(null)) {
					System.out.println("Sorry, but there are no cars here currently. Hopefully your offer is still pending and will be approved soon.");
					break;
				}
				for(Car c: customer.returnOwnedCars()) {
					System.out.println(c);
				}
				break;
			case 4:
				
				int selector = 0;
				boolean smallLoop = false;
				double owed = customer.getRemainingBalance();
				
				System.out.println("Your current balance on your car is " + owed);
				System.out.println("Would you like to make a payment?");
				System.out.println("1) Yes");
				System.out.println("2) No ");
				selector = ul.parsedInt();
				while(smallLoop != true) {
					switch(selector) {
					case 1:
						
						double payment = 0;
						double remainingBalance = 0;
						
						System.out.println( "Your current monthly payment is "+ (owed/ 36));
						System.out.println("Please enter the dollar amount you wish to pay");
						payment = ul.parsedDouble();
						remainingBalance = owed-payment;
						customer.setRemainingBalance(remainingBalance);
						System.out.println("Payment Successful!");
					case 2:
						System.out.println("exiting payment menu");
						smallLoop = true;
						break;
					
					default:
						System.out.println("Invalid choice, try again!");
						break;
					}
				}
			case 0:
				System.out.println("Logging out");
				exitMenu = true;
				break;
				
			default :
				System.out.println("Invalid selection, try again!");
				break;
				
			}
		}
		
		
	}

}
