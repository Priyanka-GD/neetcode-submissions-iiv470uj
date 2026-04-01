class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for(int idx1 = 0; idx1 < nums.length; idx1++){
            int sum = nums[idx1];
            maxSum = Math.max(sum, maxSum);
            for(int idx2 = idx1 + 1; idx2 < nums.length; idx2++){
                sum += nums[idx2];
                maxSum = Math.max(sum, maxSum);
            }
        }
        return maxSum;
    }
}
