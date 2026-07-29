import java.util.Scanner;
public class Main {
    static String secondWordUpper(String str) {
        String[] words = str.trim().split("\\s+");
        if (words.length < 2) {
            return "LESS";
        }
        return words[1].toUpperCase();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String str = sc.nextLine();
        String result = secondWordUpper(str);
        System.out.println("Output: " + result);
        sc.close();
    }
}