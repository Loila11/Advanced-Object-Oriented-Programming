import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Float.parseFloat;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Item> items = readItems(new File("C:\\Users\\mirun\\Facultate\\PAO\\Proiect\\src\\produse.txt"));
        items.sort(new SortByPrice());

        Checkout checkout = new Checkout(new Transaction(new Client("Marin"), items,
                new Cash(50)));
        checkout.addTransaction(new Transaction(new Client("Ana Maria"), items.get(3),
                new Card("1234567890123456", 3, 2021)));
        checkout.displayTransactions();
    }

    public static ArrayList<Item> readItems(File path) throws FileNotFoundException {
        Scanner in = new Scanner(path);
        ArrayList<Item> items = new ArrayList<Item>();
        while (in.hasNextLine()) {
            String[] info = in.nextLine().split("\\s+");
            items.add(new Item(info[0], parseFloat(info[1])));
        }

        in.close();
        return items;
    }
}
