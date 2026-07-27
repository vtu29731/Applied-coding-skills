public class Main {
    public static int isPalinNum(int input1) {
        int temp = input1;
        int rev = 0;
        while (input1 > 0) {
            rev = rev * 10 + (input1 % 10);
            input1 /= 10;
        }
        if (rev == temp)
            return 1;   // Palindrome
        else
            return 2;   // Not a palindrome
    }
    public static void main(String[] args) {
        int num = 121;
        if (isPalinNum(num) == 1)
            System.out.println(num + " is a Palindrome");
        else
            System.out.println(num + " is Not a Palindrome");
    }
}