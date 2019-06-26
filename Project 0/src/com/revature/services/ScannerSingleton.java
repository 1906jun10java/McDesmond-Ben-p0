package com.revature.services;

import java.util.Scanner;

public class ScannerSingleton {
	
	private static ScannerSingleton ss = null;
	private static Scanner sc = new Scanner(System.in);

	private ScannerSingleton() {
		super();
	}

	public static ScannerSingleton getInstance() {
		if(ss == null) {
			ss = new ScannerSingleton();
		}
		return ss;
	}
	
	public Scanner returnScanner() {
		return sc;
	}

}
