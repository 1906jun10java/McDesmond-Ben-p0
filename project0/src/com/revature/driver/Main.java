package com.revature.driver;

import java.util.Scanner;

import com.revature.services.ScannerSingleton;
import com.revature.services.SwitchMenus;

public class Main {

	public static void main(String[] args) {
		
		//returns a reference to the singleton class ScannerSingleton
		ScannerSingleton ss = ScannerSingleton.getInstance();
		
		//returns a reference to the static scanner in the ScannerSingleton class
		Scanner sc = ss.returnScanner();
		
		//opens the programs main menu
		SwitchMenus.mainMenu();
		
		//closes the static scanner at the end of the program
		sc.close();
		
	}

}
