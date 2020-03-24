package ex2;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<Album> album = createAlbum();
        System.out.println("Colectia inainte de sortare:");
        print(album);

        album.sort(new SortByName());
        System.out.println("\nColectia sortata dupa nume:");
        print(album);

        Collections.sort(album);
        System.out.println("\nColectia sortata dupa rating:");
        print(album);
    }

    public static void print(ArrayList<Album> album) {
        for (int i = 0; i < album.size(); i ++) {
            System.out.println(album.get(i).getNume() + ' ' +
                    album.get(i).getAnulPublicarii() + ' ' +
                    album.get(i).getRating());
        }
    }

    public static ArrayList<Album> createAlbum() {
        ArrayList<Album> album = new ArrayList<Album>();
        album.add(new Album());
        album.add(new Album("Golden lining"));
        album.add(new Album("Missed the boat", 2018));
        album.add(new Album("Chaos", 2006, 5));
        album.add(new Album("Ice cold"));
        album.get(4).setRating(8);
        album.add(new Album());
        album.get(5).setRating(6);
        album.add(new Album("Blue moon"));
        return album;
    }
}
