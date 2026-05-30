class Solution {
    public int findDuplicate(int[] nums) {
        for(int idx : nums){
            int index = Math.abs(idx) - 1;
            if(nums[index] < 0){
                return Math.abs(idx);
            }
            nums[index] *= -1;
        }
        return -1;
    }
}
