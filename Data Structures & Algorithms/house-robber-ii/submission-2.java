class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if(len == 1)
            return nums[0];
        if(len == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(maxAmt(0, len - 2, nums), maxAmt(1, len - 1, nums));
    }

    public int maxAmt(int startIdx, int endIdx, int[] nums){
        int len = endIdx - startIdx + 1;
        int[] dp = new int[len + 1];
        dp[0] = nums[startIdx++];
        dp[1] = Math.max(dp[0], nums[startIdx++]);
        for(int idx = 2; idx < len; idx++){
            if(dp[idx] > 0)
                return dp[idx];
            dp[idx] = Math.max(dp[idx - 1] , dp[idx - 2] + nums[startIdx++]);
        }
        return dp[len - 1];
    }
}
