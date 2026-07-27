import java.util.*;
public class PrimeCount {
    public static int countPrime(int n) {
        int cou = 0;
        int d = 2;
        while (d <= n) {
            int c = 0;
            for (int i = 2; i < d; i++) {
                if (d % i == 0) {
                    c++;
                    break;
                }
            }
            if (c == 0) {
                cou++;
                System.out.println(d);
            }
            d++;
        }
        return cou;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Count of prime numbers: " + countPrime(n));
        sc.close();
    }
}