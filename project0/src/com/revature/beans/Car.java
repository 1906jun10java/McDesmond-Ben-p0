package com.revature.beans;

public class Car {
	
	//constructor for a new car object
	public Car(String color, String make, String model, int year, int mileage) {
		super();
		this.color = color;
		this.make = make;
		this.model = model;
		this.year = year;
		this.mileage = mileage;
	}

	
	private Integer carId;			//unique identifier given by sql
	private String color;		//color of a car
	private String make;		//car make
	private String model;		//car model
	private int year;			//car year
	private int mileage;		//car mileage
	

	//getters and setters
	public Integer getCarId() {
		return carId;
	}
	
	public void setCarId(int carId) {
		this.carId = carId;
	}
	
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
	
	
	@Override
	public String toString() {
		return "Car [carId=" + carId + ", color=" + color + ", make=" + make + ", model=" + model + ", year=" + year
				+ ", mileage=" + mileage + "]";
	}	
}
