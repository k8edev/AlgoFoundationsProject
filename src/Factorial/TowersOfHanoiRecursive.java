package project;

public class TowersOfHanoiRecursive {
	/* keep track of the number of times moveDisc is recursively called */
	/* This is the total number of moves needed for n discs */
    public static int moves; 
    
	/* RULES 
	 * Start of with n discs stacked from smallest on top to biggest on bottom
	 * Can only move the top disc of a stack per move
	 * Cannot put a disc on top of a smaller disc
	 * Have three rods, need to move the stack to the last rod
	 * 2^n -1 moves is the minimum
	 * */
	public static void moveDisc(int disc, int rod0, int rod1, int rod2) {
		moves = moves + 1; 
		if (disc == 1) {
			return;
		}
		moveDisc(disc-1,rod0,rod1,rod2);
		moveDisc(disc-1,rod1,rod2,rod0);
	}
	
	/* helper function to count the numbers of times moveDisc is recursively called */
	public static int numOfMoves(int numDiscs) {
		if (numDiscs < 1) {
			throw new RuntimeException(" Invalid input, should be at least one disc");
		}
		moves = 0; 
		moveDisc(numDiscs,0,1,2);
		return moves; 
	}
	
	public static void main(String[] args) {
		/* Test bench */
		int[] discs = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,100}; 
		for(int i: discs) {
			int answer = numOfMoves(i);
			System.out.println(" Discs " + i + " Moves " + answer); 
			if (answer != (Math.pow(2,i)-1)) {
				throw new RuntimeException(" Incorrect Output from Hanoi algorithm");
			}
		}
	}

}
