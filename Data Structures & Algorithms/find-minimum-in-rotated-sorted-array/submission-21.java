class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        if(nums[left] < nums[right])
            return nums[left];
        
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid + 1 < nums.length && nums[mid] > nums[mid + 1]){
                return nums[mid + 1];
            }
            else if(mid - 1 >= 0 && nums[mid - 1] > nums[mid]){
                return nums[mid];
            }
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
