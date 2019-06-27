import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ScannerSingleton ss = ScannerSingleton.getInstance();
		Scanner sc = ss.returnScanner();
		Switch.calculatorMenu();
		sc.close();
		

	}

}
