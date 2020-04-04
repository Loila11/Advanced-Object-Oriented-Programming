package ex1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws IOException {
        Scanner in = new Scanner(System.in);
        FileWriter fileWriter = new FileWriter("output.txt");
        System.out.println("Introduceti numarul de perechi: ");
        int n = in.nextInt();
        System.out.println("Perechile sunt: ");
        while (n-- > 0) {
            int a, b;
            while (true) {
                a = in.nextInt();
                b = in.nextInt();
                try {
                    if (a >= b) {
                        throw new FirstNotLower();
                    }
                    break;
                } catch (FirstNotLower e) {
                    e.printStackTrace();
                    System.out.println("Introduceti o alta pereche: ");
                }
            }
            fileWriter.write(a + " " + b + "\n");
        }
        fileWriter.close();
    }
}
