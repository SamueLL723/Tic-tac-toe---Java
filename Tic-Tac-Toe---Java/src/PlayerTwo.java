/**
 * Represents the second player in the Tic-Tac-Toe game, playing with the "X" symbol.
 * This class extends the abstract {@link Player} class and sets the specific symbol and color for Player Two.
 */
public class PlayerTwo  extends Player {
    /**
     * Constructs a PlayerTwo object with specified name.
     * The player's symbol is set to "X" and the color is set to red.
     *
     * @param name The name of the second player.
     */
    public PlayerTwo(String name) {
        super(name, "X", "\033[0;31m");
    }
}
