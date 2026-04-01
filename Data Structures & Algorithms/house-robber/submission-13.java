class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
            int dp[] = new int[nums.length + 1];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for(int idx = 2; idx < nums.length; idx++){
                if(dp[idx] > 0)
                    return dp[idx];
                dp[idx] = Math.max(dp[idx - 1] , dp[idx - 2] + nums[idx]);
            }
        return dp[nums.length - 1];
    }
}
