class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        // array is in correct position - not rotated or rotated right number of times
        if(nums[left] < nums[right])
            return nums[left];
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid < nums.length - 1 && nums[mid + 1] < nums[mid])
                return nums[mid + 1];
            if(mid > 0 && nums[mid - 1] > nums[mid])
                return nums[mid];
            if(nums[mid] >= nums[left]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
