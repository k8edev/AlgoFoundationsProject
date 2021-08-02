package GUI;

public class GUIFactorial {
	
	public static String name() {
		return "Factorial"; 
	}
	
	public static double iterative(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial function is only available for numbers greater than 0.");
        }

        double prod = 1;
        for (int i = 2; i <= num; i++) {
            prod = prod * i;
        }

        return prod;
    }
	
	public static double recursive(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial function is only available for numbers greater than 0.");
        }

        return computeFactorial(num);
    }

    /*
    * A helper method used when calculating the Factorial recursively
    *
    * @param The number that we need to compute a factorial for
    * @return The factorial of the number
     */
    private static double computeFactorial(int num) {
       if (num <= 1) {
           return 1;
       }

       return num * computeFactorial(num-1);
    }
}
