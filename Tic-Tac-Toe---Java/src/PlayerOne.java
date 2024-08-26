/**
 * Representations the first player in the Tic-Tac-Toe game, playing with the "O" symbol.
 * This class extends the abstract {@link Player} class and sets the specific symbol and color for Player One.
 */
public class PlayerOne extends Player {
    /**
     * Constructs a PlayerOne object with specified name.
     * The player's symbol is set to  "O" and the color is set to blue.
     *
     * @param name The name of the first player.
     */
    public PlayerOne(String name) {
        super(name, "O", "\033[0;34m");

    }
}
