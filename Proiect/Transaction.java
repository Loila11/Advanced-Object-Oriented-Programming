import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Transaction {
    private Client client;
    private HashMap<Item, Integer> items = new HashMap<>();
    private PaymentMethod paymentMethod;

//    constructors
    public Transaction(Client client, PaymentMethod paymentMethod) {
        this.client = client;
        this.paymentMethod = paymentMethod;
    }

    public Transaction(Client client, Item item, PaymentMethod paymentMethod) {
        this.client = client;
        this.addItem(item);
        this.paymentMethod = paymentMethod;
    }

    public Transaction(Client client, ArrayList<Item> items, PaymentMethod paymentMethod) {
        this.client = client;
        for (Item item : items) {
            this.addItem(item);
        }
        this.paymentMethod = paymentMethod;
    }

//    setters
    public void setClient(Client client) {
        this.client = client;
    }

    public void setItems(ArrayList<Item> items) {
        this.items.clear();
        for (Item item : items) {
            this.addItem(item);
        }
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

//    getters
    public Client getClient() {
        return client;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

//    other
    public Item getItem(String itemName) {
        for (Item item : this.items.keySet()) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    public void addItem(Item item) {
        if (this.items.containsKey(item)) {
            this.items.replace(item, this.items.get(item) + 1);
        } else {
            this.items.put(item, 1);
        }
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }
}
