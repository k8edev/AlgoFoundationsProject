package TowersOfHanoi;

import java.util.Stack;

public class TowersOfHanoiIterative implements TowersOfHanoi {

    /* keep track of the number of times moveDisc is called */
    /* This is the total number of moves needed for n discs */
    public static int moves;

    // Three stacks to represent the three rods
    private Stack<Integer> rod0;
    private Stack<Integer> rod1;
    private Stack<Integer> rod2;
    private Stack<Integer> destRod;

    // Class to dictate whether we print debug information while moving disks
    private MoveProvider moveProvider;

    @Override
    public int numOfMoves(int numDiscs, boolean printSteps, boolean printFinal) {
        // Validate input
        if (numDiscs < 1) {
            throw new RuntimeException(" Invalid input, should be at least one disc");
        }

        // Select a move provider
        moveProvider = printSteps ? new MoveAndPrint(): new MoveWithoutPrint();

        // Compute the number of moves required
        int numMovesRequired = (int) Math.pow(2, numDiscs) - 1;

        // Initialize variables
        moves = 0;
        rod0 = new Stack();
        rod1 = new Stack();
        rod2 = new Stack();
        destRod = rod1;
        char s = 'A';
        char d = 'B';
        char a = 'C';

        // Initialize rod0 with numDiscs disks
        for (int i = numDiscs; i > 0; i--) {
            rod0.push(i);
        }

        // When we have an even number of disks, need to swap the 'destination' and 'auxiliary' labels,
        // so that the final solution ends up on the 'destination' rod.
        if (numDiscs % 2 == 0) {
            char temp = d;
            d = a;
            a = temp;
            destRod = rod2;
        }

        // Loop through the total # of moves that we know are required
        // Perform the necessary move operation.
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

        // Print the final solution
        if (printFinal) {
            while(!destRod.isEmpty()){
                System.out.println(destRod.pop());
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

        // Source rod is empty
        if (srcTopDisk == Integer.MIN_VALUE) {
            src.push(destTopDisk);
            moveProvider.moveDisk(d, s, destTopDisk);
        }
        // Destination rod is empty
        else if (destTopDisk == Integer.MIN_VALUE) {
            dest.push(srcTopDisk);
            moveProvider.moveDisk(s, d, srcTopDisk);
        }
        // Top source disk > top destination disk
        else if (srcTopDisk > destTopDisk) {
            src.push(srcTopDisk);
            src.push(destTopDisk);
            moveProvider.moveDisk(d, s, destTopDisk);
        }
        // Top source disk < top destination disk
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
