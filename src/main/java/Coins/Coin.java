package Coins;

// A base class for all coins
public abstract class Coin {
    private final int value;

    // Create a new coin with the specified value
    public Coin(int value) {
        this.value = value;
    }

    // Get the value of the coin
    public int getValue() {
        return value;
    }
}
