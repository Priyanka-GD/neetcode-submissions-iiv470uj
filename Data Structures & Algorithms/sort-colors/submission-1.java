class Solution {
    public void sortColors(int[] nums) {
        int currIdx = 0, startIdx = 0, endIdx = nums.length - 1;
        while(currIdx <= endIdx){
            if(nums[currIdx] == 0){
                int temp = nums[currIdx];
                nums[currIdx] = nums[startIdx];
                nums[startIdx] = temp;
                startIdx++;
                currIdx++;
            }else if(nums[currIdx] == 2){
                int temp = nums[currIdx];
                nums[currIdx] = nums[endIdx];
                nums[endIdx] = temp;
                endIdx--;
            }else{
                currIdx++;
            }
        }
    }
}