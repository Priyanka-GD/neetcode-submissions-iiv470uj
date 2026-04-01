class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int dp[] = new int[len + 1];
        dp[0] = nums[0];
        if(len == 1)
            return dp[0];
        dp[1] = Math.max(dp[0], nums[1]);
        if(len == 2)
            return dp[1];
        for(int idx = 2; idx < len; idx++){
            if(dp[idx] > 0)
                return dp[idx];
            dp[idx] = Math.max(nums[idx] + dp[idx - 2], dp[idx - 1]);
        }
        return dp[len - 1];
    }
}
