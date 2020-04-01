import java.util.Comparator;

public class SortByPrice implements Comparator<Item> {
    @Override
    public int compare(Item item1, Item item2) {
        if (item1.price == item2.price) {
            return item1.name.compareTo(item2.name);
        }
        if (item1.price > item2.price) {
            return 1;
        }
        return -1;
    }
}
