package project;

public class Fibonnaci {
	
	public static int fibonnaciIter(int n) {
		int ret = 1;
		int prev1 = 0; 
		int prev2 = 1;
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
	
	public static int fibonnaciRecur(int n) {
		if (n == 0) {
			return 0;
		}
		else if (n == 1 || n == 2) {
			return 1;
		}
		else {
			return fibonnaciRecur(n-1) + fibonnaciRecur(n-2);
		}
	}
	
	public static void main(String[] args) {
		// Test bench code
		int testArr[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
		for (int i = 0; i < 10; i++) {
			if (testArr[i] != fibonnaciRecur(i) || testArr[i] != fibonnaciIter(i)) {
				System.out.println("\nError " + i);
				System.out.println(fibonnaciRecur(i));
				System.out.println(fibonnaciIter(i));
			}
			else {
				System.out.print(fibonnaciRecur(i) + ","); 
			}
		}
	}
}
