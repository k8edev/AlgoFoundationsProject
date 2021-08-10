package ClojureWrapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClojureWrapperTests {

    private ClojureWrapper clojure;

    private long startTime;
    private long endTime;


    @Before
    public void startTiming() {
        startTime = System.nanoTime();
    }

    @After
    public void endTiming() {
        endTime = System.nanoTime();
        long duration = (endTime - startTime);
        //System.out.println(duration);
    }

    public ClojureWrapperTests() {
        clojure = new ClojureWrapper();
    }

    @Test
    public void tailRecursiveFibonacci_succeeds() {
        // Act
        long result = clojure.tailRecursiveFibonacci(5);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void recursiveFibonacci_succeeds() {
        // Act
        long result = clojure.recursiveFibonacci(5);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void tailRecursiveFactorial_succeeds() {
        // Act
        long result = clojure.tailRecursiveFactorial(5);

        // Assert
        assertEquals(120, result);
    }

    @Test
    public void recursiveFactorial_succeeds() {
        // Act
        long result = clojure.recursiveFactorial(5);

        // Assert
        assertEquals(120, result);
    }

}
