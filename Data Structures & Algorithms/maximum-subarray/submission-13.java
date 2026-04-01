class Solution {
    public int maxSubArray(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];
        for(int idx = 1; idx < nums.length; idx++){
            currSum = Math.max(nums[idx], currSum + nums[idx]);
            maxSum = Math.max(currSum, maxSum);
        }
        return maxSum;
    }
}
