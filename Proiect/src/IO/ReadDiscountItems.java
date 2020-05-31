package IO;

import Entities.DiscountItem;
import Entities.Item;
import Exceptions.CatchFNFE;
import Exceptions.WrongFormat;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Float.parseFloat;

public class ReadDiscountItems {
    private static ReadDiscountItems instance = null;
    public ArrayList<Item> discountItems;

    private ReadDiscountItems() {
        while (true) {
            Scanner in = new CatchFNFE("produse reduse").in;
            discountItems = new ArrayList<>();
            try {
                while (in.hasNextLine()) {
                    String[] info = in.nextLine().split(",");
                    if (info.length != 2) {
                        throw new WrongFormat();
                    }
                    discountItems.add(new DiscountItem(info[0], parseFloat(info[1])));
                }
                in.close();
                break;
            } catch (WrongFormat | IndexOutOfBoundsException | NumberFormatException wrongFormat) {
                wrongFormat.printStackTrace();
                discountItems = new ArrayList<>();
                in.close();
            }
        }
    }

    public static ReadDiscountItems getInstance() {
        if (instance == null) {
            instance = new ReadDiscountItems();
        }
        return instance;
    }
}
