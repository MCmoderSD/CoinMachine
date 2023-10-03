@SuppressWarnings("unused")
public class CoinStack {
    private final int increment;
    private final int maxValue;
    private final int minValue;
    private final int maxStackSize;
    private final int minStackSize;
    private int stackSize;
    private int stackValue;

    // Constructor
    public CoinStack(int increment, int minStackSize, int maxStackSize) {
        this.increment = increment;
        this.minStackSize = minStackSize;
        this.maxStackSize = maxStackSize;
        this.minValue = minStackSize * increment;
        this.maxValue = maxStackSize * increment;
        refill();
    }

    private void updateStackSize() {
        stackSize = stackValue / increment;
    }

    private void updateStackValue() {
        stackValue = stackSize * increment;
    }

    // Refill
    public void refill() {
        stackValue = maxValue;
        updateStackSize();
    }

    // Setters
    public void increase() {
        if (stackValue + increment > maxValue) {
            stackValue = maxValue;
            updateStackSize();
        } else {
            stackValue += increment;
            updateStackSize();
        }
    }

    public void decrease() {
        if (stackValue - increment < minValue) {
            stackValue = minValue;
            updateStackSize();
        } else {
            stackValue -= increment;
            updateStackSize();
        }
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
        updateStackValue();
    }

    public void setStackValue(int stackValue) {
        this.stackValue = stackValue;
        updateStackSize();
    }

    // Getters
    public int getIncrement() {
        return increment;
    }
    public int getMaxValue() {
        return maxValue;
    }
    public int getMinValue() {
        return minValue;
    }
    public int getStackValue() {
        return stackValue;
    }
    public int getStackSize() {
        return stackSize;
    }
    public int getMaxStackSize() {
        return maxStackSize;
    }
    public int getMinStackSize() {
        return minStackSize;
    }

    // Checkers
    public boolean hasCoins() {
        return stackSize != 0;
    }
    public boolean isFull() {
        return stackSize == maxStackSize;
    }
    public boolean isEmpty() {
        return stackSize == minStackSize;
    }
}
