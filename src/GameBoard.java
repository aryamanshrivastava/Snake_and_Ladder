import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class GameBoard {

    ArrayList<Integer> snakes = new ArrayList<>();
    ArrayList<Integer> snakesBites = new ArrayList<>();
    ArrayList<Integer> ladders = new ArrayList<>();
    ArrayList<Integer> ladderDestination = new ArrayList<>();

    GameBoard() {
        // Snakes
        List<Integer> snakeVal = Arrays.asList(17, 34, 47, 62, 88, 93, 95, 99);
        this.snakes.addAll(snakeVal);

        // Snake Bites
        List<Integer> snakeBiteVal = Arrays.asList(7, 19, 29, 38, 49, 66, 80, 87);
        this.snakesBites.addAll(snakeBiteVal);

        // Ladders
        List<Integer> ladderVal = Arrays.asList(3, 12, 25, 40, 55, 70, 82, 92);
        this.ladders.addAll(ladderVal);

        // Ladder Destinations
        List<Integer> ladderDestinationVal = Arrays.asList(21, 28, 37, 52, 68, 85, 88, 96);
        this.ladderDestination.addAll(ladderDestinationVal);
    }
}
