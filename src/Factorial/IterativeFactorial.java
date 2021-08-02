package Factorial;

/*
 * An iterative implementation of a Factorial
 * */
public class IterativeFactorial implements Factorial {
    @Override
    public double findFactorial(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial function is only available for numbers greater than 0.");
        }

        double prod = 1;
        for (double i = 2; i <= num; i++) {
            prod = prod * i;
        }

        return prod;
    }
}
