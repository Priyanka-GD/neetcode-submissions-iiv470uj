class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = nums[0];
        for(int idx = 1; idx < nums.length; idx++){
            currSum = Math.max(nums[idx], nums[idx] + currSum);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
