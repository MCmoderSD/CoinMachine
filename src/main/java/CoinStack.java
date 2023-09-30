@SuppressWarnings("unused")
public class CoinStack {
    private final int increment;
    private final int maxCapacity;
    private final int minCapacity;
    private int stackSize;
    private int stackValue;

    // Constructor
    public CoinStack(int minStackSize, int maxStackSize, int increment) {
        this.minCapacity = minStackSize * increment;
        this.maxCapacity = maxStackSize * increment;
        this.increment = increment;
        refill();
    }

    // Refill
    public void refill() {
        stackValue = maxCapacity;
    }

    // Setters
    public void increase() {
        if (stackValue + increment > maxCapacity) stackValue = maxCapacity;
        else stackValue += increment;
    }

    public void decrease() {
        if (stackValue - increment < minCapacity) stackValue = minCapacity;
        else stackValue -= increment;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
        stackValue = stackSize * increment;
    }

    public void setStackValue(int stackValue) {
        this.stackValue = stackValue;
        stackSize = stackValue / increment;
    }

    // Getters
    public int getIncrement() {
        return increment;
    }
    public int getMaxValue() {
        return maxCapacity;
    }
    public int getMinValue() {
        return minCapacity;
    }
    public int getStackValue() {
        return stackValue;
    }
    public int getStackSize() {
        return stackValue / increment;
    }
    public int getMaxCapacity() {
        return maxCapacity / increment;
    }
    public int getMinCapacity() {
        return minCapacity / increment;
    }
}
