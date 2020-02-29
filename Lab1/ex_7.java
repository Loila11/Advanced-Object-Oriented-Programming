package lab1_exercitii;
import java.util.*;

public class ex_7 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int a = 1, b = 1, p = 1;
        if (n > 2) {
            for (int i = 3; i <= n; i ++) {
                int c = a + b;
                a = b;
                b = c;
            }
            p = b;
        }
        
        System.out.println(p);
    }
}