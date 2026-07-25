public class oddevendigitssum {
    public int EvenOddDigitsSum(int input1, String input2) {
        int sum = 0;
        while (input1 > 0) {
            int d = input1 % 10;
            if (input2.equalsIgnoreCase("even") && d % 2 == 0) {
                sum += d;
            }
            if (input2.equalsIgnoreCase("odd") && d % 2 != 0) {
                sum += d;
            }
            input1 /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Even digits sum: " + obj.EvenOddDigitsSum(123456, "even")); // Output: 12 (6+4+2)
        System.out.println("Odd digits sum: "  + obj.EvenOddDigitsSum(123456, "odd"));  // Output: 9 (5+3+1)
    }
}