import java.util.Scanner;

public class Switch {
	
	ScannerSingleton ss = ScannerSingleton.getInstance();
	Scanner sc = ss.returnScanner();
	
	
	
	public static void calculatorMenu(){
		Utility ul = new Utility();
		double result;
		
		
		System.out.println("Enter the first number");
		double num1= ul.parsedDouble();
		
		System.out.println("Enter the second number");
		double num2 = ul.parsedDouble();
		
		System.out.println("Enter the arithmetic operation");
		char symbol = ul.tryUserInput();
		
		switch(symbol) {
		
		case '+' :
				result = num1 + num2;
				System.out.println(result);
				break;
		
		case '-' :
				result = num1 - num2;
				System.out.println(result);
				break;
				
		case '*' :
				result = num1 * num2;
				System.out.println(result);
				break;
				
		case '/' :
				result = num1 / num2;
				System.out.println(result);
				break;
				
		default  :
				System.out.println("invalid try again");
				break;
		}
		
		
	}
 
}
