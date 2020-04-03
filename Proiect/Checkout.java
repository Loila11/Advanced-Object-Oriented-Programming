import java.util.ArrayList;

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

    public void displayTransactions() {
        for (Transaction transaction : this.transactions) {
            transaction.displayTransaction();
        }
    }

    public void displayCardTransactions() {
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Card")) {
                transaction.displayTransaction();
            }
        }
    }

    public void displayCashTransactions() {
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Cash")) {
                transaction.displayTransaction();
            }
        }
    }

    public void displayVoucherTransactions() {
        for (Transaction transaction : this.transactions) {
            if (transaction.getPaymentMethod().getPaymentMethod().equals("Bonuri de masa")) {
                transaction.displayTransaction();
            }
        }
    }
}
