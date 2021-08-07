package Factorial;

public class FactorialDemoData {
    private static Factorial iterativeFactorial;
    private static Factorial recursiveFactorial;

    public static void main(String[] args) {
        iterativeFactorial = new IterativeFactorial();
        recursiveFactorial = new RecursiveFactorial();

        long[] iterResults = new long[20];
        long[] recurResults = new long[20];

        int highestFact = 20;

        System.out.println("Iterative");
        for (int factNum = highestFact; factNum >= 1; factNum--) {

            System.out.print(factNum + ";");
            int idx = factNum -1;

            for (int iter = 0; iter <= 100; iter++) {
                long startTime = System.nanoTime();

                iterativeFactorial.findFactorial(factNum);

                long endTime = System.nanoTime();
                iterResults[idx] += (endTime - startTime);
            }

            long factAvg = (long) (iterResults[idx] / 100.0);
            System.out.println(factAvg);
        }

        System.out.println("Recursive");
        for (int factNum = highestFact; factNum >=1; factNum--) {

            System.out.print(factNum + ";");
            int idx = factNum - 1;

            for (int iter = 0; iter <= 100; iter++) {
                long startTime = System.nanoTime();

                recursiveFactorial.findFactorial(factNum);

                long endTime = System.nanoTime();
                recurResults[idx]+= (endTime - startTime);
            }

            long factAvg = (long) (recurResults[idx]/100.0);
            System.out.println(factAvg);
        }

    }
}