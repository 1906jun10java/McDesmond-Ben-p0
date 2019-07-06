package com.revature.services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.beans.OfferBean;
import com.revature.dataImpl.SQLUtility;

public class Offers {

	public static HashMap<Double, OfferBean> offers = new HashMap<>(); // a hashmap that stores the offers on a car along
																		// with the customer info

	// grants access to all non static methods in the Utility class
	static Utility ul = new Utility();

	public static void createNewOffer(Customer customer) {

		int index = 0; // holds the index value of the car in the carLot
		double offer = 0; // holds the customers offer before it is stored
		Car car;

		CarLot.printTheLot(); // prints every car on the lot
		System.out.println("Please enter the number for the car you are interested in today?");
		index = ul.parsedInt(); // returns the index of the car + 1(for user readability purposes)
		car = CarLot.returnCar(--index); // returns a car from the car lot
		
		if(car == null) {
			return;
		}
		
		System.out.println(car); // prints the car for bug checking purposes and user assurance
		System.out.println("How much would you offer for this car?");
		offer = ul.parsedDouble(); // takes a dollar amount from the user to be used as an offer
		
		OfferBean o = new OfferBean(car.getCarId(), offer, customer.getUserName());		//creates a new offer bean to pass down the chain
		offers.put(offer, o); // stores the customers offer in the car's offer hashmap
		SQLUtility.tryCreateNewOffer(o); // attempts to create a new offer on the offers table
		System.out.println("Offer successfully added! Please wait for an employee to approve your offer!");
	}

	// populates the offer hashmap
	public static void populateOfferMap(OfferBean o) {
		double offer = o.getOfferAmount();
		offers.put(offer, o);
		return;
	}

	//prints all the keys /offers in the offers hashmap
	public static void printOffers() {
		Set<Double> keys = new HashSet<>(); // holds a set of all the keys in a cars offers hashmap
		int index = 1; // creates an index for each car on the lot so the user can request a specific one
		
		System.out.println("Current number of offers on a car");
		 keys = offers.keySet();
		 for(double offer : keys) {
			 OfferBean o = offers.get(offer);
			 Car c = CarLot.returnCarByCarId((o.getCarId()));
			 System.out.println(index + ") " +offer+": "+c);
			 index++;
		 }
	}
	
	public static void selectOffer() {
		
		double offer;
		
		
		System.out.println("Select an offer by entering the dollar amount");
		offer = ul.parsedDouble();
		
		if(offers.containsKey(offer)) {
			OfferBean o = offers.get(offer);
			PaymentMap.createNewPaymentAccount(o);
			Car c = CarLot.returnCarByCarId(o.getCarId());
			SoldCars.addCarObject(c);
			CarLot.removeCar(c);
			SQLUtility.tryAddNewSoldCarSQL(c);
			SQLUtility.tryPurgeLowOffers(o);
			SQLUtility.tryRemoveCarFromLotSQL(c);
			System.out.println("Offer selected!");
		}
		
		else {
			System.out.println("No offers selected!");
		}
		return;
		
	}
}
