package com.revature.beans;

import java.util.HashMap;

public class Car {
	
	public Car(String color, String make, String model, int year, int mileage) {
		super();
		this.color = color;
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
	}

	public HashMap<Double,Customer> offers = new HashMap<>();
	
	private String color;		//color of a car
	private String make;		//car make
	private String model;		//car model
	private int year;			//car year
	private int mileage;		//car mileage
	private boolean isSold;		//boolean value to determine if car is sold
	
	
	public boolean isSold() {
		return isSold;
	}

	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}

	//getters and setters
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	
	
	//toString for printing the current car object
	@Override
	public String toString() {
		return "Car [color=" + color + ", make=" + make + ", model=" + model + ", year=" + year + ", mileage=" + mileage
				+ "]";
	}
	
	public void makeAnOffer(double offer,Customer c) {
		offers.put(offer, c);
	}
	
}
