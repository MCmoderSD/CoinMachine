import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class GUI extends JFrame {
    private final ArrayList<JTextField> coinFields = new ArrayList<>();
    private final JTextField oneCentField;
    private final JTextField twoCentField;
    private final JTextField fiveCentField;
    private final JTextField tenCentField;
    private final JTextField twentyCentField;
    private final JTextField fiftyCentField;
    private final JTextField oneEuroField;
    private final JTextField twoEuroField;
    private final JTextField fiveEuroField;
    private final JTextField tenEuroField;
    private final JTextField twentyEuroField;
    private final JTextField fiftyEuroField;
    private final JTextField oneHundredEuroField;
    private final JTextField twoHundredEuroField;
    private final JTextField fiveHundredEuroField;
    private final JTextField totalValueField;

    public GUI(Controller controller) {
        super("Coin Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // User Side
        JPanel userSide = new JPanel();
        userSide.setLayout(null);
        userSide.setPreferredSize(new Dimension(400, 800));
        add(userSide, BorderLayout.EAST);

        // Admin Side
        JPanel adminSide = new JPanel();
        adminSide.setLayout(null);
        adminSide.setPreferredSize(new Dimension(400, 800));
        add(adminSide, BorderLayout.WEST);
        pack();


        //User Components
        Font font = new Font("Roboto", Font.PLAIN, 18);
        int componentHeight = 30;

        JButton withdrawButton = new JButton("Withdraw");
        int buttonWidth = Math.toIntExact(Math.round(userSide.getWidth() * 0.6));
        withdrawButton.setSize(buttonWidth, 50);

        int buttonX = (userSide.getWidth() - withdrawButton.getWidth()) / 2;
        int buttonY = Math.toIntExact(Math.round((userSide.getHeight() - withdrawButton.getHeight()) * 0.8));
        withdrawButton.setLocation(buttonX, buttonY);
        withdrawButton.setFont(font);
        userSide.add(withdrawButton);

        JTextField amountField = new JTextField();
        amountField.setSize(buttonWidth, componentHeight);
        amountField.setLocation(buttonX, buttonY + 2 * amountField.getHeight());
        amountField.setFont(font);
        userSide.add(amountField);
        coinFields.add(amountField);

        withdrawButton.addActionListener(e -> {
            if (amountField.getText().isEmpty()) showErrorMessage("Please enter an amount");
            else {
                controller.withdraw(Integer.parseInt(amountField.getText()));
                updateCoinCount(controller);
            }
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
        refillButton.addActionListener(e -> {
            if (!refillIsValid()) {
                showErrorMessage("Please fill all the fields");
            } else {
                controller.refill(
                        /*Integer.parseInt(oneCentField.getText()),
                        Integer.parseInt(twoCentField.getText()),
                        Integer.parseInt(fiveCentField.getText()),
                        Integer.parseInt(tenCentField.getText()),
                        Integer.parseInt(twentyCentField.getText()),
                        Integer.parseInt(fiftyCentField.getText()),
                        Integer.parseInt(oneEuroField.getText()),
                        Integer.parseInt(twoEuroField.getText())
                         */
                );
                updateCoinCount(controller);
            }
        });

        adminSide.add(refillButton);


        updateCoinCount(controller);


        // Centering the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((screenSize.width - getWidth()) / 2, (screenSize.height - getHeight()) / 2);
        setVisible(true);


        // Text Fields Input Correction


        totalValueField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                e.consume();
            }

            @Override
            public void keyTyped(KeyEvent e) {
                e.consume();
            }
        });


        for (JTextField coinField : coinFields) coinField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                integerInput(e);
            }
        });

        coinFields.remove(amountField);

        for (JTextField coinField : coinFields) coinField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                e.consume();
            }

            @Override
            public void keyTyped(KeyEvent e) {
                e.consume();
            }
        });
    }

    // Only allows integers to be typed in the text fields
    private void integerInput(KeyEvent evt) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) evt.consume();
    }

    // Checks if all the refill fields are filled
    private boolean refillIsValid() {
        for (JTextField coinField : coinFields) {
            if (coinField.getText().isEmpty()) return false;
        }
        return true;
    }

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
        totalValueField.setText(String.valueOf(controller.getTotalValue()));
    }

    // Shows an error message
    public void showErrorMessage(String s) {
        JOptionPane.showMessageDialog(this, s, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
