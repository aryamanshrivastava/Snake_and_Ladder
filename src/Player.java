public class Player {
    int currentPosition;
    int diceValue;
    Player(int n){
        this.currentPosition = n;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Player{" +
                "currentPosition=" + currentPosition +
                ", diceValue=" + diceValue +
                '}';
    }
}
