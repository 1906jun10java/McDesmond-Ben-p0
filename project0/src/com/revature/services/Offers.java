package com.revature.services;

import java.util.HashMap;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.beans.OfferBean;
import com.revature.dataImpl.SQLUtility;

public class Offers {
	
	public static HashMap<Double,Customer> offers = new HashMap<>();		//a hashmap that stores the offers on a car along with the customer info
	
	
	//grants access to all non static methods in the Utility class
	static Utility ul = new Utility();

	public static void createNewOffer(Customer customer) {
		
		int index = 0;				//holds the index value of the car in the carLot
		double offer = 0;			//holds the customers offer before it is stored
		Car car;
		
		
		CarLot.printTheLot();		//prints every car on the lot
		System.out.println("Please enter the number for the car you are interested in today?");
		index = ul.parsedInt();		//returns the index of the car + 1(for user readability purposes)
		car = CarLot.returnCar(--index);	//returns a car from the car lot 
		System.out.println(car);			//prints the car for bug checking purposes and user assurance
		System.out.println("How much would you offer for this car?");	
		offer = ul.parsedDouble();			//takes a dollar amount from the user to be used as an offer
		offers.put(offer, customer);	//stores the customers offer in the car's offer hashmap 
		SQLUtility.tryCreateNewOffer(offer, customer, car); 		//attempts to create a new offer on the offers table
		System.out.println("Offer successfully added! Please wait for an employee to approve your offer!");
	}
	
	//populates the offer hashmap
	public static void populateOfferMap(OfferBean o) {
		double offer = o.getOfferAmount();
		String userName = o.getCustomerUserName();
		Customer c = Login.returnCustomer(userName);
		offers.put(offer, c);
		return;
	}
}
