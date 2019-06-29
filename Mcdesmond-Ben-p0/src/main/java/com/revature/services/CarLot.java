package com.revature.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.revature.beans.Car;
import com.revature.beans.Customer;

public class CarLot {
	
	static ArrayList<Car> carLot = new ArrayList<Car>();		//an array list for storing all the cars on the lot
	
	
	//adds a car to the lot
	public static void addCar(String color, String make ,String model, int year, int mileage) {
		Car c = new Car(color,make,model,year,mileage);			//uses the car constructor to populate the fields of the new car object
		carLot.add(c);											//adds the newly constructed car to the lot
		return;
	}
	
	//removes a car from the lot
	public static void removeCar(Car car) {
		carLot.remove(car);						//removes the current car object from the carlot arrayList
		return;
	}
	
	//checks the lot for a car and returns the index of the car in the car lot
	public static int checkLotForCar(Car car) {
		
		int index = 0;							//initializes an index to 0
		
		if(carLot.contains(car)) {				//if the lot contains the passed in car object
			index = carLot.lastIndexOf(car);	//returns the index of the first car that matches that object 
		}
		
		return index;							//returns that cars index
	}

	//prints all cars in the lot
	public static void printTheLot() {
		int i = 1; 							//sets index to 1 for user convienence 
		for(Car c:carLot) {					//for every car in the car lot
			System.out.print(i + ") ");		//print the index of the current car
			System.out.println(c);			//print the toString of the current car
			i++;							//adds one to the index so the cars have unique identifiers that represent their index on the lot
		}
	}
	
	//prints all cars on the lot, then allows an employee to view all offers on a specific car  
	public static void viewOffers() {
		int currentOffers;						//holds the number of offers in the cars offer array
		Set<Double> keys = new HashSet<>();		//holds a set of all the keys in a cars offers hashmap
		int index = 1;							//creates an index for each car on the lot so the user can request a specific one
		
		for(Car c:carLot) {						//for every car on the lot
			currentOffers = c.offers.size();	//sets the number of offers on the current car to currentOffers
			if(currentOffers > 0) {				//if there is an offer on this car
				keys = c.offers.keySet();		//pull the offer from the hashmap on that car
				System.out.println(index +") " + c);		//prints the index and info of the car
				for(double a : keys) {			//for every offer in the offers hashmap
					System.out.println(a);		//print every offer
				}
			}
		index++;		//adds one to the index
		}
	}

	//takes the selected index for the car on the lot and the offer key and accepts the current offer
	public static void acceptAnOffer(int carIndex,double key) {
		
		Car c = carLot.get(carIndex - 1);		//uses the passed index minus one for user convienence to access a car on the carLot
		Customer cu = c.offers.get(key);		//uses the offer key to access the customer who made that offer
		c.setSold(true);						//sets the isSold field of that car to true
		carLot.remove(c);						//removes the current car item from the lot
		System.out.println("Offer Accepted, car is removed from the lot!");
	}
	
	//uses the index of the car to return the current instance of the car
	public static Car returnCar(int index) {
		Car c = carLot.get(index);		//uses the index to return a specific car from the lot using the index of the array list
		return c;						//returns that car to the calling function
	}
}
