package Services;

import Entities.Item;
import Entities.Transaction;

import java.util.ArrayList;
import java.util.Map;

public class Checkout {
    private ArrayList<Transaction> transactions;

//    constructors
    public Checkout() {
        this.transactions = new ArrayList<Transaction>();
    }

    public Checkout(Transaction transaction) {
        this.transactions = new ArrayList<Transaction>();
        this.transactions.add(transaction);
    }

    public Checkout(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

//    setter
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

//    getter
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

//    other
    public void addTransaction(Transaction transaction) {
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());

        this.transactions.add(transaction);
    }

    public double calcTotalPrice(Transaction transaction) {
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());

        double price = 0;
        for (Map.Entry<Item, Integer> entry : transaction.getItems().entrySet()) {
            Integer noItems = entry.getValue();
            Item item = entry.getKey();
            price += item.getPrice() * noItems;
        }
        return price;
    }

    public boolean checkPayment(Transaction transaction) {
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());

        return transaction.getPaymentMethod().checkPaymentMethod(calcTotalPrice(transaction));
    }

//    displays
    public String displayItems(Transaction transaction) {
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());

        StringBuilder t = new StringBuilder();
        for (Map.Entry<Item, Integer> entry : transaction.getItems().entrySet()) {
            Integer noItems = entry.getValue();
            Item item = entry.getKey();
            t.append(noItems).append(" * ").append(item.getName()).append(' ').append(item.getPrice()).append('\n');
        }

        return String.valueOf(t);
    }

    public String displayTransaction(Transaction transaction) {
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());

        return transaction.getClient().getFirstName() + " " + transaction.getClient().getLastName() + "\n" +
                "Payment: " + transaction.getPaymentMethod().getPaymentMethod() + "\n" +
                displayItems(transaction) + "\n" +
                "Total: " + calcTotalPrice(transaction) + "\n" +
                "-----------------";
    }

    public String displayAllTransactions() {
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());

        StringBuilder t = new StringBuilder();
        for (Transaction transaction : this.transactions) {
            t.append(displayTransaction(transaction)).append('\n');
        }
        return String.valueOf(t);
    }

    public String displayCardTransactions() {
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());

        StringBuilder t = new StringBuilder();
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Card")) {
                t.append(displayTransaction(transaction)).append('\n');
            }
        }
        return String.valueOf(t);
    }

    public String displayCashTransactions() {
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());

        StringBuilder t = new StringBuilder();
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Cash")) {
                t.append(displayTransaction(transaction)).append('\n');
            }
        }
        return String.valueOf(t);
    }

    public String displayVoucherTransactions() {
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());

        StringBuilder t = new StringBuilder();
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Meal Vouchers")) {
                t.append(displayTransaction(transaction)).append('\n');
            }
        }
        return String.valueOf(t);
    }
}
