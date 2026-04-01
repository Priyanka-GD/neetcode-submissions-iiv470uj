class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0)
            return false;
        return recursion(nums, 0, sum /2);
    }

    private boolean recursion(int nums[], int idx, int target){
        if(target == 0)
            return true;
        if(target < 0 || idx == nums.length)
            return false;
        return recursion(nums, idx + 1, target - nums[idx]) ||
            recursion(nums, idx + 1, target);
    }
}
