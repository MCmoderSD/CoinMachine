
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Controller {
    private double totalValue;
    private final GUI gui;
    private final ArrayList<CoinStack> coinStacks = new ArrayList<>();
    private final CoinStack oneCent = new CoinStack(1, 0, 1000);
    private final CoinStack twoCent = new CoinStack(2, 0, 5000);
    private final CoinStack fiveCent = new CoinStack(5, 0, 2000);
    private final CoinStack tenCent = new CoinStack(10, 0, 1000);
    private final CoinStack twentyCent = new CoinStack(20, 0, 5000);
    private final CoinStack fiftyCent = new CoinStack(50, 0, 2000);
    private final CoinStack oneEuro = new CoinStack(100, 0, 100);
    private final CoinStack twoEuro = new CoinStack(200, 0, 500);
    private final CoinStack fiveEuro = new CoinStack(500, 0, 200);
    private final CoinStack tenEuro = new CoinStack(1000, 0, 100);
    private final CoinStack twentyEuro = new CoinStack(2000, 0, 200);
    private final CoinStack fiftyEuro = new CoinStack(5000, 0, 20);
    private final CoinStack oneHundredEuro = new CoinStack(10000, 0, 10);
    private final CoinStack twoHundredEuro = new CoinStack(20000, 0, 5);
    private final CoinStack fiveHundredEuro = new CoinStack(50000, 0, 2);

    // Constructor
    public Controller() {
        coinStacks.add(oneCent);
        coinStacks.add(twoCent);
        coinStacks.add(fiveCent);
        coinStacks.add(tenCent);
        coinStacks.add(twentyCent);
        coinStacks.add(fiftyCent);
        coinStacks.add(oneEuro);
        coinStacks.add(twoEuro);
        coinStacks.add(fiveEuro);
        coinStacks.add(tenEuro);
        coinStacks.add(twentyEuro);
        coinStacks.add(fiftyEuro);
        coinStacks.add(oneHundredEuro);
        coinStacks.add(twoHundredEuro);
        coinStacks.add(fiveHundredEuro);

        updateTotalValue();

        gui = new GUI(this);
    }

    // Calculates the total value of all coin stacks
    private void updateTotalValue() {
        totalValue = 0;
        for (CoinStack coinStack : coinStacks) totalValue += coinStack.getStackValue();
        totalValue *= 0.01;
    }

    // Refill all coin stacks
    public void refill() {
        for (CoinStack coinStack : coinStacks) coinStack.refill();
        updateTotalValue();
    }

    // Refill all coin stacks with custom values
    public void refill(int oneCentStack, int twoCentStack, int fiveCentStack, int tenCentStack, int twentyCentStack, int fiftyCentStack, int oneEuroStack, int twoEuroStack, int fiveEuroStack, int tenEuroStack, int twentyEuroStack, int fiftyEuroStack, int oneHundredEuroStack, int twoHundredEuroStack, int fiveHundredEuroStack) {
        oneCent.setStackSize(oneCentStack);
        twoCent.setStackSize(twoCentStack);
        fiveCent.setStackSize(fiveCentStack);
        tenCent.setStackSize(tenCentStack);
        twentyCent.setStackSize(twentyCentStack);
        fiftyCent.setStackSize(fiftyCentStack);
        oneEuro.setStackSize(oneEuroStack);
        twoEuro.setStackSize(twoEuroStack);
        fiveEuro.setStackSize(fiveEuroStack);
        tenEuro.setStackSize(tenEuroStack);
        twentyEuro.setStackSize(twentyEuroStack);
        fiftyEuro.setStackSize(fiftyEuroStack);
        oneHundredEuro.setStackSize(oneHundredEuroStack);
        twoHundredEuro.setStackSize(twoHundredEuroStack);
        fiveHundredEuro.setStackSize(fiveHundredEuroStack);

        updateTotalValue();
    }

    // Dispense coins
    public void withdraw(double amount) {
        updateTotalValue();
        int totalValue = (int) (this.totalValue * 100);
        int amountLeft = (int) (amount * 100);

        if (amountLeft > totalValue) gui.showErrorMessage("Not enough coins in the machine!");
        else while (amountLeft > 0) {
            if (amountLeft >= fiveHundredEuro.getStackValue() && fiveHundredEuro.hasCoins()) {
                fiveHundredEuro.decrease();
                amountLeft -= fiveHundredEuro.getStackValue();
            } else if (amountLeft >= twoHundredEuro.getStackValue() && twoHundredEuro.hasCoins()) {
                twoHundredEuro.decrease();
                amountLeft -= twoHundredEuro.getStackValue();
            } else if (amountLeft >= oneHundredEuro.getStackValue() && oneHundredEuro.hasCoins()) {
                oneHundredEuro.decrease();
                amountLeft -= oneHundredEuro.getStackValue();
            } else if (amountLeft >= fiftyEuro.getStackValue() && fiftyEuro.hasCoins()) {
                fiftyEuro.decrease();
                amountLeft -= fiftyEuro.getStackValue();
            } else if (amountLeft >= twentyEuro.getStackValue() && twentyEuro.hasCoins()) {
                twentyEuro.decrease();
                amountLeft -= twentyEuro.getStackValue();
            } else if (amountLeft >= tenEuro.getStackValue() && tenEuro.hasCoins()) {
                tenEuro.decrease();
                amountLeft -= tenEuro.getStackValue();
            } else if (amountLeft >= fiveEuro.getStackValue() && fiveEuro.hasCoins()) {
                fiveEuro.decrease();
                amountLeft -= fiveEuro.getStackValue();
            } else if (amountLeft >= twoEuro.getStackValue() && twoEuro.hasCoins()) {
                twoEuro.decrease();
                amountLeft -= twoEuro.getStackValue();
            } else if (amountLeft >= oneEuro.getStackValue() && oneEuro.hasCoins()) {
                oneEuro.decrease();
                amountLeft -= oneEuro.getStackValue();
            } else if (amountLeft >= fiftyCent.getStackValue() && fiftyCent.hasCoins()) {
                fiftyCent.decrease();
                amountLeft -= fiftyCent.getStackValue();
            } else if (amountLeft >= twentyCent.getStackValue() && twentyCent.hasCoins()) {
                twentyCent.decrease();
                amountLeft -= twentyCent.getStackValue();
            } else if (amountLeft >= tenCent.getStackValue() && tenCent.hasCoins()) {
                tenCent.decrease();
                amountLeft -= tenCent.getStackValue();
            } else if (amountLeft >= fiveCent.getStackValue() && fiveCent.hasCoins()) {
                fiveCent.decrease();
                amountLeft -= fiveCent.getStackValue();
            } else if (amountLeft >= twoCent.getStackValue() && twoCent.hasCoins()) {
                twoCent.decrease();
                amountLeft -= twoCent.getStackValue();
            } else if (amountLeft >= oneCent.getStackValue() && oneCent.hasCoins()) {
                oneCent.decrease();
                amountLeft -= oneCent.getStackValue();
            } else {
                gui.showErrorMessage("Not enough coins in the machine!");
                gui.showErrorMessage("You got " + (amount - amountLeft) + " coins.");
                break;
            }
        }
    }

    // Getter for the Total Value
    public double getTotalValue() {
        updateTotalValue();
        return totalValue;
    }

    // Getters for the Stack Size
    public int getOneCentStackSize() {
        return oneCent.getStackSize();
    }
    public int getTwoCentStackSize() {
        return twoCent.getStackSize();
    }
    public int getFiveCentStackSize() {
        return fiveCent.getStackSize();
    }
    public int getTenCentStackSize() {
        return tenCent.getStackSize();
    }
    public int getTwentyCentStackSize() {
        return twentyCent.getStackSize();
    }
    public int getFiftyCentStackSize() {
        return fiftyCent.getStackSize();
    }
    public int getOneEuroStackSize() {
        return oneEuro.getStackSize();
    }
    public int getTwoEuroStackSize() {
        return twoEuro.getStackSize();
    }
    public int getFiveEuroStackSize() {
        return fiveEuro.getStackSize();
    }
    public int getTenEuroStackSize() {
        return tenEuro.getStackSize();
    }
    public int getTwentyEuroStackSize() {
        return twentyEuro.getStackSize();
    }
    public int getFiftyEuroStackSize() {
        return fiftyEuro.getStackSize();
    }
    public int getOneHundredEuroStackSize() {
        return oneHundredEuro.getStackSize();
    }
    public int getTwoHundredEuroStackSize() {
        return twoHundredEuro.getStackSize();
    }
    public int getFiveHundredEuroStackSize() {
        return fiveHundredEuro.getStackSize();
    }
}
