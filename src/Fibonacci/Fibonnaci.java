package Fibonacci;

public class Fibonnaci {
	
	public static String name() {
		return "Fibonnaci"; 
	}
	public static double iterative(int n) {
		double ret = 1;
		double prev1 = 0; 
		double prev2 = 1;
		if (n == 0) {
			ret = 0;
		}
		else if (n == 1 || n == 2) {
			ret = 1;
		}
		for (int i = 2; i <= n; i++) {
			ret = prev1 + prev2;
			prev1 = prev2;
			prev2 = ret; 
		}
		return ret;
	}
	
	public static double recursive(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1 || n == 2) {
			return 1;
		}
		else {
			return recursive(n-1) + recursive(n-2);
		}
	}
	
	public static void main(String[] args) {
		// Test bench code
		int testArr[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
		for (int i = 0; i < 10; i++) {
			if (testArr[i] != recursive(i) || testArr[i] != iterative(i)) {
				System.out.println("\nError " + i);
				System.out.println(recursive(i));
				System.out.println(iterative(i));
			}
		}
		
		// Collect runtime data
		int maxInput = 50; 
		long startTime, endTime, duration = 0; 
		for (int i = 0; i < maxInput; i++) {
			startTime = System.nanoTime(); 
			iterative(i);
			endTime = System.nanoTime(); 
			duration = endTime - startTime; 
			System.out.println("Input: " + i + " Iterative time: " + duration);
			startTime = System.nanoTime(); 
			recursive(i);
			endTime = System.nanoTime(); 
			duration = endTime - startTime; 
			System.out.println("Input: " + i + " Recursive time: " + duration);
		}
	}
}
