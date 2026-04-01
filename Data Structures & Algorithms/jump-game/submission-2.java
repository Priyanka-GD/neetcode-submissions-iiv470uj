class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for(int step = 0; step < nums.length; step++){
            if(step > maxReach)
                return false;
            int currStep = step + nums[step];
            maxReach = Math.max(maxReach, currStep);
            if(maxReach >= nums.length - 1)
                return true;
        }
        return false;
    }
}
