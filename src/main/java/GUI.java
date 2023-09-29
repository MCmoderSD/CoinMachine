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
    private final JTextField totalValueField;

    public GUI(Storage storage) {
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

        JButton withdrawButton = new JButton("Withdraw");
        int buttonWidth = Math.toIntExact(Math.round(userSide.getWidth() * 0.6));
        withdrawButton.setSize(buttonWidth, 50);

        int buttonX = (userSide.getWidth() - withdrawButton.getWidth()) / 2;
        int buttonY = Math.toIntExact(Math.round((userSide.getHeight() - withdrawButton.getHeight()) * 0.8));
        withdrawButton.setLocation(buttonX, buttonY);
        withdrawButton.setFont(font);
        userSide.add(withdrawButton);

        JTextField amountField = new JTextField();
        amountField.setSize(buttonWidth, 50);
        amountField.setLocation(buttonX, buttonY + 2 * amountField.getHeight());
        amountField.setFont(font);
        userSide.add(amountField);
        coinFields.add(amountField);

        withdrawButton.addActionListener(e -> {
            if (amountField.getText().isEmpty()) showErrorMessage("Please enter an amount");
            else {
                storage.withdrawIsValid(Integer.parseInt(amountField.getText()));
                updateCoinCount(storage);
            }
        });


        // Admin Components

        // Index for Coins
        JLabel oneCentLabel = new JLabel("One Cent: ");
        int width = Math.toIntExact(Math.round(adminSide.getWidth() * 0.3));
        oneCentLabel.setSize(width, 50);
        int x = Math.toIntExact(Math.round(width * 0.3));
        oneCentLabel.setLocation(x, 2 * oneCentLabel.getHeight());
        oneCentLabel.setFont(font);
        adminSide.add(oneCentLabel);

        oneCentField = new JTextField();
        oneCentField.setSize(width, 50);
        oneCentField.setLocation(oneCentLabel.getX() + oneCentLabel.getWidth(), 2 * oneCentField.getHeight());
        oneCentField.setFont(font);
        adminSide.add(oneCentField);
        coinFields.add(oneCentField);

        JLabel twoCentLabel = new JLabel("Two Cent: ");
        twoCentLabel.setSize(width, 50);
        twoCentLabel.setLocation(x, 3 * twoCentLabel.getHeight());
        twoCentLabel.setFont(font);
        adminSide.add(twoCentLabel);

        twoCentField = new JTextField();
        twoCentField.setSize(width, 50);
        twoCentField.setLocation(twoCentLabel.getX() + twoCentLabel.getWidth(), 3 * twoCentField.getHeight());
        twoCentField.setFont(font);
        adminSide.add(twoCentField);
        coinFields.add(twoCentField);

        JLabel fiveCentLabel = new JLabel("Five Cent: ");
        fiveCentLabel.setSize(width, 50);
        fiveCentLabel.setLocation(x, 4 * fiveCentLabel.getHeight());
        fiveCentLabel.setFont(font);
        adminSide.add(fiveCentLabel);

        fiveCentField = new JTextField();
        fiveCentField.setSize(width, 50);
        fiveCentField.setLocation(fiveCentLabel.getX() + fiveCentLabel.getWidth(), 4 * fiveCentField.getHeight());
        fiveCentField.setFont(font);
        adminSide.add(fiveCentField);
        coinFields.add(fiveCentField);

        JLabel tenCentLabel = new JLabel("Ten Cent: ");
        tenCentLabel.setSize(width, 50);
        tenCentLabel.setLocation(x, 5 * tenCentLabel.getHeight());
        tenCentLabel.setFont(font);
        adminSide.add(tenCentLabel);

        tenCentField = new JTextField();
        tenCentField.setSize(width, 50);
        tenCentField.setLocation(tenCentLabel.getX() + tenCentLabel.getWidth(), 5 * tenCentField.getHeight());
        tenCentField.setFont(font);
        adminSide.add(tenCentField);
        coinFields.add(tenCentField);

        JLabel twentyCentLabel = new JLabel("Twenty Cent: ");
        twentyCentLabel.setSize(width, 50);
        twentyCentLabel.setLocation(x, 6 * twentyCentLabel.getHeight());
        twentyCentLabel.setFont(font);
        adminSide.add(twentyCentLabel);

        twentyCentField = new JTextField();
        twentyCentField.setSize(width, 50);
        twentyCentField.setLocation(twentyCentLabel.getX() + twentyCentLabel.getWidth(), 6 * twentyCentField.getHeight());
        twentyCentField.setFont(font);
        adminSide.add(twentyCentField);
        coinFields.add(twentyCentField);

        JLabel fiftyCentLabel = new JLabel("Fifty Cent: ");
        fiftyCentLabel.setSize(width, 50);
        fiftyCentLabel.setLocation(x, 7 * fiftyCentLabel.getHeight());
        fiftyCentLabel.setFont(font);
        adminSide.add(fiftyCentLabel);

        fiftyCentField = new JTextField();
        fiftyCentField.setSize(width, 50);
        fiftyCentField.setLocation(fiftyCentLabel.getX() + fiftyCentLabel.getWidth(), 7 * fiftyCentField.getHeight());
        fiftyCentField.setFont(font);
        adminSide.add(fiftyCentField);
        coinFields.add(fiftyCentField);

        JLabel oneEuroLabel = new JLabel("One Euro: ");
        oneEuroLabel.setSize(width, 50);
        oneEuroLabel.setLocation(x, 8 * oneEuroLabel.getHeight());
        oneEuroLabel.setFont(font);
        adminSide.add(oneEuroLabel);

        oneEuroField = new JTextField();
        oneEuroField.setSize(width, 50);
        oneEuroField.setLocation(oneEuroLabel.getX() + oneEuroLabel.getWidth(), 8 * oneEuroField.getHeight());
        oneEuroField.setFont(font);
        adminSide.add(oneEuroField);
        coinFields.add(oneEuroField);

        JLabel twoEuroLabel = new JLabel("Two Euro: ");
        twoEuroLabel.setSize(width, 50);
        twoEuroLabel.setLocation(x, 9 * twoEuroLabel.getHeight());
        twoEuroLabel.setFont(font);
        adminSide.add(twoEuroLabel);

        twoEuroField = new JTextField();
        twoEuroField.setSize(width, 50);
        twoEuroField.setLocation(twoEuroLabel.getX() + twoEuroLabel.getWidth(), 9 * twoEuroField.getHeight());
        twoEuroField.setFont(font);
        adminSide.add(twoEuroField);
        coinFields.add(twoEuroField);


        // Refill Button
        JButton refillButton = new JButton("Refill");
        refillButton.setSize(buttonWidth, 50);
        refillButton.setLocation(buttonX, buttonY);
        refillButton.setFont(font);
        refillButton.addActionListener(e -> {
            if (!refillIsValid()) {
                showErrorMessage("Please fill all the fields");
            } else {
                storage.refill(
                        Integer.parseInt(oneCentField.getText()),
                        Integer.parseInt(twoCentField.getText()),
                        Integer.parseInt(fiveCentField.getText()),
                        Integer.parseInt(tenCentField.getText()),
                        Integer.parseInt(twentyCentField.getText()),
                        Integer.parseInt(fiftyCentField.getText()),
                        Integer.parseInt(oneEuroField.getText()),
                        Integer.parseInt(twoEuroField.getText())
                );
                updateCoinCount(storage);
            }
        });

        JLabel totalValueLabel = new JLabel("Total Value: ");
        totalValueLabel.setSize(width, 50);
        totalValueLabel.setLocation(x, 10 * totalValueLabel.getHeight());
        totalValueLabel.setFont(font);
        adminSide.add(totalValueLabel);
        adminSide.add(refillButton);

        totalValueField = new JTextField();
        totalValueField.setSize(width, 50);
        totalValueField.setLocation(totalValueLabel.getX() + totalValueLabel.getWidth(), 10 * totalValueField.getHeight());
        totalValueField.setFont(font);
        adminSide.add(totalValueField);


        updateCoinCount(storage);


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
    public void updateCoinCount(Storage storage) {
        oneCentField.setText(storage.getOneCents());
        twoCentField.setText(storage.getTwoCents());
        fiveCentField.setText(storage.getFiveCents());
        tenCentField.setText(storage.getTenCents());
        twentyCentField.setText(storage.getTwentyCents());
        fiftyCentField.setText(storage.getFiftyCents());
        oneEuroField.setText(storage.getOneEuros());
        twoEuroField.setText(storage.getTwoEuros());
        totalValueField.setText(storage.getTotalValue());
    }

    // Shows an error message
    public void showErrorMessage(String s) {
        JOptionPane.showMessageDialog(this, s, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
