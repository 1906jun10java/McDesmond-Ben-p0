package com.revature.services;

import java.util.ArrayList;

import com.revature.beans.Car;
import com.revature.dataImpl.SQLUtility;

public class CarLot {
	
	static ArrayList<Car> carLot = new ArrayList<Car>();		//an array list for storing all the cars on the lot
	
	//adds a car to the lot
	public static void addCar(String color, String make ,String model, int year, int mileage) {
		Car c = new Car(color,make,model,year,mileage);			//uses the car constructor to populate the fields of the new car object
		carLot.add(c);											//adds the newly constructed car to the lot
		SQLUtility.tryAddNewCarSQL(c); 							//adds the newly constructed car to the database
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
	


	//prints all cars in the lot
	public static void printTheLot() {
		int i = 1; 							//sets index to 1 for user convenience 
		for(Car c:carLot) {					//for every car in the car lot
			System.out.print(i + ") ");		//print the index of the current car
			System.out.println(c);			//print the toString of the current car
			i++;							//adds one to the index so the cars have unique identifiers that represent their index on the lot
		}
	}
	
	//uses the index of the car to return the current instance of the car
	public static Car returnCar(int index) {
		if(index > carLot.size() || index < 0) {
			System.out.println("No selection made, going back now!");
			return null;
		}
		Car c = carLot.get(index);		//uses the index to return a specific car from the lot using the index of the array list
		return c;						//returns that car to the calling function
	}
	
	//checks the lot for a car that has a matching carId
	public static Car returnCarByCarId(int carId) {
		
		for(Car c: carLot) {					//for each car on the lot
			if(c.getCarId() == carId) {			//if the carId matches 
				return c;						//return that car
			}
		}
		System.out.println("Error car not found!");	
		return null; 							//otherwise return null
	}
}
