public abstract class Player {
    private int score = 0;
    private final String name;
    private final String symbol;
    private final String colour;
    private final String resetColour = "\033[0m";

    public Player(String name, String symbol, String colour) {
        this.name = name;
        this.symbol = symbol;
        this.colour = colour;
    }

    public int getScore() {
        return this.score;
    }

    public void increaseScore() {
        this.score += 1;
    }

    public String getSymbol() {
        return this.colour + this.symbol + this.resetColour;
    }

    public String getName() {
        return this.colour + this.name + this.resetColour;
    }

    @Override
    public String toString() {
        return this.getName() + ": " + this.score;
    }
}
