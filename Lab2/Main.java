import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        ex1();
//        ex2(3);
        ex3();
//        ex4(3);
    }

    public static void ex1() {
        Scanner in = new Scanner(System.in);
        int[] v = new int[50];
        v[0] = in.nextInt();
        int n = 0, sum = 0;
        while (v[n] != -1) {
            sum += v[n];
            n ++;
            v[n] = in.nextInt();
        }
        if (n == 0) {
            n = 1;
        }
        System.out.println(sum / n);
    }

    public static void ex2(int n) {
        Scanner in = new Scanner(System.in);
        int[] pare = new int[50], impare = new int[50];
        int n1 = 0, n2 = 0, x;
        for (int i = 0; i < n; i ++) {
            x = in.nextInt();
            if (x % 2 == 0) {
                pare[n1] = x;
                n1 ++;
            } else {
                impare[n2] = x;
                n2 ++;
            }
        }

        if (n1 > n2) {
            System.out.println("Vectorul cu numere pare are mai multe elemente");
            for (int i = 0; i < n1; i ++) {
                System.out.print(pare[i] + " ");
            }
        } else {
            System.out.println("Vectorul cu numere impare are mai multe elemente");
            for (int i = 0; i < n2; i ++) {
                System.out.print(impare[i] + " ");
            }
        }
    }

    public static void ex3() {
        Student student = new Student();
        student.setNume("Gigel");
        student.setVarsta(20);
        student.cresteVarsta();

        System.out.println(student.getNume() + " " + student.getVarsta());
    }

    public static void ex4(int n) {
        Scanner in = new Scanner(System.in);

        Student[] studenti = new Student[n];
        for (int i = 0; i < n; i ++) {
            String x = in.nextLine();
            String[] y = x.split("\\s+");
            studenti[i] = new Student(y[0], Integer.parseInt(y[1]));
        }

        for (int i = 0; i < n; i ++) {
            System.out.println(studenti[i].getNume() + " " + studenti[i].getVarsta());
        }
    }
}
