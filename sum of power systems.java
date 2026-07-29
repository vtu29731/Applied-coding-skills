import java.util.Scanner;
public class Main {
    static int sumOfPowerDigits(int n) {
        int temp = n;
        int sum = 0;
        int digits = String.valueOf(n).length();
        while (temp > 0) {
            int d = temp % 10;
            sum += (int) Math.pow(d, digits);
            temp /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int result = sumOfPowerDigits(n);
        System.out.println("Sum of digits raised to power " + String.valueOf(n).length() + " = " + result);
        if (result == n) {
            System.out.println(n + " is an Armstrong number.");
        } else {
            System.out.println(n + " is not an Armstrong number.");
        }
        sc.close();
    }
}