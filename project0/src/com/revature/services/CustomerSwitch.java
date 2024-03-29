package com.revature.services;

import com.revature.beans.Customer;
import com.revature.beans.PaymentBean;
import com.revature.dataImpl.SQLUtility;

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
				//if the payment map does not contain the current customer returns this message
				if(!PaymentMap.doesAccountExist(customer.getUserName())) {
					System.out.println("Sorry, but there are no cars here currently. Hopefully your offer is still pending and will be approved soon.");
					break;
				}
				//otherwise prints the sold car that matches the carId attatched to the customer
				PaymentBean pb = PaymentMap.returnAccount(customer.getUserName());
				SoldCars.printSoldCars(pb.getCarId());
				break;
			
			case 4://make a payment on the car
				//returns a payment object from the account map
				PaymentBean payBean = PaymentMap.returnAccount(customer.getUserName());
				System.out.println(customer.getFirstName()+" your montly payment owed is: "+payBean.getMonthlyPayment());
				System.out.println("Would you like to make a payment?");
				System.out.println("To make a payment press 1");
				int selection = ul.parsedInt();
				
				//if the user wants to make a payment
				if(selection == 1) {
					 payBean.setRemainingBalance(payBean.getRemainingBalance() - payBean.getMonthlyPayment());		//reduces the remaining balance by the montly payment
					 SQLUtility.tryRemoveFromPayment(payBean);		//removes the previous record of the payment
					 SQLUtility.tryAddNewAccount(payBean);			//replaces it with a new payment
					 SQLUtility.tryCreateNewTransactionSQL(payBean);	//updates the database
					 TransactionLedger.populateLedger(payBean);			//populates ledger with a new transaction
					 System.out.println("Payment received");
					 System.out.println("Only $"+ payBean.getRemainingBalance() +" left!");
				}
				else {
					System.out.println("No payment occured!");
				}
				System.out.println("Returning to menu");
				break;
				
			case 0://exit customer menu
				System.out.println("Logging out");
				exitMenu = true;
				break;
				
			default ://not a case input
				System.out.println("Invalid selection, try again!");
				break;
				
			}
		}
		
		
	}

}
