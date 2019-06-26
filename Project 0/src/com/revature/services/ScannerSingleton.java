package com.revature.services;

import java.util.Scanner;

public class ScannerSingleton {
	
	//Sets instance of this class to null
	private static ScannerSingleton ss = null;
	
	//Creates a static instance of the scanner unique to this class
	private static Scanner sc = new Scanner(System.in);

	//no args constructor for the singleton
	private ScannerSingleton() {
		super();
	}

	//method that returns a new instance of the singleton if ss == null
	public static ScannerSingleton getInstance() {
		if(ss == null) {
			ss = new ScannerSingleton();
		}
		return ss;
	}
	
	//returns a reference to the scanner 
	public Scanner returnScanner() {
		return sc;
	}

}
