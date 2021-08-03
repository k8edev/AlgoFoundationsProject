package TowersOfHanoi;

import java.util.Stack;

public class TowersOfHanoiIterative implements TowersOfHanoi {

    /* keep track of the number of times moveDisc is recursively called */
    /* This is the total number of moves needed for n discs */
    public static int moves;

    // Three stacks to represent the three rods
    private Stack<Integer> rod0;
    private Stack<Integer> rod1;
    private Stack<Integer> rod2;

    // Class to dictate whether we print debug information while moving disks
    private MoveProvider moveProvider;

    @Override
    public int numOfMoves(int numDiscs, boolean printSteps) {
        // Validate input
        if (numDiscs < 1) {
            throw new RuntimeException(" Invalid input, should be at least one disc");
        }

        if (printSteps) {
            moveProvider = new MoveAndPrint();
        }
        else {
            moveProvider = new MoveWithoutPrint();
        }

        int numMovesRequired = (int) Math.pow(2, numDiscs) - 1;

        moves = 0;

        rod0 = new Stack();
        rod1 = new Stack();
        rod2 = new Stack();

        char s = 'A';
        char d = 'B';
        char a = 'C';

        // Initialize rod0 with numDiscs disks
        for (int i = numDiscs; i > 0; i--) {
            rod0.push(i);
        }

        if (numDiscs % 2 == 0) {
            char temp = d;
            d = a;
            a = temp;
        }

        for (int i = 1; i <= numMovesRequired; i++) {
            if (i % 3 == 1) {
                moveDisks(rod0, rod1, s, d);
            }
            else if (i % 3 == 2) {
                moveDisks(rod0, rod2, s, a);
            }
            else if (i % 3 == 0) {
                moveDisks(rod2, rod1, a, d);
            }
        }

        return moves;
    }

    /**
     * Helper method to move disks between two poles
     */
    private void moveDisks(Stack<Integer> src, Stack<Integer> dest, char s, char d) {
        int srcTopDisk = Integer.MIN_VALUE;
        if (!src.isEmpty()) {
            srcTopDisk = src.pop();
        }

        int destTopDisk = Integer.MIN_VALUE;
        if (!dest.isEmpty()) {
            destTopDisk = dest.pop();
        }

        if (srcTopDisk == Integer.MIN_VALUE) {
            src.push(destTopDisk);
            moveProvider.moveDisk(d, s, destTopDisk);
        }
        else if (destTopDisk == Integer.MIN_VALUE) {
            dest.push(srcTopDisk);
            moveProvider.moveDisk(s, d, srcTopDisk);
        }
        else if (srcTopDisk > destTopDisk) {
            src.push(srcTopDisk);
            src.push(destTopDisk);
            moveProvider.moveDisk(d, s, destTopDisk);
        }
        else {
            dest.push(destTopDisk);
            dest.push(srcTopDisk);
            moveProvider.moveDisk(s, d, srcTopDisk);
        }
    }


    /**
     * Helper interface to dictate approach to moving the disk.
     * In other languages, this would be implemented with a function delegate.
     */
    private interface MoveProvider {
        void moveDisk(char src, char dest, int disk);
    }

    /**
     * Helper class that supports printing a debug message while performing a move operation
     */
    private class MoveAndPrint implements MoveProvider{
        public void moveDisk(char src, char dest, int disk) {
            moves++;
            System.out.println("Move the disk " + disk + " from " + src + " to " + dest);
        }
    }

    /**
     * Helper class that supports performing a move operation
     */
    private class MoveWithoutPrint implements MoveProvider {
        public void moveDisk(char src, char dest, int disk) {
            moves++;
        }
    }
}
