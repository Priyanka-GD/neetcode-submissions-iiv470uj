class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int farthest = 0;
        int currStep = 0;

        for(int step = 0; step < nums.length - 1; step++){
            farthest = Math.max(farthest, step + nums[step]);
            if(step == currStep){
                jumps++;
                currStep = farthest;
                if(currStep >= nums.length - 1)
                    break;
            }
        }
        return jumps;
    }
}
