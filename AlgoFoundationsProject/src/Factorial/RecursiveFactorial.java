package Factorial;

/*
* A recursive implementation of a Factorial
* */
public class RecursiveFactorial implements Factorial{

    @Override
    public double findFactorial(double num) {
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
    private double computeFactorial(double num) {
       if (num <= 1) {
           return 1;
       }

       return num * computeFactorial(num-1);
    }
}
