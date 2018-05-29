import java.io.File;
import java.util.*;

/**
 * <h1>GameController</h1>
 * GameController class is core of this project. we will use it to run the game
 */
class GameController {
    /** The playground Board */
    private Board board;

    /** The list of all player*/
    private List<Player> players;

    /** Random seed to generate random number */
    private Random randomSpin;

    /** Used for check game's status */
    private boolean isTerminated;

    /** It will initialize players' list, flag of game and random seed */
    GameController() {
        players = new LinkedList<>();
        randomSpin = new Random();
        isTerminated = false;
    }

    /**
     * This method is used for initialize playing Board by config file
     * @param fileName Please put the config file into same directory
     */
    void initializeBoard(String fileName) {
        System.out.println("Please put config file into same directory of jar file!");
        File f = new File(System.getProperty("java.class.path"));
        File dir = f.getAbsoluteFile().getParentFile();
        String path = dir.toString();
        board = new Board(path + "/" + fileName);

//        String path = getClass().getResource(fileName).toString();
//        System.out.println(path);
//        board = new Board(path);
    }

    /**
     * This method is used to reset game and play it again
     */
    void reset() {
        players.clear();
        isTerminated = false;
    }

    /**
     * Add 2 - 4 players and prompt every player input their name
     */
    void addPlayers() {
        // how many players?
        System.out.println("Please input how many player will play");
        Scanner sc = new Scanner(System.in);
        int numOfPlayers = sc.nextInt();
        while (numOfPlayers < 2 || numOfPlayers > 4) {
            System.out.println("Only 2 - 4 players allowed");
            numOfPlayers = sc.nextInt();
        }

        // input every player's name
        for (int i = 0; i < numOfPlayers; ++i) {
            System.out.println("Please input player " + (i + 1) + "'s name!");
            String name = sc.next();

            // add current player into sequential list
            Player player = new Player(name);
            players.add(player);
        }
    }

    /**
     * This method is used to create playing order
     * <b>Note: </b> if they have same spin number what can we improve?
     */
    void shufflePlayers() {
        for (Player player : players) {
            int spin = (1 + randomSpin.nextInt(6));
            System.out.println("hi! "+ player.getName() + " get a spin number:  " + spin);
            player.setSpinNum(spin);
        }
        Collections.sort(players);
        System.out.print("Players will following below sequence: ");
        for (int i = 0; i < players.size(); ++i) {
            System.out.print(players.get(i).getName() + (((i+1) != players.size())? "->" : ""));
        }
        System.out.println();
    }

    /**
     * every player will keep playing until one player win the game and game terminated!
     */
    void run() {
        while (!isTerminated) {
            for (Player curPlayer : players) {
                playIteratively(curPlayer);
                if (isWin(curPlayer)) {
                    System.out.println("The winner is: " + curPlayer.getName());
                    break;
                }
            }
        }
    }

    /**
     * each player playing the game
     * <ol>
     *  <li>get step's detail of every turn 1--2--5</li>
     *  <li>print detail</li>
     *  <li>move player to last stop</li>
     * </ol>
     * @param player current player playing
     */
    private void playIteratively(Player player) {
        /* random number between 1 - 6 */
        int rand = 1 + randomSpin.nextInt(3);
        //int rand = 2;
        Square curSquare = board.getSquares().get(player.getCurPosition());
        LinkedList<Square> nextSquares = board.getNextAllSquares(curSquare, rand);

        // print trace of current player
        player.printCurStep(nextSquares);

        // set current player to his destination
        int destination = nextSquares.getLast().getCurrentPos();
        player.setCurPosition(destination);
    }

    /**
     * check if this player is win or not
     *
     * if player's current position is exact finish point, he will win!
     *
     * @param player if current play finished, check this game
     * @return win or not
     */
    private boolean isWin(Player player) {
        if (player.getCurPosition() == board.getCapacity()) {
            this.isTerminated = true;
        }
        return this.isTerminated;
    }
}