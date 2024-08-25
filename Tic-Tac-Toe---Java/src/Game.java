import java.util.Scanner;

public class Game {
    private final PlayerOne playerOne;
    private final PlayerTwo playerTwo;
    private final Scanner scanner;
    private Player currentPlayer;
    private Player[][] grid;

    public Game(PlayerOne playerOne, PlayerTwo playerTwo, Scanner scanner) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.scanner = scanner;
        this.currentPlayer = this.playerOne;
        this.grid = new Player[3][3];
    }
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
    public void switchTurn() {
        if (this.currentPlayer == this.playerOne) {
            this.currentPlayer = this.playerTwo;
        } else {
            this.currentPlayer = this.playerOne;
        }
    }

    public boolean isPositionAvailable(int row, int column) {
        return this.grid[row][column] == null;
    }
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
    public void announceWinner(Player winner) {
        winner.increaseScore();
        System.out.println("Congratulations, " + winner.getName() + "! You have won!");
    }
    public void resetGrid() {
        this.grid = new Player[3][3];
    }
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
