public class Main {
    /**
     * <h2> Please play Game of Chutes and Ladders follow these rules: </h2>
     * <ol>
     *     <li> Put the config file into same package of project </li>
     *     <li> Instantiate Class of GameController </li>
     *     <li> Initialize Board by inputting the config file(board info) </li>
     *     <li> Run AddPlayers method to add 2 - 4 player into game </li>
     *     <li> Shuffle Players by spin number and then deciding who player first </li>
     *     <li> Run the game until a winner occur </li>
     *     <li> Reset the game if you want play again </li>
     * </ol>
     * @param args system input
     */
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.initializeBoard("boardInfo.txt");
        gameController.addPlayers();
        gameController.shufflePlayers();
        gameController.run();
        gameController.reset();
    }
}
