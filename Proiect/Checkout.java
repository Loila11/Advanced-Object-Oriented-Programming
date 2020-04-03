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
    }

    public double calcTotalPrice(Transaction transaction) {
        double price = 0;
        for (Map.Entry<Item, Integer> entry : transaction.getItems().entrySet()) {
            Integer noItems = entry.getValue();
            Item item = entry.getKey();
            price += item.getPrice() * noItems;
        }
        return price;
    }

    public boolean checkPayment(Transaction transaction) {
        return transaction.getPaymentMethod().checkPaymentMethod(calcTotalPrice(transaction));
    }

//    displays
    public void displayItems(Transaction transaction) {
        for (Map.Entry<Item, Integer> entry : transaction.getItems().entrySet()) {
            Integer noItems = entry.getValue();
            Item item = entry.getKey();
            System.out.println(noItems + " * " + item.getName() + ' ' + item.getPrice());
        }
    }

    public void displayTransaction(Transaction transaction) {
        System.out.println(transaction.getClient().getName() + "\nPayment: " +
                transaction.getPaymentMethod().getPaymentMethod());
        displayItems(transaction);
        System.out.println("Total: " + calcTotalPrice(transaction));
        System.out.println("-----------------");
    }

    public void displayTransactions() {
        for (Transaction transaction : this.transactions) {
            displayTransaction(transaction);
        }
    }

    public void displayCardTransactions() {
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Card")) {
                displayTransaction(transaction);
            }
        }
    }

    public void displayCashTransactions() {
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Cash")) {
                displayTransaction(transaction);
            }
        }
    }

    public void displayVoucherTransactions() {
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Bonuri de masa")) {
                displayTransaction(transaction);
            }
        }
    }
}
