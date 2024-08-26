/**
 * Represents a player in the Tic-Tac-Toe game.
 * This abstract class provides common functionality for all players, such as tracking the player's score,
 * name, symbol, and color for displaying in the console.
 */
public abstract class Player {
    private int score = 0;
    private final String name;
    private final String symbol;
    private final String colour;
    private final String resetColour = "\033[0m";

    /**
     * Constructs a Player with the specified name, symbol, and display color.
     *
     * @param name The name of the player.
     * @param symbol The symbol representing the player (e.g., "X" or "O").
     * @param colour The ANSI color code used to colorize the player's name and symbol in the console.
     */
    public Player(String name, String symbol, String colour) {
        this.name = name;
        this.symbol = symbol;
        this.colour = colour;
    }

    /**
     * Gets the current score of the player.
     *
     * @return The player's score.
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Increases the player's score by one.
     */
    public void increaseScore() {
        this.score += 1;
    }

    /**
     * Gets the player's symbol, colorized for display in the console.
     *
     * @return The player's symbol as a string, wrapped in ANSI color codes.
     */
    public String getSymbol() {
        return this.colour + this.symbol + this.resetColour;
    }

    /**
     * Gets the player's name, colorized for display in console.
     *
     * @return The player's name as a string, wrapped in ANSI color codes.
     */
    public String getName() {
        return this.colour + this.name + this.resetColour;
    }

    /**
     * Returns a string representation of the player, including their name and current score.
     *
     * @return A string in the format "PlayerName: Score".
     */
    @Override
    public String toString() {
        return this.getName() + ": " + this.score;
    }
}
