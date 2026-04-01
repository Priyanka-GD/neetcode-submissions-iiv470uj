class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int step = 0; step < nums.length; step++){
            if(step > maxJump)
                return false;
            int currJump = step + nums[step];
            maxJump = Math.max(currJump, maxJump);
            if(maxJump >= nums.length - 1)
                return true;
        }
        return false;
    }
}
