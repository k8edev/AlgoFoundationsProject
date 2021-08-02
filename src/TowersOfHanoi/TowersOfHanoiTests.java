package TowersOfHanoi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TowersOfHanoiTests {
    private TowersOfHanoi towersOfHanoi;

    @Parameterized.Parameters()
    public static Collection<TowersOfHanoi> data() {
        ArrayList<TowersOfHanoi> testParams = new ArrayList<>();

        testParams.add(new TowersOfHanoiRecursive());

        return testParams;
    }

    public TowersOfHanoiTests(TowersOfHanoi towerOfHanoi) {
        towersOfHanoi = towerOfHanoi;
    }

    @Test
    public void towersOfHanoi_main() {
        /* Test bench */
        int[] discs = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,100};
        for(int i: discs) {
            int answer = towersOfHanoi.numOfMoves(i);
            System.out.println(" Discs " + i + " Moves " + answer);
            if (answer != (Math.pow(2,i)-1)) {
                throw new RuntimeException(" Incorrect Output from Hanoi algorithm");
            }
        }
    }
}
