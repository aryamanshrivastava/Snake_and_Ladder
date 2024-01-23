import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Main m1 = new Main();

        Player player1 = new Player(1);
        Player player2 = new Player(2);
        GameBoard g = new GameBoard();

        System.out.println("Press Enter to roll the die and start the game...");
        sc.nextLine();

        // Ensure both players roll a 6 to start the game
        while (m1.dieRoll(player1) != 6 || m1.dieRoll(player2) != 6) {
            System.out.println("Both players need to roll a 6 to start the game. Press Enter to roll again...");
            sc.nextLine();
        }

        System.out.println("Game started!");
        player1.currentPosition = 1;
        player2.currentPosition = 1;

        int diceRollCountPlayer1 = 0;
        int diceRollCountPlayer2 = 0;

        while (player1.currentPosition < 100 && player2.currentPosition < 100) {
            m1.playTurn(player1, g);
            diceRollCountPlayer1++;

            // Check if player1 got a ladder, if so, player1 gets another turn
            if (g.ladders.contains(player1.currentPosition)) {
                System.out.println("Player 1 got a ladder! They get another turn.");
                continue;
            }

            m1.playTurn(player2, g);
            diceRollCountPlayer2++;

            // Check if player2 got a ladder, if so, player2 gets another turn
            if (g.ladders.contains(player2.currentPosition)) {
                System.out.println("Player 2 got a ladder! They get another turn.");
            }
        }

        System.out.println("Game Over!");
        System.out.println("Number of times Player 1 rolled the dice: " + diceRollCountPlayer1);
        System.out.println("Number of times Player 2 rolled the dice: " + diceRollCountPlayer2);

        if (player1.currentPosition == 100) {
            System.out.println("Player 1 won!");
        } else {
            System.out.println("Player 2 won!");
        }
    }

    private void playTurn(Player player, GameBoard gameBoard) {
        System.out.println("\nPlayer " + player.playerNumber + ", press Enter to roll the die...");
        sc.nextLine();

        int rollResult = dieRoll(player);
        int updatePosition = player.currentPosition + rollResult;
        while (gameBoard.ladders.contains(updatePosition)) {
            // If the player lands on a ladder, they get another turn
            System.out.println("Player " + player.playerNumber + " got a ladder! They get another turn.");
            System.out.println("Player " + player.playerNumber + " - Position after dice roll: " + player.currentPosition + " DiceValue: " + player.diceValue);
            System.out.println("Press Enter to roll the die again...");
            sc.nextLine();
            rollResult = dieRoll(player);
            updatePosition = player.currentPosition + rollResult;
        }
        if (gameBoard.snakes.contains(updatePosition)) {
            int index = gameBoard.snakes.indexOf(updatePosition);
            player.currentPosition = gameBoard.snakesBites.get(index);
        } else {
            // Ensure the player gets to the exact winning position (100)
            if (updatePosition <= 100) {
                player.currentPosition = updatePosition;
            }
            // If the player's position goes above 100, stay in the previous position
            // until the player gets the exact number that adds to 100
        }

        System.out.println("Player " + player.playerNumber + " - Position after dice roll: " + player.currentPosition + " DiceValue: " + player.diceValue);
    }

    private int dieRoll(Player player) {
        return player.diceValue = (int) (Math.random() * 6) + 1;
    }
}
