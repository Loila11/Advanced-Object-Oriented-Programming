package lab1_exercitii;
import java.util.*;

public class ex_5{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean pp = true;
        
        for (int i = 2; i < n; i ++) {
            if (n % i == 0) {
                pp = false;
            }
        }
        
        System.out.println(pp);
    }
}
