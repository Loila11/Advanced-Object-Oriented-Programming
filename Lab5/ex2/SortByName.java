package ex2;

import java.util.Comparator;

public class SortByName implements Comparator<Album> {

    @Override
    public int compare(Album a, Album b) {
        return a.nume.compareTo(b.nume);
    }
}
