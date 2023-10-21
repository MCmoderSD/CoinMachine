package de.MCmoderSD.core;

import de.MCmoderSD.UI.GUI;
import de.MCmoderSD.data.CoinStack;

import java.util.ArrayList;

@SuppressWarnings("unused")
public class Controller {
    // Constants
    private final GUI gui; // de.MCmoderSD.UI.GUI
    private final ArrayList<CoinStack> coinStacks = new ArrayList<>(); // ArrayList of all coin stacks
    private final CoinStack oneCent, twoCent, fiveCent, tenCent, twentyCent, fiftyCent, oneEuro, twoEuro; // Coins
    private final CoinStack fiveEuro, tenEuro, twentyEuro, fiftyEuro, oneHundredEuro, twoHundredEuro, fiveHundredEuro; // Banknotes

    // Attributes
    private double totalValue; // Total value of all coin stacks

    // Constructor
    public Controller() {

        // Initialize all coin stacks
        oneCent = new CoinStack(1, 0, 5000);
        twoCent = new CoinStack(2, 0, 2500);
        fiveCent = new CoinStack(5, 0, 2000);
        tenCent = new CoinStack(10, 0, 1000);
        twentyCent = new CoinStack(20, 0, 1000);
        fiftyCent = new CoinStack(50, 0, 1000);
        oneEuro = new CoinStack(100, 0, 1000);
        twoEuro = new CoinStack(200, 0, 750);

        // Initialize all banknote stacks
        fiveEuro = new CoinStack(500, 0, 500);
        tenEuro = new CoinStack(1000, 0, 250);
        twentyEuro = new CoinStack(2000, 0, 100);
        fiftyEuro = new CoinStack(5000, 0, 50);
        oneHundredEuro = new CoinStack(10000, 0, 30);
        twoHundredEuro = new CoinStack(20000, 0, 20);
        fiveHundredEuro = new CoinStack(50000, 0, 10);

        // Add all coin stacks to the ArrayList
        coinStacks.add(oneCent);
        coinStacks.add(twoCent);
        coinStacks.add(fiveCent);
        coinStacks.add(tenCent);
        coinStacks.add(twentyCent);
        coinStacks.add(fiftyCent);
        coinStacks.add(oneEuro);
        coinStacks.add(twoEuro);

        // Add all banknote stacks to the ArrayList
        coinStacks.add(fiveEuro);
        coinStacks.add(tenEuro);
        coinStacks.add(twentyEuro);
        coinStacks.add(fiftyEuro);
        coinStacks.add(oneHundredEuro);
        coinStacks.add(twoHundredEuro);
        coinStacks.add(fiveHundredEuro);

        // Calculate the total value of all coin stacks
        updateTotalValue();

        // Create the de.MCmoderSD.UI.GUI
        gui = new GUI(this);
    }


    // Calculation methods:

    // Calculates the total value of all coin stacks
    private void updateTotalValue() {
        // Reset the total value
        long combinedValue = 0;

        // Add the value of each coin stack to the total value
        for (CoinStack coinStack : coinStacks) combinedValue += coinStack.getStackValue();

        // Convert the total value to Euro
        totalValue = combinedValue * 0.01;
    }

    // Check if the machine has enough coins to dispense
    private long[] withdrawIsPossible(double amount) {

        // Create an array to store the amount of coins to dispense
        long amountLeft = (long) (amount * 100);

        // Create an array to store the amount of coins to dispense
        long[] coinStacks = new long[15];

        updateTotalValue(); // Update the total value of all coin stacks

        // Check if the machine has enough coins to dispense
        if (amountLeft > totalValue * 100) return null; // Checks total value
        else while (amountLeft > 0) { // Checks each coin stack
            if (amountLeft >= fiveHundredEuro.getIncrement() && fiveHundredEuro.hasCoins()) {
                fiveHundredEuro.decrease();
                amountLeft -= fiveHundredEuro.getIncrement();
                coinStacks[14]++;
            } else if (amountLeft >= twoHundredEuro.getIncrement() && twoHundredEuro.hasCoins()) {
                twoHundredEuro.decrease();
                amountLeft -= twoHundredEuro.getIncrement();
                coinStacks[13]++;
            } else if (amountLeft >= oneHundredEuro.getIncrement() && oneHundredEuro.hasCoins()) {
                oneHundredEuro.decrease();
                amountLeft -= oneHundredEuro.getIncrement();
                coinStacks[12]++;
            } else if (amountLeft >= fiftyEuro.getIncrement() && fiftyEuro.hasCoins()) {
                fiftyEuro.decrease();
                amountLeft -= fiftyEuro.getIncrement();
                coinStacks[11]++;
            } else if (amountLeft >= twentyEuro.getIncrement() && twentyEuro.hasCoins()) {
                twentyEuro.decrease();
                amountLeft -= twentyEuro.getIncrement();
                coinStacks[10]++;
            } else if (amountLeft >= tenEuro.getIncrement() && tenEuro.hasCoins()) {
                tenEuro.decrease();
                amountLeft -= tenEuro.getIncrement();
                coinStacks[9]++;
            } else if (amountLeft >= fiveEuro.getIncrement() && fiveEuro.hasCoins()) {
                fiveEuro.decrease();
                amountLeft -= fiveEuro.getIncrement();
                coinStacks[8]++;
            } else if (amountLeft >= twoEuro.getIncrement() && twoEuro.hasCoins()) {
                twoEuro.decrease();
                amountLeft -= twoEuro.getIncrement();
                coinStacks[7]++;
            } else if (amountLeft >= oneEuro.getIncrement() && oneEuro.hasCoins()) {
                oneEuro.decrease();
                amountLeft -= oneEuro.getIncrement();
                coinStacks[6]++;
            } else if (amountLeft >= fiftyCent.getIncrement() && fiftyCent.hasCoins()) {
                fiftyCent.decrease();
                amountLeft -= fiftyCent.getIncrement();
                coinStacks[5]++;
            } else if (amountLeft >= twentyCent.getIncrement() && twentyCent.hasCoins()) {
                twentyCent.decrease();
                amountLeft -= twentyCent.getIncrement();
                coinStacks[4]++;
            } else if (amountLeft >= tenCent.getIncrement() && tenCent.hasCoins()) {
                tenCent.decrease();
                amountLeft -= tenCent.getIncrement();
                coinStacks[3]++;
            } else if (amountLeft >= fiveCent.getIncrement() && fiveCent.hasCoins()) {
                fiveCent.decrease();
                amountLeft -= fiveCent.getIncrement();
                coinStacks[2]++;
            } else if (amountLeft >= twoCent.getIncrement() && twoCent.hasCoins()) {
                twoCent.decrease();
                amountLeft -= twoCent.getIncrement();
                coinStacks[1]++;
            } else if (oneCent.hasCoins()) {
                oneCent.decrease();
                amountLeft -= oneCent.getIncrement();
                coinStacks[0]++;
            } else { // If the machine doesn't have enough coins to dispense

                // Refill the machine
                for (int i = 0; i < coinStacks.length; i++) {
                    while (coinStacks[i] > 0) {
                        switch (i) {
                            case 0 : oneCent.increase(); coinStacks[i]--; break;
                            case 1 : twoCent.increase(); coinStacks[i]--; break;
                            case 2 : fiveCent.increase(); coinStacks[i]--; break;
                            case 3 : tenCent.increase(); coinStacks[i]--; break;
                            case 4 : twentyCent.increase(); coinStacks[i]--; break;
                            case 5 : fiftyCent.increase(); coinStacks[i]--; break;
                            case 6 : oneEuro.increase(); coinStacks[i]--; break;
                            case 7 : twoEuro.increase(); coinStacks[i]--; break;
                            case 8 : fiveEuro.increase(); coinStacks[i]--; break;
                            case 9 : tenEuro.increase(); coinStacks[i]--; break;
                            case 10 : twentyEuro.increase(); coinStacks[i]--; break;
                            case 11 : fiftyEuro.increase(); coinStacks[i]--; break;
                            case 12 : oneHundredEuro.increase(); coinStacks[i]--; break;
                            case 13 : twoHundredEuro.increase(); coinStacks[i]--; break;
                            case 14 : fiveHundredEuro.increase(); coinStacks[i]--; break;
                        }
                    }
                }
                return null; // Withdrawal failed
            }
        }
        return coinStacks; // Withdrawal successful
    }

    // Dispense coins
    private void dispense(long[] coinStacks) {
        gui.clearDispenseArea(); // Clear the dispense area

        // Dispense the right amount of coins
        for (int i = coinStacks.length; i >= 0; i--) {
            switch (i) {
                case 0: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[0] + " x 1 Cent"); break;
                case 1: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[1] + " x 2 Cent"); break;
                case 2: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[2] + " x 5 Cent"); break;
                case 3: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[3] + " x 10 Cent"); break;
                case 4: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[4] + " x 20 Cent"); break;
                case 5: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[5] + " x 50 Cent"); break;
                case 6: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[6] + " x 1 Euro"); break;
                case 7: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[7] + " x 2 Euro"); break;
                case 8: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[8] + " x 5 Euro"); break;
                case 9: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[9] + " x 10 Euro"); break;
                case 10: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[10] + " x 20 Euro"); break;
                case 11: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[11] + " x 50 Euro"); break;
                case 12: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[12] + " x 100 Euro"); break;
                case 13: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[13] + " x 200 Euro"); break;
                case 14: if (coinStacks[i] > 0) gui.appendDispenseArea("\n     " + coinStacks[14] + " x 500 Euro"); break;
            }
        }
    }


    // Setter:

    // Refill all coin stacks
    public void refill() {
        // Refill all coin stacks to their max stack size
        for (CoinStack coinStack : coinStacks) coinStack.refill();
        updateTotalValue(); // Update the total value of all coin stacks
    }

    // Refill all coin stacks with custom values
    public void refill(long oneCentStack, long twoCentStack, long fiveCentStack, long tenCentStack, long twentyCentStack, long fiftyCentStack, long oneEuroStack, long twoEuroStack, long fiveEuroStack, long tenEuroStack, long twentyEuroStack, long fiftyEuroStack, long oneHundredEuroStack, long twoHundredEuroStack, long fiveHundredEuroStack) {

        // Check if the custom values are valid and refill the coin stacks
        if (oneCent.getStackValue() < oneCentStack && oneCentStack < oneCent.getMaxStackSize()) oneCent.setStackSize(oneCentStack);
        if (twoCent.getStackValue() < twoCentStack && twoCentStack < twoCent.getMaxStackSize()) twoCent.setStackSize(twoCentStack);
        if (fiveCent.getStackValue() < fiveCentStack && fiveCentStack < fiveCent.getMaxStackSize()) fiveCent.setStackSize(fiveCentStack);
        if (tenCent.getStackValue() < tenCentStack && tenCentStack < tenCent.getMaxStackSize()) tenCent.setStackSize(tenCentStack);
        if (twentyCent.getStackValue() < twentyCentStack && twentyCentStack < twentyCent.getMaxStackSize()) twentyCent.setStackSize(twentyCentStack);
        if (fiftyCent.getStackValue() < fiftyCentStack && fiftyCentStack < fiftyCent.getMaxStackSize()) fiftyCent.setStackSize(fiftyCentStack);
        if (oneEuro.getStackValue() < oneEuroStack && oneEuroStack < oneEuro.getMaxStackSize()) oneEuro.setStackSize(oneEuroStack);
        if (twoEuro.getStackValue() < twoEuroStack && twoEuroStack < twoEuro.getMaxStackSize()) twoEuro.setStackSize(twoEuroStack);
        if (fiveEuro.getStackValue() < fiveEuroStack && fiveEuroStack < fiveEuro.getMaxStackSize()) fiveEuro.setStackSize(fiveEuroStack);
        if (tenEuro.getStackValue() < tenEuroStack && tenEuroStack < tenEuro.getMaxStackSize()) tenEuro.setStackSize(tenEuroStack);
        if (twentyEuro.getStackValue() < twentyEuroStack && twentyEuroStack < twentyEuro.getMaxStackSize()) twentyEuro.setStackSize(twentyEuroStack);
        if (fiftyEuro.getStackValue() < fiftyEuroStack && fiftyEuroStack < fiftyEuro.getMaxStackSize()) fiftyEuro.setStackSize(fiftyEuroStack);
        if (oneHundredEuro.getStackValue() < oneHundredEuroStack && oneHundredEuroStack < oneHundredEuro.getMaxStackSize()) oneHundredEuro.setStackSize(oneHundredEuroStack);
        if (twoHundredEuro.getStackValue() < twoHundredEuroStack && twoHundredEuroStack < twoHundredEuro.getMaxStackSize()) twoHundredEuro.setStackSize(twoHundredEuroStack);
        if (fiveHundredEuro.getStackValue() < fiveHundredEuroStack && fiveHundredEuroStack < fiveHundredEuro.getMaxStackSize()) fiveHundredEuro.setStackSize(fiveHundredEuroStack);
        updateTotalValue(); // Update the total value of all coin stacks
    }

    // Handle the withdrawal of coins
    public void withdraw(double amount) {
        // Calculates the right amount of coins to dispense
        long[] coinStacks = withdrawIsPossible(amount);

        // Dispense the coins if possible
        if (coinStacks != null) dispense(coinStacks); // If possible, dispense the coins
        else gui.showErrorMessage("Not enough coins in the machine!"); // If not possible, show an error message
    }


    // Getters:

    // Getter for the Total Value
    public double getTotalValue() {
        updateTotalValue(); // Update the total value of all coin stacks
        return totalValue; // Return the total value
    }


    // Getters for the Stack Size
    public long getOneCentStackSize() {
        return oneCent.getStackSize();
    }

    public long getTwoCentStackSize() {
        return twoCent.getStackSize();
    }

    public long getFiveCentStackSize() {
        return fiveCent.getStackSize();
    }

    public long getTenCentStackSize() {
        return tenCent.getStackSize();
    }

    public long getTwentyCentStackSize() {
        return twentyCent.getStackSize();
    }

    public long getFiftyCentStackSize() {
        return fiftyCent.getStackSize();
    }

    public long getOneEuroStackSize() {
        return oneEuro.getStackSize();
    }

    public long getTwoEuroStackSize() {
        return twoEuro.getStackSize();
    }

    public long getFiveEuroStackSize() {
        return fiveEuro.getStackSize();
    }

    public long getTenEuroStackSize() {
        return tenEuro.getStackSize();
    }

    public long getTwentyEuroStackSize() {
        return twentyEuro.getStackSize();
    }

    public long getFiftyEuroStackSize() {
        return fiftyEuro.getStackSize();
    }

    public long getOneHundredEuroStackSize() {
        return oneHundredEuro.getStackSize();
    }

    public long getTwoHundredEuroStackSize() {
        return twoHundredEuro.getStackSize();
    }

    public long getFiveHundredEuroStackSize() {
        return fiveHundredEuro.getStackSize();
    }
}