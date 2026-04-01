class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int step = 0; step < nums.length; step++){
            // edge condition, have already stepped at last index at from maxJump we couldn't reach step, 
            // so return false
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
