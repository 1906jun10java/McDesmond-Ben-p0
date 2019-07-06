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
	
	public static void printSoldCars(int carId) {
		
		for(Car c :soldCars) {
			System.out.println(c);
			if(c.getCarId() == carId) {
				System.out.println(c);
			}
			return;
		}
	}

}
