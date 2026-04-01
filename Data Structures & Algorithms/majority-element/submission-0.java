class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, majEle = nums[0];
        for(int idx = 1; idx < nums.length; idx++){
            if(nums[idx] == majEle){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                majEle = nums[idx];
                count = 1;
            }
        }
        return majEle;
    }
}