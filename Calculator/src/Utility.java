
import java.util.Scanner;

public class Utility {

	ScannerSingleton ss = ScannerSingleton.getInstance();
	Scanner sc = ss.returnScanner();

	// trys to parse a string into an int returns false if exception occurs
	public static boolean tryParseDouble(String userInput) {

		try {
			Double.parseDouble(userInput);

		} catch (Exception e) {
			System.out.println("Input is not a number try again");
			return false;
		}
		return true;
	}

	public double parsedDouble() {
		boolean test = false;
		double result = -1;
		
		while (test == false) {
			String userInput = sc.nextLine();
			test = Utility.tryParseDouble(userInput);
			if (test == true) {
				result = Double.parseDouble(userInput);
			}
		}
		return result;
	}

	public static char testUserString(String userInput) {

		char symbol = '!';
		if (userInput.contains("+")) {
			symbol = '+';
		}
		else if (userInput.contains("-")) {
				symbol =  '-';
		}
		else if (userInput.contains("*")) {
					symbol =  '*';
		}
		else if (userInput.contains("/")) {
						symbol =  '/';
					}
		return symbol;
	}

	public char tryUserInput() {
		String userInput = null;
		char result = '!';
		
		while (result == '!') {
			userInput = sc.nextLine();
			result = testUserString(userInput);
			if(result == '!')
				System.out.println("Invalid input try again");
		}
		return result;
	}
}
