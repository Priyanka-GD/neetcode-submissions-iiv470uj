class Solution {
    int maxCount = 0;
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        maxCount = 0;
        backtrack(nums, 0, 0, Integer.MIN_VALUE);
        return maxCount;
    }

    public void backtrack(int[] nums, int index, int count, int prevNum){
        maxCount = Math.max(maxCount, count);
        for(int idx = index; idx < nums.length; idx++){
            if(nums[idx] > prevNum)
                backtrack(nums, idx + 1, count + 1, nums[idx]);
        }
    }
}
