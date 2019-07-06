package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Car;

public class SoldCars {
	
	public static List<Car> soldCars= new ArrayList<>();
	
	//adds a car object to the carLot
	public static void addCarObject(Car c) {
		soldCars.add(c);		//adds a car object to the carLot
		return;
	}
	
	//prints a car from the sold lot based on its sql id number
	public static void printSoldCars(int carId) {
		
		for(Car c :soldCars) {			//for every sold car in the list
			if(c.getCarId() == carId) {		//if the car id's match
				System.out.println(c);		//print the car
			}
			return;
		}
	}

}
