class Solution {
    public int findMin(int[] nums) {
        int low = 0, high = nums.length - 1;
        if(nums[low] < nums[high])
            return nums[low];
        while(low < high){
            int mid = low + (high - low)/2;
            if(mid < nums.length - 1 && nums[mid + 1] < nums[mid])
                return nums[mid + 1];
            if(mid > 0 && nums[mid - 1] > nums[mid])
                return nums[mid];
            // below if means, mid index element is a part of left subarray 3,4,5 say 5 is at index mid
            if(nums[mid] >= nums[low]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return nums[low];
    }
}
