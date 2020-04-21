package Exceptions;

import java.io.File;
import java.util.Scanner;

public class CatchFNFE {
    public Scanner in;

    public CatchFNFE(String fileType) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Introduceti numele fisierului cu " + fileType + ": ");
            try {
                this.in = new Scanner(new File(in.nextLine()));
                break;
            } catch (java.io.FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
