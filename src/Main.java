import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int position = 0;
        Player p1 = new Player(position);
        p1.diceValue = (int) (Math.random()*10 % 6)+1;
        position += p1.diceValue;
        p1.currentPosition = position;
        System.out.println("Position of player 1: "+p1.currentPosition);
    }
}