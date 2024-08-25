import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the first player playing as O");
        PlayerOne playerOne = new PlayerOne(scanner.nextLine());

        System.out.println("Enter the name of the second player playing as X");
        PlayerTwo playerTwo = new PlayerTwo(scanner.nextLine());

        Game game = new Game(playerOne, playerTwo, scanner);
        game.displayBoard();

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