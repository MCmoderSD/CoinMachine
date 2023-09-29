import Coins.Cent.*;
import Coins.Euro.OneEuro;
import Coins.Euro.TwoEuro;

import java.util.ArrayList;

public class Storage {
    private int totalValue;
    private final ArrayList<OneCent> oneCents = new ArrayList<>();
    private final ArrayList<TwoCent> twoCents = new ArrayList<>();
    private final ArrayList<FiveCent> fiveCents = new ArrayList<>();
    private final ArrayList<TenCent> tenCents = new ArrayList<>();
    private final ArrayList<TwentyCent> twentyCents = new ArrayList<>();
    private final ArrayList<FiftyCent> fiftyCents = new ArrayList<>();
    private final ArrayList<OneEuro> oneEuros = new ArrayList<>();
    private final ArrayList<TwoEuro> twoEuros = new ArrayList<>();
    private final GUI gui;


    public Storage() {
        gui = new GUI(this);
        refill();
        calculateTotalValue();
    }

    // Refill the storage with the default amount of coins
    private void refill() {
        for (int i = 0; i < 250; i++) oneCents.add(new OneCent());
        for (int i = 0; i < 125; i++) twoCents.add(new TwoCent());
        for (int i = 0; i < 60; i++) fiveCents.add(new FiveCent());
        for (int i = 0; i < 30; i++) tenCents.add(new TenCent());
        for (int i = 0; i < 20; i++) twentyCents.add(new TwentyCent());
        for (int i = 0; i < 30; i++) fiftyCents.add(new FiftyCent());
        for (int i = 0; i < 20; i++) oneEuros.add(new OneEuro());
        for (int i = 0; i < 10; i++) twoEuros.add(new TwoEuro());
        gui.updateCoinCount(this);
    }

    // Calculate the total value of all the coins in the storage
    private void calculateTotalValue() {
        totalValue = 0;
        for (OneCent oneCent : oneCents) if (oneCent != null) totalValue += oneCent.getValue();
        for (TwoCent twoCent : twoCents) if (twoCent != null) totalValue += twoCent.getValue();
        for (FiveCent fiveCent : fiveCents) if (fiveCent != null) totalValue += fiveCent.getValue();
        for (TenCent tenCent : tenCents) if (tenCent != null) totalValue += tenCent.getValue();
        for (TwentyCent twentyCent : twentyCents) if (twentyCent != null) totalValue += twentyCent.getValue();
        for (FiftyCent fiftyCent : fiftyCents) if (fiftyCent != null) totalValue += fiftyCent.getValue();
        for (OneEuro oneEuro : oneEuros) if (oneEuro != null) totalValue += oneEuro.getValue();
        for (TwoEuro twoEuro : twoEuros) if (twoEuro != null) totalValue += twoEuro.getValue();
        gui.updateCoinCount(this);
    }

    // Withdraw the specified amount of money from the storage
    public void withdrawIsValid(int amount) {
        if (amount > totalValue) {
            gui.showErrorMessage("Not enough money in the machine");
            return;
        }

        int amountLeft = amount;

        while (amountLeft > 0) {
            if (amountLeft >= 200 && !twoEuros.isEmpty()) {
                twoEuros.remove(0);
                amountLeft -= 200;
            } else if (amountLeft >= 100 && !oneEuros.isEmpty()) {
                oneEuros.remove(0);
                amountLeft -= 100;
            } else if (amountLeft >= 50 && !fiftyCents.isEmpty()) {
                fiftyCents.remove(0);
                amountLeft -= 50;
            } else if (amountLeft >= 20 && !twentyCents.isEmpty()) {
                twentyCents.remove(0);
                amountLeft -= 20;
            } else if (amountLeft >= 10 && !tenCents.isEmpty()) {
                tenCents.remove(0);
                amountLeft -= 10;
            } else if (amountLeft >= 5 && !fiveCents.isEmpty()) {
                fiveCents.remove(0);
                amountLeft -= 5;
            } else if (amountLeft >= 2 && !twoCents.isEmpty()) {
                twoCents.remove(0);
                amountLeft -= 2;
            } else if (!oneCents.isEmpty()) {
                oneCents.remove(0);
                amountLeft -= 1;
            }
        }

        calculateTotalValue();
    }

    // Refill the storage with the specified amount of coins
    public void refill(int oneCent, int twoCent, int fiveCent, int tenCent, int twentyCent, int fiftyCent, int oneEuro, int twoEuro) {
        if (oneCent > oneCents.size()) while (oneCent > oneCents.size()) oneCents.add(new OneCent());
        else if (oneCent < oneCents.size()) while (oneCent < oneCents.size()) oneCents.remove(0);

        if (twoCent > twoCents.size()) while (twoCent > twoCents.size()) twoCents.add(new TwoCent());
        else if (twoCent < twoCents.size()) while (twoCent < twoCents.size()) twoCents.remove(0);

        if (fiveCent > fiveCents.size()) while (fiveCent > fiveCents.size()) fiveCents.add(new FiveCent());
        else if (fiveCent < fiveCents.size()) while (fiveCent < fiveCents.size()) fiveCents.remove(0);

        if (tenCent > tenCents.size()) while (tenCent > tenCents.size()) tenCents.add(new TenCent());
        else if (tenCent < tenCents.size()) while (tenCent < tenCents.size()) tenCents.remove(0);

        if (twentyCent > twentyCents.size()) while (twentyCent > twentyCents.size()) twentyCents.add(new TwentyCent());
        else if (twentyCent < twentyCents.size()) while (twentyCent < twentyCents.size()) twentyCents.remove(0);

        if (fiftyCent > fiftyCents.size()) while (fiftyCent > fiftyCents.size()) fiftyCents.add(new FiftyCent());
        else if (fiftyCent < fiftyCents.size()) while (fiftyCent < fiftyCents.size()) fiftyCents.remove(0);

        if (oneEuro > oneEuros.size()) while (oneEuro > oneEuros.size()) oneEuros.add(new OneEuro());
        else if (oneEuro < oneEuros.size()) while (oneEuro < oneEuros.size()) oneEuros.remove(0);

        if (twoEuro > twoEuros.size()) while (twoEuro > twoEuros.size()) twoEuros.add(new TwoEuro());
        else if (twoEuro < twoEuros.size()) while (twoEuro < twoEuros.size()) twoEuros.remove(0);

        calculateTotalValue();
    }

    // Getters
    public String getOneCents() {
        return String.valueOf(oneCents.size());
    }
    public String getTwoCents() {
        return String.valueOf(twoCents.size());
    }
    public String getFiveCents() {
        return String.valueOf(fiveCents.size());
    }
    public String getTenCents() {
        return String.valueOf(tenCents.size());
    }
    public String getTwentyCents() {
        return String.valueOf(twentyCents.size());
    }
    public String getFiftyCents() {
        return String.valueOf(fiftyCents.size());
    }
    public String getOneEuros() {
        return String.valueOf(oneEuros.size());
    }
    public String getTwoEuros() {
        return String.valueOf(twoEuros.size());
    }
    public String getTotalValue() {
        return String.valueOf(totalValue);
    }
}
