import Entities.*;
import Input.*;
import Entities.SortByPrice;
import Services.Checkout;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Client> clients = ReadClients.getInstance().clients;
        ArrayList<Card> cards = ReadCards.getInstance().cards;
        ArrayList<Item> discountItems = ReadDiscountItems.getInstance().discountItems;
        ArrayList<Item> items = ReadItems.getInstance().items;
        items.sort(new SortByPrice());

        Checkout checkout = new Checkout(new Transaction(clients.get(0), items, new Cash(50)));
        checkout.addTransaction(new Transaction(clients.get(1), items.get(3), cards.get(0)));

        items.add(discountItems.get(0));

        checkout.addTransaction(new Transaction(clients.get(2), items, new MealVouchers(15.18, 2)));
        checkout.displayTransactions();
    }
}
