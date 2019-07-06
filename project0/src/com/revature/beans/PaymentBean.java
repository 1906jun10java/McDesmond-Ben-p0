package com.revature.beans;

public class PaymentBean {
	

	private int accountId;						//holds the accountId for the payment account
	private int carId;							//holds the id for the purchased car
	private String customerUsername;			//holds the customer username
	private double monthlyPayment;				//holds the monthly payment for the car
	private double remainingBalance;			//holds the remaining balance for the car
	
	//constructor
	public PaymentBean(int carId, String customerUsername, double monthlyPayment, double remainingBalance) {
		super();
		this.carId = carId;
		this.customerUsername = customerUsername;
		this.monthlyPayment = monthlyPayment;
		this.remainingBalance = remainingBalance;
	}
	
	//getters and setters
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public String getCustomerUsername() {
		return customerUsername;
	}
	public void setCustomerUsername(String customerUsername) {
		this.customerUsername = customerUsername;
	}
	public double getMonthlyPayment() {
		return monthlyPayment;
	}
	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	public double getRemainingBalance() {
		return remainingBalance;
	}
	public void setRemainingBalance(double remainingBalance) {
		this.remainingBalance = remainingBalance;
	}
	
	//toString
	@Override
	public String toString() {
		return "PaymentBean [accountId=" + accountId + ", carId=" + carId + ", customerUsername=" + customerUsername
				+ ", monthlyPayment=" + monthlyPayment + ", remainingBalance=" + remainingBalance + "]";
	}
	

}
