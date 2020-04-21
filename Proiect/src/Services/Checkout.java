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
        this.transactions.add(transaction);
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public double calcTotalPrice(Transaction transaction) {
        double price = 0;
        for (Map.Entry<Item, Integer> entry : transaction.getItems().entrySet()) {
            Integer noItems = entry.getValue();
            Item item = entry.getKey();
            price += item.getPrice() * noItems;
        }
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());
        return price;
    }

    public boolean checkPayment(Transaction transaction) {
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());
        return transaction.getPaymentMethod().checkPaymentMethod(calcTotalPrice(transaction));
    }

//    displays
    public void displayItems(Transaction transaction) {
        for (Map.Entry<Item, Integer> entry : transaction.getItems().entrySet()) {
            Integer noItems = entry.getValue();
            Item item = entry.getKey();
            System.out.println(noItems + " * " + item.getName() + ' ' + item.getPrice());
        }
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void displayTransaction(Transaction transaction) {
        System.out.println(transaction.getClient().getFirstName() + " " + transaction.getClient().getLastName() +
                "\nPayment: " + transaction.getPaymentMethod().getPaymentMethod());
        displayItems(transaction);
        System.out.println("Total: " + calcTotalPrice(transaction));
        System.out.println("-----------------");
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void displayTransactions() {
        for (Transaction transaction : this.transactions) {
            displayTransaction(transaction);
        }
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void displayCardTransactions() {
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Entities.Card")) {
                displayTransaction(transaction);
            }
        }
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void displayCashTransactions() {
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Entities.Cash")) {
                displayTransaction(transaction);
            }
        }
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    public void displayVoucherTransactions() {
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Bonuri de masa")) {
                displayTransaction(transaction);
            }
        }
        new Audit(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
