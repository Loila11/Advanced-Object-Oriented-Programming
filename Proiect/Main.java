import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Float.parseFloat;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Item> items;
        while (true){
            System.out.println("Introduceti numele fisierului:");
            try {
                items = readItems(new File(in.nextLine()));
                break;
            } catch (FileNotFoundException e) {
                System.out.println("Fisierul nu a fost gasit");
            }
        }
        items.sort(new SortByPrice());

        Checkout checkout = new Checkout(new Transaction(new Client("Marin"), items,
                new Cash(50)));
        checkout.addTransaction(new Transaction(new Client("Ana Maria"), items.get(3),
                new Card("1234567890123456", 3, 2021)));

        items.add(new DiscountItem("faina", 1));

        checkout.addTransaction(new Transaction(new Client("Ionela"), items,
                new MealVouchers(15.18, 2)));
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
