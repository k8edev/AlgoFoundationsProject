package TowersOfHanoi;

public interface TowersOfHanoi {

    /* RULES
     * Start of with n discs stacked from smallest on top to biggest on bottom
     * Can only move the top disc of a stack per move
     * Cannot put a disc on top of a smaller disc
     * Have three rods, need to move the stack to the last rod
     * 2^n -1 moves is the minimum
     * */
    void moveDisc(int disc, int rod0, int rod1, int rod2);

    int numOfMoves(int numDiscs);
}
