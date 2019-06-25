package com.revature.beans;

public class Car {
	
	private String color;		//color of a car
	private String make;		//car make
	private String model;		//car model
	private int year;			//car year
	private long mileage;		//car mileage
	
	
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
	public long getMileage() {
		return mileage;
	}
	public void setMileage(long mileage) {
		this.mileage = mileage;
	}
	
	
	//toString for printing the current car object
	@Override
	public String toString() {
		return "Car [color=" + color + ", make=" + make + ", model=" + model + ", year=" + year + ", mileage=" + mileage
				+ "]";
	}

}
