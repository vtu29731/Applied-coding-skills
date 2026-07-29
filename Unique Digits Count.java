import java.util.Scanner;
public class Main {
    static int uniqueDigitCount(int n) {
        if (n == 0) {
            return 1;
        }
        boolean[] seen = new boolean[10];
        int count = 0;
        while (n > 0) {
            int d = n % 10;
            if (!seen[d]) {
                seen[d] = true;
                count++;
            }
            n /= 10;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int result = uniqueDigitCount(n);
        System.out.println("Number of unique digits: " + result);
        sc.close();
    }
}