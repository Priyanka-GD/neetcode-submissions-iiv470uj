class Solution {
    public int search(int[] nums, int target) {
        //Search begins with choosing which side to start the search firs
        // Is it the left side or the right
        // if left, then nums[left] <= nums[mid]
        // if target lies within that zone then update right to mid -1, else left to mid + 1
        // Else move to right side and check if target is less than mid and less than right then move right to mid- 1
        // Else move left to mid + 1


        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[left] <= nums[mid]){
                if(nums[left] > target || nums[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }else{
                if(nums[mid] > target || nums[right] < target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
