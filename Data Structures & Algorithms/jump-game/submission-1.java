class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        //maxreach is the threshold, currStep cann't go beyond maxReach
        for (int currStep = 0; currStep < nums.length; currStep++) {
            if (currStep > maxReach)
                return false;
            int nextStep = currStep + nums[currStep];
            maxReach = Math.max(maxReach, nextStep);
            if (maxReach >= nums.length - 1)
                return true;
        }

        return false;
    }
}
