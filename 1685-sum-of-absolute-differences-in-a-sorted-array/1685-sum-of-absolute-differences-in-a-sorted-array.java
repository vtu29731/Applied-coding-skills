class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int leftCount = i;
            int rightCount = n - i - 1;
            int left = nums[i] * leftCount - leftSum;
            int right = (totalSum - leftSum - nums[i])
                        - nums[i] * rightCount;
            result[i] = left + right;
            leftSum += nums[i];
        }
        return result;
    }
}