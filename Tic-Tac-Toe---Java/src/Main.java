import java.util.Scanner;

/**
 *The Main class serves as the entry point for the Tic-Tac-Toe game application.
 * It initializes the game by creating two players, setting up the game board,
 * and controlling the main game loop where players take turns until a winner is found or a draw occurs.
 */
public class Main {
    /**
     * The main method is the starting point of the application. It prompts the users to input their names,
     * initializes the players and the game board, and enters the main game loop.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Prompt for player names and create PlayerOne and PlayerTwo objects
        System.out.println("Enter the name of the first player playing as O");
        PlayerOne playerOne = new PlayerOne(scanner.nextLine());

        System.out.println("Enter the name of the second player playing as X");
        PlayerTwo playerTwo = new PlayerTwo(scanner.nextLine());

        //Initialize the game with the two players
        Game game = new Game(playerOne, playerTwo, scanner);
        game.displayBoard();

        //Main game loop: players take turns until there is a winner or a draw
        while (true) {
            game.requestPlayerMove();
            game.displayBoard();
            if (game.checkForWinnerOrDraw()) {
                game.resetGrid();
                game.displayBoard();
            }
        }
    }
}