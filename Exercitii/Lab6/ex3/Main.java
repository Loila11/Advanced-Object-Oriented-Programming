package ex3;

import javafx.util.Pair;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
//    sa se afiseze numarul si lista clientilor majori si numarul clientilor minori
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream("clienti.txt");
        ArrayList<Pair<String, String>> majori = new ArrayList<>(), minori = new ArrayList<>();

        while (true) {
            try {
                String lastName = readItem(file);
                String firstName = readItem(file);
                int age = Integer.parseInt(readItem(file));
                if (age < 18) {
                    minori.add(new Pair<>(lastName, firstName));
                } else {
                    majori.add(new Pair<>(lastName, firstName));
                }
            } catch (EOFException e) {
                file.close();
                break;
            }
        }

        System.out.println("Clienti majori: " + majori.size());
        for (Pair<String, String> pair : majori) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        System.out.println("\nClienti minori: " + minori.size());
    }

    public static String readItem(FileInputStream file) throws IOException {
        StringBuilder str = new StringBuilder();
        int i = file.read();
        if (i == -1) {
            throw new EOFException();
        }

        while ((char)i != ' ' && (char)i != '\n' && i != -1) {
            str.append((char) i);
            i = file.read();
        }
        return str.toString().split("\\s+")[0];
    }
}
