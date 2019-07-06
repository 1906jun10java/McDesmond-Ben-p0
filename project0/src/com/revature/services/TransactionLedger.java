package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.beans.PaymentBean;

public class TransactionLedger {
	
	static List<PaymentBean> transactionLedger = new ArrayList<>();
	
	//adds an entry to the transaction ledger
	public static void populateLedger(PaymentBean pb) {
		transactionLedger.add(pb);
		return;
	}
	
	//prints all transactions that have occurred
	public static void viewTransactionLedger() {
		
		int iterator = 1;
		for(PaymentBean pb: transactionLedger) {
			System.out.println(iterator+") "+pb);
			iterator++;
		}
	}

}
