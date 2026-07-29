import java.util.Scanner;
public class Main {
    static int mostFrequentDigit(int n) {
        if (n == 0) {
            return 0;
        }
        int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }
        int max = 0;
        int digit = 0;
        for (int i = 0; i < 10; i++) {
            if (freq[i] > max) {
                max = freq[i];
                digit = i;
            }
        }
        return digit;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int result = mostFrequentDigit(n);
        System.out.println("Most frequent digit: " + result);
        sc.close();
    }
}