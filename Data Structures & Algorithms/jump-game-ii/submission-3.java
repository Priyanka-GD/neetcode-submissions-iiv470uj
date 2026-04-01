class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int farthest = 0;
        int currentEnd = 0;
        //The last element does not need to be processed because 
        // if you reach it, you don't need any more jumps.
        for(int i = 0; i < nums.length - 1; i++){
           farthest = Math.max(farthest, i + nums[i]);
           //i reached j, now update farthest and check next steps
           if(i == currentEnd){
            jumps++;
            currentEnd = farthest;
            if(currentEnd >= nums.length - 1)
                break;
           }
        }
        return jumps;
    }
}
