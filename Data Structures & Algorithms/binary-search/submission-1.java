class Solution {
    public int search(int[] nums, int target) {
        // If you used low < high, you might skip checking that last element, 
        // potentially missing the target if it happens to be there.
        int high = nums.length - 1, low = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
