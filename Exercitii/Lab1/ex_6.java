package lab1_exercitii;
import java.util.*;

public class ex_6 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        int p = 1;
        for (int i = 1; i <= b; i ++) {
            p *= a;
        }
        
        System.out.println(p);
    }
}
