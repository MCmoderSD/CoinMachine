@SuppressWarnings("unused")
public class CoinStack {
    // Constants
    private final long increment; // The value of each coin
    private final long maxValue; // The maximum value of the stack
    private final long minValue; // The minimum value of the stack
    private final long maxStackSize; // The maximum size of the stack
    private final long minStackSize; // The minimum size of the stack

    // Attributes
    private long stackSize; // The current size of the stack
    private long stackValue; // The current value of the stack

    // Constructor
    public CoinStack(long increment, long minStackSize, long maxStackSize) {
        this.increment = increment;
        this.minStackSize = minStackSize;
        this.maxStackSize = maxStackSize;
        this.minValue = minStackSize * increment;
        this.maxValue = maxStackSize * increment;
        refill();
    }


    // Updates stack size and stack value
    private void updateStackSize() {
        stackSize = stackValue / increment;
    }

    private void updateStackValue() {
        stackValue = stackSize * increment;
    }


    // Refill and clear
    public void refill() {
        stackValue = maxValue;
        stackSize = maxStackSize;
    }

    public void clear() {
        stackValue = minValue;
        stackSize = minStackSize;
    }


    // Increase and decrease
    public void increase() {
        // Check if stack value is within bounds
        if (stackValue + increment > maxValue) throw new IllegalArgumentException("Stack value cannot be greater than max stack value");
        else stackValue += increment; // Increase stack value and update stack size
        updateStackSize();
    }

    public void decrease() {
        // Check if stack value is within bounds
        if (stackValue - increment < minValue) throw new IllegalArgumentException("Stack value cannot be less than min stack value");
        else stackValue -= increment; // Decrease stack value and update stack size
        updateStackSize();
    }

    // Setters
    public void setStackSize(long stackSize) {
        // Check if stack size is within bounds
        if (stackSize > maxStackSize) throw new IllegalArgumentException("Stack size cannot be greater than max stack size");
        if (stackSize < minStackSize) throw new IllegalArgumentException("Stack size cannot be less than min stack size");

        // Set stack size and update stack value
        this.stackSize = stackSize;
        updateStackValue();
    }

    public void setStackValue(long stackValue) {
        // Check if stack value is within bounds
        if (stackValue > maxValue) throw new IllegalArgumentException("Stack value cannot be greater than max stack value");
        if (stackValue < minValue) throw new IllegalArgumentException("Stack value cannot be less than min stack value");

        // Set stack value and update stack size
        this.stackValue = stackValue;
        updateStackSize();
    }


    // Getters
    public long getIncrement() {
        return increment;
    }

    public long getStackSize() {
        return stackSize;
    }

    public long getStackValue() {
        return stackValue;
    }

    public long getMaxStackSize() {
        return maxStackSize;
    }

    public long getMinStackSize() {
        return minStackSize;
    }

    public long getMinValue() {
        return minValue;
    }

    public long getMaxValue() {
        return maxValue;
    }


    // Checkers
    public boolean hasCoins() {
        return stackSize > 0;
    }

    public boolean isFull() {
        return stackSize == maxStackSize;
    }

    public boolean isEmpty() {
        return stackSize == minStackSize;
    }
}