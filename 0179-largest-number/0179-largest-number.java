import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // 1. Convert integer array to String array
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        // 2. Sort strings with custom comparator
        // Compare (b + a) with (a + b) to sort in descending order
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));

        // 3. Edge Case: If the largest number is "0", the entire number is zero
        if (strs[0].equals("0")) {
            return "0";
        }

        // 4. Build the final concatenated result
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }

        return sb.toString();
    }
}