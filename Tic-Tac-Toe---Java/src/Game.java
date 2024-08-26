import java.util.Scanner;

/**
 * Represents the game logic for a Tic-Tac-Toe game.
 * Handles player turns, checking for a winner or draw, and managing the game board.
 */
public class Game {
    private final PlayerOne playerOne;
    private final PlayerTwo playerTwo;
    private final Scanner scanner;
    private Player currentPlayer;
    private Player[][] grid;

    /**
     * Constructs a Game instance with two players and a scanner for input.
     *
     * @param playerOne The first player playing as "O"
     * @param playerTwo The second player playing as "X"
     * @param scanner The scanner used to capture user input.
     */
    public Game(PlayerOne playerOne, PlayerTwo playerTwo, Scanner scanner) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.scanner = scanner;
        this.currentPlayer = this.playerOne;
        this.grid = new Player[3][3];
    }

    /**
     * Requests a move from the current player, validates the input, and updates the game board.
     */
    public void requestPlayerMove() {
        int row = this.getValidCoordinate("row");
        int column = this.getValidCoordinate("column");

        while (!this.isPositionAvailable(row - 1, column - 1)) {
            System.out.println("This spot is already taken. Please select a different one.");
            row = this.getValidCoordinate("row");
            column = this.getValidCoordinate("column");
        }

        this.grid[row - 1][column - 1] = this.currentPlayer;
        this.switchTurn();

    }

    /**
     * Gets a valid row or column coordinate from player.
     *
     * @param type *The type of coordinate to get ("row" or "column").
     * @return The valid coordinate (1, 2 or 3) entered by the player.
     */
    public int getValidCoordinate(String type) {
        int coordinate;

        while (true) {
            System.out.println("Which " + type + " would you like to select " + this.currentPlayer.getName() + " (Choose between 1 and 3)");
            if (this.scanner.hasNextInt()) {
                coordinate = this.scanner.nextInt();
                if (coordinate >= 1 && coordinate <= 3) {
                    break;
                } else {
                    System.out.println("Oops! You can only pick 1, 2, or 3. Please try again.");
                }
            } else {
                System.out.println("That's not a valid number. Please try again.");
                this.scanner.next();
            }
        }
        return coordinate;
    }

    /**
     * Switches turn of the players.
     */
    public void switchTurn() {
        if (this.currentPlayer == this.playerOne) {
            this.currentPlayer = this.playerTwo;
        } else {
            this.currentPlayer = this.playerOne;
        }
    }

    /**
     * Checks if the specified position on the grid is available.
     *
     * @param row The row index (0-2)
     * @param column The column index (0-2)
     * @return True if the position is available, false otherwise.
     */
    public boolean isPositionAvailable(int row, int column) {
        return this.grid[row][column] == null;
    }

    /**
     * Checks if the game has been won by a player or if it has ended in a draw.
     * If the player has won, announces the winner.
     *
     * @return True if the game is over (either by win or draw), false otherwise.
     */
    public boolean checkForWinnerOrDraw() {
        Player winner = null;
        for (int i = 0; i < 3; i++) {
            if (this.grid[i][0] != null && this.grid[i][0] == this.grid[i][1] && this.grid[i][1] == this.grid[i][2]) {
                this.announceWinner(this.grid[i][0]);
                return true;
            }
            if (this.grid[0][i] != null && this.grid[0][i] == this.grid[1][i] && this.grid[1][i] == this.grid[2][i]) {
                this.announceWinner(this.grid[0][i]);
                return true;
            }
        }
        if (this.grid[0][0] != null && this.grid[0][0] == this.grid[1][1] && this.grid[1][1] == this.grid[2][2]) {
            this.announceWinner(this.grid[0][0]);
            return true;
        }
        if (this.grid[2][0] != null && this.grid[2][0] == this.grid[1][1] && this.grid[1][1] == this.grid[0][2]) {
            this.announceWinner(this.grid[2][0]);
            return true;
        }

        for (Player[] row : this.grid) {
            for (Player cell : row) {
                if (cell == null) {
                    return false;
                }
            }
        }

        System.out.println("It's a draw! Great game, try again to break the tie!");
        return true;
    }

    /**
     * Announces the winner and increases their score.
     *
     * @param winner The player who has won the game.
     */
    public void announceWinner(Player winner) {
        winner.increaseScore();
        System.out.println("Congratulations, " + winner.getName() + "! You have won!");
    }

    /**
     * Resets the game board for a new game.
     */
    public void resetGrid() {
        this.grid = new Player[3][3];
    }

    /**
     * Displays the current game board and the players scores.
     */
    public void displayBoard() {
        System.out.println();
        System.out.println(this.playerOne.toString());
        System.out.println(this.playerTwo.toString());

        for (int row = 0; row < this.grid.length; row++) {
            for (int col = 0; col < this.grid[row].length; col++) {
                if (this.grid[row][col] == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(this.grid[row][col].getSymbol());
                }
                if (col < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (row < 2) {
                System.out.println("---------");
            }
        }
    }
}
