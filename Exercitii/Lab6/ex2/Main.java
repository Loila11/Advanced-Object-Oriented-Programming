package ex2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws IOException {
        FileInputStream file = new FileInputStream("parole.txt");
        System.out.println("Introduceti userul si parola:");
        Scanner in = new Scanner(System.in);
        String user = in.next(), password = in.next();

        int noAttempts = 0;
        while (noAttempts < 5) {
            try {
                String thisUser = readItem(file);
                String thisPassword = readItem(file);
                if (thisUser.equals(user)) {
                    int noPasswordAttempts = 0;
                    while (!thisPassword.equals(password) && noPasswordAttempts < 3) {
                        System.out.println("Parola gresita. Introduceti din nou parola:");
                        password = in.next();
                        noPasswordAttempts ++;
                    }

                    if (thisPassword.equals(password) && noPasswordAttempts < 3) {
                        System.out.println("Acces permis");
                    } else {
                        System.out.println("Cont blocat");
                    }
                    break;
                }
            } catch (EOFException e) {
                noAttempts ++;
                file.close();

                file = new FileInputStream("parole.txt");
                System.out.println("User inexistent. Incearca din nou:");
                user = in.next();
                password = in.next();
            }
        }
        file.close();

        if (noAttempts == 5) {
            System.out.println("Nu ai cont. Inregistreaza-te");
        }
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
