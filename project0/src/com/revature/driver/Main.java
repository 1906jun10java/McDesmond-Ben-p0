package com.revature.driver;

import java.util.Scanner;

import com.revature.dataImpl.SQLUtility;
import com.revature.services.ScannerSingleton;
import com.revature.services.SwitchMenus;

public class Main {

	public static void main(String[] args) {
		
		//returns a reference to the singleton class ScannerSingleton
		ScannerSingleton ss = ScannerSingleton.getInstance();
		
		//returns a reference to the static scanner in the ScannerSingleton class
		Scanner sc = ss.returnScanner();
		
		SQLUtility.tryPopulateCarLotSQL();		//attempts a sql connection to populate the car lot
		SQLUtility.tryReturnCustomersSQL();		//attempts a sql connection to populate the customers hashmap
		SQLUtility.tryReturnEmployeesSQL();		//attempts a sql connection to populate the employees hashmap
		SQLUtility.tryPopulateOfferMap(); 		//attempts a sql connection to populate the offers hashmap
		SQLUtility.tryPopulateSoldCarsSQL();	//populates sold car hashmap
		SQLUtility.tryPopulatePaymentsSQL(); 	//populates payment map
		
		//opens the programs main menu
		SwitchMenus.mainMenu();
		
		//closes the static scanner at the end of the program
		sc.close();
		
	}

}
