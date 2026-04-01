class Solution {
    public int maxSubArray(int[] nums) {
        //Since this is a subarray sum, we need to keep track of previous sum and curr
        //element, so we take maximum of curr element or sum of previous + current element
        int maxSum = nums[0], currSum = nums[0];
        for(int idx = 1; idx < nums.length; idx++){
            currSum = Math.max(nums[idx], currSum + nums[idx]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
