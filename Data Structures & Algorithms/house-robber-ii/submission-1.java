class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int firstTake = computeProfit(0, nums, nums.length - 2);
        int secondTake = computeProfit(1, nums, nums.length - 1);
        return Math.max(firstTake, secondTake);
    }

    private int computeProfit(int startIdx, int[] nums, int endIdx) {
        int len = endIdx - startIdx + 1;
        int dp[] = new int[len + 1];
        dp[0] = nums[startIdx++];
        dp[1] = Math.max(dp[0], nums[startIdx++]);
        for (int idx = 2; idx < len; idx++) {
            if (dp[idx] > 0)
                return dp[idx];
            dp[idx] = Math.max(nums[startIdx++] + dp[idx - 2], dp[idx - 1]);
        }
        return dp[len - 1];
    }
}
