
enum SquareType {
    LADDER, CHUTE, NORMAL, START
}

/**
 * <h1> Square </h1>
 * The Square class is basic unit of Board
 *
 * <p>
 * There is four types of Square: Ladder, chute, normal, start(every player located on this before game start)
 * <b> enum: </b> specify what kind of Square
 *
 * @author David Ji
 * @since 2018-5-26
 *
 */
class Square {
    /** specific position in the game board */
    private int currentPos;

    /** if this square is not normal square, which square it should go? */
    private int nextPos;

    /** what kind of square type */
    private SquareType type;

    /**
    * @param currentPos current specific position in a board
    * @param nextPos next position will go if square type is ladder or chute
    * @param type what kind of type the square should be
    */
    Square (int currentPos, int nextPos, SquareType type) {
        this.currentPos = currentPos;
        this.nextPos = nextPos;
        this.type = type;
    }

    /** return current position
     * @return current position
     * */
    int getCurrentPos() {
        return currentPos;
    }

    /** return next position if square is not normal
     * @return next position
     * */
    int getNextPos() {
        return nextPos;
    }

    /** return current square's type
     * @return one of four kinds of square type
     * */
    SquareType getType() {
        return type;
    }
}