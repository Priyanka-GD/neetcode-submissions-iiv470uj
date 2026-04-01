class Solution {
    public int jump(int[] nums) {
        int furthest = 0;
        int curr = 0;
        int count = 0;
        for(int step = 0; step < nums.length - 1; step++){
            furthest = Math.max(furthest, step + nums[step]);
            if(step == curr){
                count++;
                curr = furthest;
                if(curr >= nums.length - 1)
                    break;
            }
        }
        return count;
    }
}
