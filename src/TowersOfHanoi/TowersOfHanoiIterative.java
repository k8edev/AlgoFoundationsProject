package TowersOfHanoi;

import java.util.Stack;

public class TowersOfHanoiIterative implements TowersOfHanoi {

    /* keep track of the number of times moveDisc is recursively called */
    /* This is the total number of moves needed for n discs */
    public static int moves;

    @Override
    public int numOfMoves(int numDiscs) {
        if (numDiscs < 1) {
            throw new RuntimeException(" Invalid input, should be at least one disc");
        }
        int numMovesRequired = (int) Math.pow(2, numDiscs) - 1;
        moves = 0;

        Stack<Integer> rod0 = new Stack();
        Stack<Integer> rod1 = new Stack();
        Stack<Integer> rod2 = new Stack();

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
            } else if (i % 3 == 2) {
                moveDisks(rod0, rod2, s, a);
            } else if (i % 3 == 0) {
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
            moveDisk(d, s, destTopDisk);
        } else if (destTopDisk == Integer.MIN_VALUE) {
            dest.push(srcTopDisk);
            moveDisk(s, d, srcTopDisk);
        } else if (srcTopDisk > destTopDisk) {
            src.push(srcTopDisk);
            src.push(destTopDisk);
            moveDisk(d, s, destTopDisk);
        } else {
            dest.push(destTopDisk);
            dest.push(srcTopDisk);
            moveDisk(s, d, srcTopDisk);
        }
    }

    /**
     * Helper method to perform a move operation
     *
     * @param src The source rod
     * @param dest
     * @param disk
     */
    private void moveDisk(char src, char dest, int disk) {
        System.out.println("Move the disk " + disk + " from " + src + " to " + dest);
        moves++;
    }
}
