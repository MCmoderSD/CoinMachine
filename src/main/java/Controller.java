
import java.util.ArrayList;

@SuppressWarnings("unused")
public class Controller {
    private int totalValue;
    private final GUI gui;

    private final ArrayList<Storage> coinStacks = new ArrayList<>();
    private final Storage oneCent = new Storage(0, 100, 1);
    private final Storage twoCent = new Storage(0, 100, 2);
    private final Storage fiveCent = new Storage(0, 100, 5);
    private final Storage tenCent = new Storage(0, 100, 10);
    private final Storage twentyCent = new Storage(0, 100, 20);
    private final Storage fiftyCent = new Storage(0, 100, 50);
    private final Storage oneEuro = new Storage(0, 100, 100);
    private final Storage twoEuro = new Storage(0, 100, 200);

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

        updateTotalValue();

        gui = new GUI(this);
    }

    // Calculates the total value of all coin stacks
    private void updateTotalValue() {
        totalValue = 0;
        for (Storage coinStack : coinStacks) totalValue += coinStack.getStackValue();
    }

    // Refill all coin stacks
    public void refill() {
        for (Storage coinStack : coinStacks) coinStack.refill();
        updateTotalValue();
    }

    // Refill all coin stacks with custom values
    public void refill(int oneCentStack, int twoCentStack, int fiveCentStack, int tenCentStack, int twentyCentStack, int fiftyCentStack, int oneEuroStack, int twoEuroStack) {
        oneCent.setStackSize(oneCentStack);
        twoCent.setStackSize(twoCentStack);
        fiveCent.setStackSize(fiveCentStack);
        tenCent.setStackSize(tenCentStack);
        twentyCent.setStackSize(twentyCentStack);
        fiftyCent.setStackSize(fiftyCentStack);
        oneEuro.setStackSize(oneEuroStack);
        twoEuro.setStackSize(twoEuroStack);
        updateTotalValue();
    }

    // Dispense coins
    public void withDraw(int amount) {
        updateTotalValue();
        int amountLeft = amount;

        if (amountLeft > totalValue) gui.showErrorMessage("Not enough coins in the machine!");
        else while (amountLeft > 0) {
            if (amountLeft >= 200 && twoEuro.getStackSize() > 0) {
                twoEuro.decrease();
                amountLeft -= 200;
            } else if (amountLeft >= 100 && oneEuro.getStackSize() > 0) {
                oneEuro.decrease();
                amountLeft -= 100;
            } else if (amountLeft >= 50 && fiftyCent.getStackSize() > 0) {
                fiftyCent.decrease();
                amountLeft -= 50;
            } else if (amountLeft >= 20 && twentyCent.getStackSize() > 0) {
                twentyCent.decrease();
                amountLeft -= 20;
            } else if (amountLeft >= 10 && tenCent.getStackSize() > 0) {
                tenCent.decrease();
                amountLeft -= 10;
            } else if (amountLeft >= 5 && fiveCent.getStackSize() > 0) {
                fiveCent.decrease();
                amountLeft -= 5;
            } else if (amountLeft >= 2 && twoCent.getStackSize() > 0) {
                twoCent.decrease();
                amountLeft -= 2;
            } else if (oneCent.getStackSize() > 0) {
                oneCent.decrease();
                amountLeft -= 1;
            } else {
                gui.showErrorMessage("Not enough coins in the machine!");
                gui.showErrorMessage("You got only " + (amount - amountLeft) + " coins!" );
                break;
            }
        }
    }

    // Getter for the Total Value
    public int getTotalValue() {
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
}
