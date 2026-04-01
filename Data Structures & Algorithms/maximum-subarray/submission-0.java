class Solution {
    public int maxSubArray(int[] nums) {
        int maxNum = nums[0], maxSum = nums[0];
        for(int idx = 1; idx < nums.length; idx++)
        {
            maxNum = Math.max(nums[idx], maxNum + nums[idx]);
            maxSum = Math.max(maxSum, maxNum);
        }
        return maxSum; 
    }
}
