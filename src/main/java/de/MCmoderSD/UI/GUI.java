package de.MCmoderSD.UI;

import de.MCmoderSD.core.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class GUI extends JFrame {
    // Constants
    private final ArrayList<JTextField> coinFields = new ArrayList<>();

    // Components
    private final JTextField oneCentField, twoCentField, fiveCentField, tenCentField, twentyCentField, fiftyCentField, oneEuroField, twoEuroField; // Coin Fields
    private final JTextField fiveEuroField, tenEuroField, twentyEuroField, fiftyEuroField, oneHundredEuroField, twoHundredEuroField, fiveHundredEuroField; // Banknote Fields
    private final JTextField totalValueField; // Total Value Field
    private final JTextArea dispenseArea; // Dispense Area

    // Constructor
    public GUI(Controller controller) {
        // JFrame
        super("Coin Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // User Side
        JPanel userSide = new JPanel();
        userSide.setLayout(null);
        userSide.setPreferredSize(new Dimension(400, 800)); // Set the size of the user side
        add(userSide, BorderLayout.EAST); // Add the user side to the right of the frame

        // Admin Side
        JPanel adminSide = new JPanel();
        adminSide.setLayout(null);
        adminSide.setPreferredSize(new Dimension(400, 800)); // Set the size of the admin side
        add(adminSide, BorderLayout.WEST); // Add the admin side to the left of the frame
        pack(); // Pack the frame to fit the components


        //User Components
        Font font = new Font("Roboto", Font.PLAIN, 18); // Font for the components
        int componentHeight = 30; // Height of the components

        // Dispense Area
        dispenseArea = new JTextArea();
        dispenseArea.setSize(Math.toIntExact(Math.round(userSide.getWidth() * 0.8)), Math.toIntExact(Math.round(userSide.getHeight() * 0.6)));
        dispenseArea.setLocation((userSide.getWidth() - dispenseArea.getWidth()) / 2, componentHeight * 2);
        dispenseArea.setFont(font);
        dispenseArea.setEditable(false);
        userSide.add(dispenseArea);

        // Withdraw Button
        JButton withdrawButton = new JButton("Withdraw");
        int buttonWidth = Math.toIntExact(Math.round(userSide.getWidth() * 0.6));
        withdrawButton.setSize(buttonWidth, 50);

        // Centering the button
        int buttonX = (userSide.getWidth() - withdrawButton.getWidth()) / 2;
        int buttonY = Math.toIntExact(Math.round((userSide.getHeight() - withdrawButton.getHeight()) * 0.8));
        withdrawButton.setLocation(buttonX, buttonY);
        withdrawButton.setFont(font);
        userSide.add(withdrawButton);

        // Amount Field
        JTextField amountField = new JTextField();
        amountField.setSize(buttonWidth, componentHeight);
        amountField.setLocation(buttonX, buttonY + 2 * amountField.getHeight());
        amountField.setFont(font);
        userSide.add(amountField);

        // Withdraw Button Action Listener
        withdrawButton.addActionListener(e -> {
            // Check if the amount field is valid
            if (withdrawIsValid(amountField)) {
                controller.withdraw(Double.parseDouble(amountField.getText())); // Withdraw the amount
                updateCoinCount(controller); // Update the coin count and total value fields
            } else showErrorMessage("Please enter a valid amount"); // Show an error message
        });


        // Admin Components

        // Index for Coins
        JLabel oneCentLabel = new JLabel("One Cent: ");
        int width = Math.toIntExact(Math.round(adminSide.getWidth() * 0.4));
        oneCentLabel.setSize(width, componentHeight);
        int x = Math.toIntExact(Math.round(width * 0.3));
        oneCentLabel.setLocation(x, 2 * oneCentLabel.getHeight());
        oneCentLabel.setFont(font);
        adminSide.add(oneCentLabel);

        oneCentField = new JTextField();
        oneCentField.setSize(width, componentHeight);
        oneCentField.setLocation(oneCentLabel.getX() + oneCentLabel.getWidth(), 2 * oneCentField.getHeight());
        oneCentField.setFont(font);
        adminSide.add(oneCentField);
        coinFields.add(oneCentField);

        JLabel twoCentLabel = new JLabel("Two Cent: ");
        twoCentLabel.setSize(width, componentHeight);
        twoCentLabel.setLocation(x, 3 * twoCentLabel.getHeight());
        twoCentLabel.setFont(font);
        adminSide.add(twoCentLabel);

        twoCentField = new JTextField();
        twoCentField.setSize(width, componentHeight);
        twoCentField.setLocation(twoCentLabel.getX() + twoCentLabel.getWidth(), 3 * twoCentField.getHeight());
        twoCentField.setFont(font);
        adminSide.add(twoCentField);
        coinFields.add(twoCentField);

        JLabel fiveCentLabel = new JLabel("Five Cent: ");
        fiveCentLabel.setSize(width, componentHeight);
        fiveCentLabel.setLocation(x, 4 * fiveCentLabel.getHeight());
        fiveCentLabel.setFont(font);
        adminSide.add(fiveCentLabel);

        fiveCentField = new JTextField();
        fiveCentField.setSize(width, componentHeight);
        fiveCentField.setLocation(fiveCentLabel.getX() + fiveCentLabel.getWidth(), 4 * fiveCentField.getHeight());
        fiveCentField.setFont(font);
        adminSide.add(fiveCentField);
        coinFields.add(fiveCentField);

        JLabel tenCentLabel = new JLabel("Ten Cent: ");
        tenCentLabel.setSize(width, componentHeight);
        tenCentLabel.setLocation(x, 5 * tenCentLabel.getHeight());
        tenCentLabel.setFont(font);
        adminSide.add(tenCentLabel);

        tenCentField = new JTextField();
        tenCentField.setSize(width, componentHeight);
        tenCentField.setLocation(tenCentLabel.getX() + tenCentLabel.getWidth(), 5 * tenCentField.getHeight());
        tenCentField.setFont(font);
        adminSide.add(tenCentField);
        coinFields.add(tenCentField);

        JLabel twentyCentLabel = new JLabel("Twenty Cent: ");
        twentyCentLabel.setSize(width, componentHeight);
        twentyCentLabel.setLocation(x, 6 * twentyCentLabel.getHeight());
        twentyCentLabel.setFont(font);
        adminSide.add(twentyCentLabel);

        twentyCentField = new JTextField();
        twentyCentField.setSize(width, componentHeight);
        twentyCentField.setLocation(twentyCentLabel.getX() + twentyCentLabel.getWidth(), 6 * twentyCentField.getHeight());
        twentyCentField.setFont(font);
        adminSide.add(twentyCentField);
        coinFields.add(twentyCentField);

        JLabel fiftyCentLabel = new JLabel("Fifty Cent: ");
        fiftyCentLabel.setSize(width, componentHeight);
        fiftyCentLabel.setLocation(x, 7 * fiftyCentLabel.getHeight());
        fiftyCentLabel.setFont(font);
        adminSide.add(fiftyCentLabel);

        fiftyCentField = new JTextField();
        fiftyCentField.setSize(width, componentHeight);
        fiftyCentField.setLocation(fiftyCentLabel.getX() + fiftyCentLabel.getWidth(), 7 * fiftyCentField.getHeight());
        fiftyCentField.setFont(font);
        adminSide.add(fiftyCentField);
        coinFields.add(fiftyCentField);

        JLabel oneEuroLabel = new JLabel("One Euro: ");
        oneEuroLabel.setSize(width, componentHeight);
        oneEuroLabel.setLocation(x, 8 * oneEuroLabel.getHeight());
        oneEuroLabel.setFont(font);
        adminSide.add(oneEuroLabel);

        oneEuroField = new JTextField();
        oneEuroField.setSize(width, componentHeight);
        oneEuroField.setLocation(oneEuroLabel.getX() + oneEuroLabel.getWidth(), 8 * oneEuroField.getHeight());
        oneEuroField.setFont(font);
        adminSide.add(oneEuroField);
        coinFields.add(oneEuroField);

        JLabel twoEuroLabel = new JLabel("Two Euro: ");
        twoEuroLabel.setSize(width, componentHeight);
        twoEuroLabel.setLocation(x, 9 * twoEuroLabel.getHeight());
        twoEuroLabel.setFont(font);
        adminSide.add(twoEuroLabel);

        twoEuroField = new JTextField();
        twoEuroField.setSize(width, componentHeight);
        twoEuroField.setLocation(twoEuroLabel.getX() + twoEuroLabel.getWidth(), 9 * twoEuroField.getHeight());
        twoEuroField.setFont(font);
        adminSide.add(twoEuroField);
        coinFields.add(twoEuroField);

        JLabel fiveEuroLabel = new JLabel("Five Euro: ");
        fiveEuroLabel.setSize(width, componentHeight);
        fiveEuroLabel.setLocation(x, 10 * fiveEuroLabel.getHeight());
        fiveEuroLabel.setFont(font);
        adminSide.add(fiveEuroLabel);

        fiveEuroField = new JTextField();
        fiveEuroField.setSize(width, componentHeight);
        fiveEuroField.setLocation(fiveEuroLabel.getX() + fiveEuroLabel.getWidth(), 10 * fiveEuroField.getHeight());
        fiveEuroField.setFont(font);
        adminSide.add(fiveEuroField);
        coinFields.add(fiveEuroField);

        JLabel tenEuroLabel = new JLabel("Ten Euro: ");
        tenEuroLabel.setSize(width, componentHeight);
        tenEuroLabel.setLocation(x, 11 * tenEuroLabel.getHeight());
        tenEuroLabel.setFont(font);
        adminSide.add(tenEuroLabel);

        tenEuroField = new JTextField();
        tenEuroField.setSize(width, componentHeight);
        tenEuroField.setLocation(tenEuroLabel.getX() + tenEuroLabel.getWidth(), 11 * tenEuroField.getHeight());
        tenEuroField.setFont(font);
        adminSide.add(tenEuroField);
        coinFields.add(tenEuroField);

        JLabel twentyEuroLabel = new JLabel("Twenty Euro: ");
        twentyEuroLabel.setSize(width, componentHeight);
        twentyEuroLabel.setLocation(x, 12 * twentyEuroLabel.getHeight());
        twentyEuroLabel.setFont(font);
        adminSide.add(twentyEuroLabel);

        twentyEuroField = new JTextField();
        twentyEuroField.setSize(width, componentHeight);
        twentyEuroField.setLocation(twentyEuroLabel.getX() + twentyEuroLabel.getWidth(), 12 * twentyEuroField.getHeight());
        twentyEuroField.setFont(font);
        adminSide.add(twentyEuroField);
        coinFields.add(twentyEuroField);

        JLabel fiftyEuroLabel = new JLabel("Fifty Euro: ");
        fiftyEuroLabel.setSize(width, componentHeight);
        fiftyEuroLabel.setLocation(x, 13 * fiftyEuroLabel.getHeight());
        fiftyEuroLabel.setFont(font);
        adminSide.add(fiftyEuroLabel);

        fiftyEuroField = new JTextField();
        fiftyEuroField.setSize(width, componentHeight);
        fiftyEuroField.setLocation(fiftyEuroLabel.getX() + fiftyEuroLabel.getWidth(), 13 * fiftyEuroField.getHeight());
        fiftyEuroField.setFont(font);
        adminSide.add(fiftyEuroField);
        coinFields.add(fiftyEuroField);

        JLabel oneHundredEuroLabel = new JLabel("One Hundred Euro: ");
        oneHundredEuroLabel.setSize(width, componentHeight);
        oneHundredEuroLabel.setLocation(x, 14 * oneHundredEuroLabel.getHeight());
        oneHundredEuroLabel.setFont(font);
        adminSide.add(oneHundredEuroLabel);

        oneHundredEuroField = new JTextField();
        oneHundredEuroField.setSize(width, componentHeight);
        oneHundredEuroField.setLocation(oneHundredEuroLabel.getX() + oneHundredEuroLabel.getWidth(), 14 * oneHundredEuroField.getHeight());
        oneHundredEuroField.setFont(font);
        adminSide.add(oneHundredEuroField);
        coinFields.add(oneHundredEuroField);

        JLabel twoHundredEuroLabel = new JLabel("Two Hundred Euro: ");
        twoHundredEuroLabel.setSize(width, componentHeight);
        twoHundredEuroLabel.setLocation(x, 15 * twoHundredEuroLabel.getHeight());
        twoHundredEuroLabel.setFont(font);
        adminSide.add(twoHundredEuroLabel);

        twoHundredEuroField = new JTextField();
        twoHundredEuroField.setSize(width, componentHeight);
        twoHundredEuroField.setLocation(twoHundredEuroLabel.getX() + twoHundredEuroLabel.getWidth(), 15 * twoHundredEuroField.getHeight());
        twoHundredEuroField.setFont(font);
        adminSide.add(twoHundredEuroField);
        coinFields.add(twoHundredEuroField);

        JLabel fiveHundredEuroLabel = new JLabel("Five Hundred Euro: ");
        fiveHundredEuroLabel.setSize(width, componentHeight);
        fiveHundredEuroLabel.setLocation(x, 16 * fiveHundredEuroLabel.getHeight());
        fiveHundredEuroLabel.setFont(font);
        adminSide.add(fiveHundredEuroLabel);

        fiveHundredEuroField = new JTextField();
        fiveHundredEuroField.setSize(width, componentHeight);
        fiveHundredEuroField.setLocation(fiveHundredEuroLabel.getX() + fiveHundredEuroLabel.getWidth(), 16 * fiveHundredEuroField.getHeight());
        fiveHundredEuroField.setFont(font);
        adminSide.add(fiveHundredEuroField);
        coinFields.add(fiveHundredEuroField);

        // Total Value
        JLabel totalValueLabel = new JLabel("Total Value: ");
        totalValueLabel.setSize(width, componentHeight);
        totalValueLabel.setLocation(x, 17 * totalValueLabel.getHeight());
        totalValueLabel.setFont(font);
        adminSide.add(totalValueLabel);

        totalValueField = new JTextField();
        totalValueField.setSize(width, componentHeight);
        totalValueField.setLocation(totalValueLabel.getX() + totalValueLabel.getWidth(), 17 * totalValueField.getHeight());
        totalValueField.setFont(font);
        adminSide.add(totalValueField);
        coinFields.add(totalValueField);


        // Refill Button
        JButton refillButton = new JButton("Refill");
        refillButton.setSize(buttonWidth, 50);
        refillButton.setLocation(buttonX, buttonY);
        refillButton.setFont(font);

        // Refill Button Action Listener
        refillButton.addActionListener(e -> {
            // Check if all the fields are filled
            if (!refillIsValid()) showErrorMessage("Please fill all the fields");
            else { // Refill the machine
                controller.refill(
                        /*
                        Long.parseLong(oneCentField.getText()),
                        Long.parseLong(twoCentField.getText()),
                        Long.parseLong(fiveCentField.getText()),
                        Long.parseLong(tenCentField.getText()),
                        Long.parseLong(twentyCentField.getText()),
                        Long.parseLong(fiftyCentField.getText()),
                        Long.parseLong(oneEuroField.getText()),
                        Long.parseLong(twoEuroField.getText()),
                        Long.parseLong(fiveEuroField.getText()),
                        Long.parseLong(tenEuroField.getText()),
                        Long.parseLong(twentyEuroField.getText()),
                        Long.parseLong(fiftyEuroField.getText()),
                        Long.parseLong(oneHundredEuroField.getText()),
                        Long.parseLong(twoHundredEuroField.getText()),
                        Long.parseLong(fiveHundredEuroField.getText())
                         */
                );
                updateCoinCount(controller); // Update the coin count and total value fields
            }
        });

        adminSide.add(refillButton);


        // Update the coin count and total value fields
        updateCoinCount(controller);


        // Centering the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
        setVisible(true);


        // Restrict Inputs

        // Only allows integers to be typed in the coin fields
        for (JTextField coinField : coinFields) coinField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                convertToNumberField(e, false);
            }
        });

        // Only allows floats to be typed in the amount field
        amountField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                convertToNumberField(e, true);
            }
        });

        // Restrict all inputs
        coinFields.add(totalValueField);
        for (JTextField coinField : coinFields) coinField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                e.consume(); // Consume the key event
            }

            @Override
            public void keyTyped(KeyEvent e) {
                e.consume(); // Consume the key event
            }
        });

        // Restrict all inputs
        dispenseArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                e.consume(); // Consume the key event
            }

            @Override
            public void keyTyped(KeyEvent e) {
                e.consume(); // Consume the key event
            }
        });
    }

    // Methods

    // Forces the text field to only accept numbers
    private void convertToNumberField (KeyEvent evt, boolean floatsAllowed) {
        // Variables
        char c = evt.getKeyChar(); // The character typed
        boolean b; // Boolean to check if the character is valid

        // Check if the character is valid
        if (floatsAllowed) { // If floats are allowed
            b = !(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == '.' || c == ',');
            if (b) evt.consume(); // Consume the key event
            else if (c == ',') evt.setKeyChar('.');
        } else {
            b = !(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE);
            if (b) evt.consume(); // Consume the key event
        }
    }

    // Checks if all the withdraw field input is valid
    private boolean withdrawIsValid(JTextField amountField) {
        // Check if the amount field is empty
        String input = amountField.getText();
        if (input.isEmpty()) return false;

        // Check if the amount field is a valid number
        try {
            // Try to parse the input to a double
            double amount = Double.parseDouble(input);

            // Check if the number has at most two decimal places
            String[] parts = input.split("\\.");
            if (parts.length > 1) {
                String decimalPart = parts[1];
                return decimalPart.length() <= 2; // More than two decimal places
            }

            return !(amount < 0); // Check for negative number

        } catch (NumberFormatException e) {
            return false; // Not a valid number
        }
    }


    // Checks if all the refill fields are filled
    private boolean refillIsValid() {
        for (JTextField coinField : coinFields) if (coinField.getText().isEmpty()) return false;
        return true;
    }


    // Setters:

    // Updates the coin count and total value fields
    public void updateCoinCount(Controller controller) {
        oneCentField.setText(String.valueOf(controller.getOneCentStackSize()));
        twoCentField.setText(String.valueOf(controller.getTwoCentStackSize()));
        fiveCentField.setText(String.valueOf(controller.getFiveCentStackSize()));
        tenCentField.setText(String.valueOf(controller.getTenCentStackSize()));
        twentyCentField.setText(String.valueOf(controller.getTwentyCentStackSize()));
        fiftyCentField.setText(String.valueOf(controller.getFiftyCentStackSize()));
        oneEuroField.setText(String.valueOf(controller.getOneEuroStackSize()));
        twoEuroField.setText(String.valueOf(controller.getTwoEuroStackSize()));
        fiveEuroField.setText(String.valueOf(controller.getFiveEuroStackSize()));
        tenEuroField.setText(String.valueOf(controller.getTenEuroStackSize()));
        twentyEuroField.setText(String.valueOf(controller.getTwentyEuroStackSize()));
        fiftyEuroField.setText(String.valueOf(controller.getFiftyEuroStackSize()));
        oneHundredEuroField.setText(String.valueOf(controller.getOneHundredEuroStackSize()));
        twoHundredEuroField.setText(String.valueOf(controller.getTwoHundredEuroStackSize()));
        fiveHundredEuroField.setText(String.valueOf(controller.getFiveHundredEuroStackSize()));

        // Make sure the total value is rounded to two decimal places
        BigDecimal totalValue = BigDecimal.valueOf(controller.getTotalValue());
        totalValue = totalValue.setScale(2, RoundingMode.HALF_UP);
        totalValueField.setText(totalValue.toString());
    }

    // Appends the dispense area
    public void appendDispenseArea(String s) {
        dispenseArea.append(s);
    }

    // Clears the dispense area
    public void clearDispenseArea() {
        dispenseArea.setText("");
    }

    // Shows an error message
    public void showErrorMessage(String s) {
        JOptionPane.showMessageDialog(this, s, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
