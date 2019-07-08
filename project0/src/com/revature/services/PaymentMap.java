package com.revature.services;

import java.util.HashMap;

import com.revature.beans.OfferBean;
import com.revature.beans.PaymentBean;
import com.revature.dataImpl.SQLUtility;

public class PaymentMap {
	
	public static HashMap<String,PaymentBean> paymentAccount = new HashMap<>();
	
	//determines the monthly payment based on the 36 month payment plan
	public static void createNewPaymentAccount(OfferBean o) {
		double monthlyPayment;		//holds the monthly payment 
		monthlyPayment = o.getOfferAmount()/36;		//determines monthly payment by dividing the offer amount by 36 months
		
		//constructs a new payment bean
		PaymentBean p = new PaymentBean(o.getCarId(),o.getCustomerUserName(), monthlyPayment ,o.getOfferAmount());
		paymentAccount.put(p.getCustomerUsername(), p);		//uses the user name  to add it to the hash map  
		SQLUtility.tryAddNewAccount(p);		//tries to add it to the database
			
	}
	
	//creates a new payment account
	public static void createNewPaymentAccount(PaymentBean p) {
		
		new PaymentBean(p.getCarId(),p.getCustomerUsername(), p.getMonthlyPayment() ,p.getRemainingBalance());
		paymentAccount.put(p.getCustomerUsername(), p);
		return;
	}
	
	
	//returns a payment bean if one exists otherwise returns null
	public static PaymentBean returnAccount(String userName) {
		
		if(!paymentAccount.containsKey(userName)) {
			return null;
		}
		
		PaymentBean pb = paymentAccount.get(userName);
		return pb;
	}
	
	//checks if the account exists based on the string passed into this method
	public static boolean doesAccountExist(String key) {
		if(!paymentAccount.containsKey(key)) {
			return false;
		}
		return true;
	}

}
