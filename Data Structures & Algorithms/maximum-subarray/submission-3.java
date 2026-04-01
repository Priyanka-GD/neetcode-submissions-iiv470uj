class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], currSum = 0;
        for(int idx1 = 0; idx1 < nums.length; idx1++){
            currSum = 0;
            for(int idx2 = idx1; idx2 < nums.length; idx2++){
                currSum += nums[idx2];
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum; 
    }
}
