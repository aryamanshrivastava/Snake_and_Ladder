import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main m1 = new Main();

        Player p1 = new Player(0);
        GameBoard g = new GameBoard();

        System.out.println("Press Enter to roll the die and start the game...");
        sc.nextLine();

        // Ensure the game starts only when the player rolls a 6
        while (m1.dieRoll(p1) != 6) {
            System.out.println("You need to roll a 6 to start the game. Press Enter to roll again...");
            sc.nextLine();
        }

        System.out.println("Game started!");
        p1.currentPosition = 1;

        while (p1.currentPosition < 100) {
            m1.playTurn(p1, g);
        }

        System.out.println("You won!!");
    }

    private void playTurn(Player player, GameBoard gameBoard) {
        System.out.println("\nPress Enter to roll the die...");
        sc.nextLine();

        int rollResult = dieRoll(player);
        int updatePosition = player.currentPosition + rollResult;

        if (gameBoard.ladders.contains(updatePosition)) {
            int index = gameBoard.ladders.indexOf(updatePosition);
            player.currentPosition = gameBoard.ladderDestination.get(index);
        } else if (gameBoard.snakes.contains(updatePosition)) {
            int index = gameBoard.snakes.indexOf(updatePosition);
            player.currentPosition = gameBoard.snakesBites.get(index);
        } else {
            player.currentPosition = Math.min(updatePosition, 100); // Ensure position doesn't exceed 100
        }

        System.out.println(player);
    }

    private int dieRoll(Player player) {
        return player.diceValue = (int) (Math.random() * 6) + 1;
    }
}

