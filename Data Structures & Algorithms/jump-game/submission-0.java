class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int idx = 0; idx < nums.length; idx++){
            if(idx > maxReach)
                return false;
            maxReach = Math.max(maxReach, idx + nums[idx]);
            if(maxReach >= nums.length - 1)
                return true;
        }
        return false;
    }
}
