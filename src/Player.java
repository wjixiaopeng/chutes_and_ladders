import java.util.List;
/**
 * <h1>Player</h1>
 * Player Class is basic class to store Player's information:
 */
public class Player implements Comparable<Player> {
    /** Current position in Board */
    private int curPosition;

    /** Player's name */
    private String name;

    /** Player's spin number which is decide who will play firstly */
    private int spinNum;

    /**
     * constructor for new player
     * @param name palyer's name
     */
    Player(String name) {
        this.curPosition = 0;
        this.name = name;
    }

    /** get current position of player
     * @return return current position
     * */
    int getCurPosition() {
        return curPosition;
    }

    /** return player's name
     * @return player's name
     * */
    String getName() {
        return name;
    }

    /** return player's spin number which is used for shuffle players
     * @param spinNum randomly generate spin number
     * */
    void setSpinNum(int spinNum) {
        this.spinNum = spinNum;
    }

    /** move player to next position
     * @param nextPosition next position the player should go
     * */
    void setCurPosition(int nextPosition) {
        this.curPosition = nextPosition;
    }

    /**
     * This method is used to print the detail log of play's turn
     * @param squares this list was be collected by Board class and means every step of current turn
     */
    void printCurStep(List<Square> squares) {
        StringBuilder trace;
        trace = new StringBuilder();
        trace.append(getName()).append(": ").append(getCurPosition()).append(" --> ");

        for (Square next : squares) {
            trace.append(next.getCurrentPos());
            if (next.getType() == SquareType.LADDER) {
                trace.append(" --Ladder--> ");
            } else if (next.getType() == SquareType.CHUTE) {
                trace.append(" --Chute--> ");
            }
        }
        System.out.println(trace.toString());
    }

    /**
     * override compareTo method is used for sort player's order when they playing first round
     * <b>Note: </b> use collections.sort() to sort by spin number
     */
    @Override
    public int compareTo(Player other) {
        return other.spinNum - this.spinNum;
    }
}
