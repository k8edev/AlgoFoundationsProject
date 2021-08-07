package Factorial;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FactorialTests {

    private Factorial factorial;

    private double precisionLoss = 0.01;
    private long startTime;
    private long endTime;

    @Parameterized.Parameters()
    public static Collection<Factorial> data() {
        ArrayList<Factorial> testParams = new ArrayList<>();

        testParams.add(new IterativeFactorial());
        testParams.add(new RecursiveFactorial());

        return testParams;
    }

    @Before
    public void startTiming() {
        System.out.print(factorial.getClass() + " -- ");
        startTime = System.nanoTime();
    }

    @After
    public void endTiming() {
        endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration);
    }

    public FactorialTests(Factorial fact) {
        factorial = fact;
    }

    @Test
    public void findFactorial_ReturnsOne_IfNumberIsZero() {
        // Act
        double result = factorial.findFactorial(0);

        // Assert
        assertEquals(1, result, precisionLoss);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFactorial_ThrowsException_IfNumberIsNegative() {
        // Act
        factorial.findFactorial(-1);
    }

    @Test
    public void findFactorial_ReturnsOne_IfNumberIsOne() {
        // Act
        double result = factorial.findFactorial(1);

        // Assert
        assertEquals(1, result, precisionLoss);
    }

    @Test
    public void findFactorial_Succeeds_IfNumberIsSmall() {
        // Act
        double result = factorial.findFactorial(5);

        // Assert
        assertEquals(120, result, precisionLoss);
    }

    @Test
    public void findFactorial_Succeeds_IfNumberIsLarge() {
        // Act
        double result = factorial.findFactorial(20);

        // Assert
        assertEquals(2432902008176640000.0, result, precisionLoss);
    }
}
