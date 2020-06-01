package Services;

import Entities.Transaction;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    private Checkout checkout;

    public GUI(Checkout checkout) {
        this.checkout = checkout;
        setTitle("Checkout");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainPage());
    }

    public JPanel mainPage() {
        JPanel mainPage = new JPanel();
        mainPage.setLayout(new GridLayout(1, 2));

        JButton checkButton = new JButton("Check Transaction"),
                displayButton = new JButton("Display Transactions");

        checkButton.addActionListener(actionEvent -> {
            getContentPane().removeAll();
            getContentPane().add(checkPage());
            repaint();
            printAll(getGraphics());
        });
        displayButton.addActionListener(actionEvent -> {
            getContentPane().removeAll();
            getContentPane().add(displayPage());
            repaint();
            printAll(getGraphics());
        });

        mainPage.add(checkButton);
        mainPage.add(displayButton);

        return mainPage;
    }

    public JPanel checkPage() {
        JPanel checkPage = new JPanel();
        checkPage.setLayout(new BorderLayout());

        JButton backButton = new JButton("Back");

        backButton.addActionListener(actionEvent -> {
            getContentPane().removeAll();
            getContentPane().add(mainPage());
            repaint();
            printAll(getGraphics());
        });

        checkPage.add(new Label("Check Transactions"), BorderLayout.NORTH);
        checkPage.add(checkButtons(), BorderLayout.CENTER);
        checkPage.add(backButton, BorderLayout.SOUTH);

        return checkPage;
    }

    public JPanel checkButtons() {
        JPanel checkButtons = new JPanel();

        ArrayList<Transaction> transactions = checkout.getTransactions();
        for (int i = 0; i < transactions.size(); i ++) {
            JButton button = new JButton("Transaction " + (i + 1));

            int finalI = i;
            button.addActionListener(actionEvent -> {
                if (checkout.checkPayment(transactions.get(finalI))) {
                    JOptionPane.showMessageDialog(checkButtons, "Valid transaction");
                } else {
                    JOptionPane.showMessageDialog(checkButtons, "Invalid transaction");
                }
            });

            checkButtons.add(button);
        }

        return checkButtons;
    }

    public JPanel displayPage() {
        JPanel displayPage = new JPanel();
        displayPage.setLayout(new BorderLayout());

        JButton backButton = new JButton("Back");

        backButton.addActionListener(actionEvent -> {
            getContentPane().removeAll();
            getContentPane().add(mainPage());
            repaint();
            printAll(getGraphics());
        });

        displayPage.add(new Label("Display Transactions"), BorderLayout.NORTH);
        displayPage.add(displayButtons(), BorderLayout.CENTER);
        displayPage.add(backButton, BorderLayout.SOUTH);

        return displayPage;
    }

    public JPanel displayButtons() {
        JPanel displayButtons = new JPanel();
        displayButtons.setLayout(new GridLayout(2, 2));

        JButton cardButton = new JButton("Display Card Transactions"),
                cashButton = new JButton("Display Cash Transactions"),
                voucherButton = new JButton("Display Voucher Transactions"),
                allButton = new JButton("Display All Transactions");

        cardButton.addActionListener(actionEvent ->
                JOptionPane.showMessageDialog(displayButtons, checkout.displayCardTransactions()));
        cashButton.addActionListener(actionEvent ->
                JOptionPane.showMessageDialog(displayButtons, checkout.displayCashTransactions()));
        voucherButton.addActionListener(actionEvent ->
                JOptionPane.showMessageDialog(displayButtons, checkout.displayVoucherTransactions()));
        allButton.addActionListener(actionEvent ->
                JOptionPane.showMessageDialog(displayButtons, checkout.displayAllTransactions()));

        displayButtons.add(cardButton);
        displayButtons.add(cashButton);
        displayButtons.add(voucherButton);
        displayButtons.add(allButton);

        return displayButtons;
    }
}
