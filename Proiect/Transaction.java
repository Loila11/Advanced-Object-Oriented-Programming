import java.util.ArrayList;

public class Transaction {
    private Client client;
    private ArrayList<Item> items;
    private PaymentMethod paymentMethod;

//    constructors
    public Transaction(Client client, PaymentMethod paymentMethod) {
        this.client = client;
        this.items = new ArrayList<>();
        this.paymentMethod = paymentMethod;
    }

    public Transaction(Client client, Item item, PaymentMethod paymentMethod) {
        this.client = client;
        this.items = new ArrayList<>();
        this.items.add(item);
        this.paymentMethod = paymentMethod;
    }

    public Transaction(Client client, ArrayList<Item> items, PaymentMethod paymentMethod) {
        this.client = client;
        this.items = new ArrayList<>(items);
        this.paymentMethod = paymentMethod;
    }

//    setters
    public void setClient(Client client) {
        this.client = client;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

//    getters
    public Client getClient() {
        return client;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

//    other
    public Item getItem(String itemName) {
        for (Item item : this.items) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void addItem(Item item) {
        if (this.items == null) {
            this.items = new ArrayList<Item>();
        }
        this.items.add(item);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public void displayItems() {
        for (Item item : this.items) {
            item.displayItem();
        }
    }

    public int calcTotalPrice() {
        int price = 0;
        for (Item item : this.items) {
            price += item.getPrice();
        }
        return price;
    }

    public void displayTransaction() {
        System.out.println(client.getName() + "\nPayment: " + paymentMethod.getPaymentMethod());
        displayItems();
        System.out.println("-----------------");
    }

    public boolean checkPayment() {
        return paymentMethod.checkPaymentMethod(calcTotalPrice());
    }
}
