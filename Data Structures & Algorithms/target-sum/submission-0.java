class Solution {
    int totalWays = 0;

    public int findTargetSumWays(int[] nums, int target) {
        calculateWays(nums, target, 0, 0);
        return totalWays;
    }

    private void calculateWays(int nums[], int target, int currIdx, int currSum) {
        if (currIdx == nums.length) {
            if (currSum == target)
                totalWays++;
        } else {
            calculateWays(nums, target, currIdx + 1, currSum + nums[currIdx]);
            calculateWays(nums, target, currIdx + 1, currSum - nums[currIdx]);
        }

    }
}