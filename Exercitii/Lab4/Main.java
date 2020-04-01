import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
    }

    public static String stringSort(String sir) {
        sir = sir.replaceAll("\\s+", "");
        char[] temp = new char[sir.length()];
        for (int i = 0; i < sir.length(); i ++) {
            temp[i] = sir.charAt(i);
        }
        Arrays.sort(temp);
        return new String(temp);
    }

    public static void ex1() {
        Scanner in = new Scanner(System.in);
        String sir1 = in.nextLine(), sir2 = in.nextLine();
        if (stringSort(sir1).equals(stringSort(sir2))) {
            System.out.println("Cele doua siruri sunt anagrame");
        } else {
            System.out.println("Cele doua siruri nu sunt anagrame");
        }
        in.close();
    }

    public static boolean palindrom(String sir) {
        StringBuilder sb = new StringBuilder(sir);
        String reversed = sb.reverse().toString();
        return (sir.equals(reversed));
    }

    public static void ex2() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt() + 1;
        String[] a = new String[n];
        for (int i = 0; i < n; i ++) {
            a[i] = in.nextLine();
        }
        in.close();

        int m = 0;
        String[] b = new String[n];
        for (int i = 0; i < n; i ++) {
            if (palindrom(a[i])) {
                b[m] = a[i];
                m ++;
            }
        }

        int j = 0;
        for (int i = 1; i < m; i ++) {
            if (b[i].length() > b[j].length()) {
                j = i;
            }
        }

        System.out.println("Palindromul de lungime maxima este " + b[j] + " si are lungimea " + b[j].length());
    }

    public static void ex3() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[][] img = new int[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                img[i][j] = in.nextInt();
            }
        }
        in.close();

        int sum = 0;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                int pp = 0;
                int nr = img[i][j];
                for (int k = 2; k * k <= nr; k ++) {
                    if (nr % k == 0) {
                        pp = 1;
                        break;
                    }
                }
                img[i][j] = pp;
                sum += pp;
            }
        }
        System.out.println(sum);
    }
}
