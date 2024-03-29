package com.revature.beans;

public class OfferBean {
	

	private int offerId;					//holds sql's id number for the offer
	private String customerUserName;		//holds a customers username
	private int carId;						//holds sql's id for the car
	private double offerAmount;				//holds an offer amount for a car
	
	
	//constructor
	public OfferBean(int carId, double offerAmount, String customerUserName) {
		super();
		this.customerUserName = customerUserName;
		this.carId = carId;
		this.offerAmount = offerAmount;
	}
	
	//getters and setters
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public String getCustomerUserName() {
		return customerUserName;
	}
	public void setCustomerUserName(String customerUserName) {
		this.customerUserName = customerUserName;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public double getOfferAmount() {
		return offerAmount;
	}
	public void setOfferAmount(double offerAmount) {
		this.offerAmount = offerAmount;
	}
	
	//toString override
	@Override
	public String toString() {
		return "OfferBean [offerId=" + offerId + ", customerUserName=" + customerUserName + ", carId=" + carId + ", offerAmount="
				+ offerAmount + "]";
	}

}
