package com.revature.driver;

import java.util.Scanner;

import com.revature.services.ScannerSingleton;
import com.revature.services.SwitchMenus;

public class Main {

	public static void main(String[] args) {
		
		SwitchMenus sm = new SwitchMenus();
		ScannerSingleton ss = ScannerSingleton.getInstance();
		Scanner sc = ss.returnScanner();
		sm.mainMenu();
		sc.close();
		
	}

}
