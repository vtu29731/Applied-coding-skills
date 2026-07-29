import java.util.Scanner;
public class Main {
    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    static int sumNonPrimeIndex(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!isPrime(i)) {
                sum += arr[i];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = sumNonPrimeIndex(arr);
        System.out.println("Sum of elements at non-prime indexes: " + result);
        sc.close();
    }
}