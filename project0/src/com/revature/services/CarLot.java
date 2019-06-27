package com.revature.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.revature.beans.Car;

public class CarLot {
	
	static ArrayList<Car> carLot = new ArrayList<Car>();		//an array list for storing all the cars on the lot
	
	
	//adds a car to the lot
	public static void addCar(String color, String make ,String model, int year, int mileage) {
		Car c = new Car(color,make,model,year,mileage);
		carLot.add(c);
		return;
	}
	
	//removes a car from the lot
	public static void removeCar(Car car) {
		carLot.remove(car);
		return;
	}
	
	//checks the lot for a car and returns the index of the car in the car lot
	public static int checkLotForCar(Car car) {
		
		int index = 0;
		
		if(carLot.contains(car)) {
			index = carLot.lastIndexOf(car);
		}
		
		return index;
	}

	//prints all cars in the lot
	public static void printTheLot() {
		int i = 1; 
		for(Car c:carLot) {
			System.out.print(i + " ");
			System.out.println(c);
			i++;
		}
	}
	
	//
	public static void viewOffers() {
		int currentOffers;
		Set<Double> keys = new HashSet<>();
		
		for(Car c:carLot) {
			currentOffers = c.offers.size();
			if(currentOffers > 0) {
				keys = c.offers.keySet();
				System.out.println(c);
				for(double a : keys) {
					System.out.println(a);
				}
			}
		}
	}
	
	public static Car returnCar(int index) {
		Car c = carLot.get(index);
		return c;
	}
}
