package IO;

import Entities.Item;
import Exceptions.CatchFNFE;
import Exceptions.WrongFormat;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Float.parseFloat;

public class ReadItems {
    private static ReadItems instance = null;
    public ArrayList<Item> items;

    private ReadItems() {
        while (true) {
            Scanner in = new CatchFNFE("produse").in;
            items = new ArrayList<>();
            try {
                while (in.hasNextLine()) {
                    String[] info = in.nextLine().split(",");
                    if (info.length != 2) {
                        throw new WrongFormat();
                    }
                    items.add(new Item(info[0], parseFloat(info[1])));
                }
                in.close();
                break;
            } catch (WrongFormat | IndexOutOfBoundsException | NumberFormatException wrongFormat) {
                wrongFormat.printStackTrace();
                items = new ArrayList<>();
                in.close();
            }
        }
    }

    public static ReadItems getInstance() {
        if (instance == null) {
            instance = new ReadItems();
        }
        return instance;
    }
}
