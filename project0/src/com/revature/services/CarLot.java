package com.revature.services;

import java.util.ArrayList;

import com.revature.beans.Car;
import com.revature.beans.Customer;
import com.revature.dataImpl.SQLUtility;

public class CarLot {
	
	static ArrayList<Car> carLot = new ArrayList<Car>();		//an array list for storing all the cars on the lot
	
	
	//adds a car to the lot
	public static void addCar(String color, String make ,String model, int year, int mileage) {
		Car c = new Car(color,make,model,year,mileage);			//uses the car constructor to populate the fields of the new car object
		carLot.add(c);											//adds the newly constructed car to the lot
		SQLUtility.tryAddNewCarSQL(c); 							//adds the newly constructed car to the sql database
		return;
	}
	
	//adds a car object to the carLot
	public static void addCarObject(Car c) {
		carLot.add(c);		//adds a car object to the carLot
		return;
	}
	
	//removes a car from the lot
	public static void removeCar(Car car) {
		carLot.remove(car);						//removes the current car object from the car lot arrayList
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
		int i = 1; 							//sets index to 1 for user convenience 
		for(Car c:carLot) {					//for every car in the car lot
			System.out.print(i + ") ");		//print the index of the current car
			System.out.println(c);			//print the toString of the current car
			i++;							//adds one to the index so the cars have unique identifiers that represent their index on the lot
		}
	}

	//takes the selected index for the car on the lot and the offer key and accepts the current offer
	public static void acceptAnOffer(int carIndex,double key) {
		
		Car c = carLot.get(carIndex - 1);		//uses the passed index minus one for user convenience to access a car on the carLot
		Customer cu = c.offers.get(key);		//uses the offer key to access the customer who made that offer
		c.setSold("true");						//sets the isSold field of that car to true
		cu.setRemainingBalance(key);			//sets the offer made by the customer to the remaining balance on their account
		cu.ownACar(c);							//adds that car's info to the customers array list of owned cars
		carLot.remove(c);						//removes the current car item from the lot
		System.out.println("Offer Accepted, car is removed from the lot!");
	}
	
	//uses the index of the car to return the current instance of the car
	public static Car returnCar(int index) {
		Car c = carLot.get(index);		//uses the index to return a specific car from the lot using the index of the array list
		return c;						//returns that car to the calling function
	}
}
