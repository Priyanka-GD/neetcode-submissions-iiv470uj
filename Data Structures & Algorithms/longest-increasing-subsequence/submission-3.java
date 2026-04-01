class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        // dp[i] = length of LIS ending at index i
        int[] dp = new int[n];
        
        // Every element is an LIS of length 1 by itself
        Arrays.fill(dp, 1);
        
        int maxLIS = 1;
        
        // i = current element we are trying to find the LIS for
        for (int i = 1; i < n; i++) {
            // j = look back at all previous elements
            for (int j = 0; j < i; j++) {
                // If current number is greater, we can append it to the sequence at j
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            // Keep track of the global maximum
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        return maxLIS;
    }
}