import java.util.Random;

public class Main {
    public static void main(String[] args) {
        playGame();
    }

    // Simulates rolling a six-sided die
    private static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }

    // Moves the player based on the current position and the value rolled on the die
    private static int movePlayer(int currentPosition, int diceValue) {
        return currentPosition + diceValue;
    }

    // Main game logic for Snake and Ladder
    private static void playGame() {
        int playerPosition = 0;
        int targetPosition = 100;
        System.out.println("Welcome to Snake and Ladder Game!");

        while (playerPosition < targetPosition) {
            int diceValue = rollDice();
            System.out.println("You rolled a " + diceValue);

            // Check if the player is close to 100 and needs a precise roll
            if (playerPosition >= 94 && playerPosition <= 99) {
                int remainingDistance = targetPosition - playerPosition;
                if (diceValue > remainingDistance) {
                    System.out.println("You need a precise roll to reach 100. Roll again.");
                    continue;  // Roll again
                }
            }

            // Move the player based on the dice value
            playerPosition = movePlayer(playerPosition, diceValue);
            System.out.println("Your current position is " + playerPosition);

            // Check if the player landed on a Snake or Ladder and update the position
            playerPosition = checkSnakeAndLadder(playerPosition);
        }

        System.out.println("Congratulations! You reached the target position.");
    }

    // Checks if the player landed on a Snake or Ladder and updates the position accordingly
    private static int checkSnakeAndLadder(int position) {
        return switch (position) {
            case 12 -> {
                System.out.println("You landed on a ladder! Move to position 37.");
                yield 37;
            }
            case 21 -> {
                System.out.println("Oops! You landed on a snake. Move back to position 9.");
                yield 9;
            }
            case 28 -> {
                System.out.println("You landed on a ladder! Move to position 84.");
                yield 84;
            }
            case 51 -> {
                System.out.println("Oops! You landed on a snake. Move back to position 7.");
                yield 7;
            }
            case 71 -> {
                System.out.println("You landed on a ladder! Move to position 91.");
                yield 91;
            }
            case 87 -> {
                System.out.println("Oops! You landed on a snake. Move back to position 24.");
                yield 24;
            }
            default -> position;
        };
    }
}
