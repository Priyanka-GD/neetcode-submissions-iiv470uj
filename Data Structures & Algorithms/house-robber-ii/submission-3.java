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
        if (len == 1) 
            return nums[startIdx];
        
        int[] dp = new int[len];
        dp[0] = nums[startIdx];
        dp[1] = Math.max(nums[startIdx], nums[startIdx + 1]);
        
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[startIdx + i]);
        }
        
        return dp[len - 1];
    }
}
