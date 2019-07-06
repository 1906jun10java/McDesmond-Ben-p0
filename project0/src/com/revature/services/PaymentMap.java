package com.revature.services;

import java.util.HashMap;

import com.revature.beans.OfferBean;
import com.revature.beans.PaymentBean;
import com.revature.dataImpl.SQLUtility;

public class PaymentMap {
	
	public static HashMap<String,PaymentBean> paymentAccount = new HashMap<>();
	
	public static void createNewPaymentAccount(OfferBean o) {
		double monthlyPayment;
		monthlyPayment = o.getOfferAmount()/36;
		
		PaymentBean p = new PaymentBean(o.getCarId(),o.getCustomerUserName(), monthlyPayment ,o.getOfferAmount());
		paymentAccount.put(p.getCustomerUsername(), p);
		SQLUtility.tryAddNewAccount(p);
		
	}
	public static void createNewPaymentAccount(PaymentBean p) {
		
		new PaymentBean(p.getCarId(),p.getCustomerUsername(), p.getMonthlyPayment() ,p.getRemainingBalance());
		paymentAccount.put(p.getCustomerUsername(), p);
		SQLUtility.tryAddNewAccount(p);
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

}
