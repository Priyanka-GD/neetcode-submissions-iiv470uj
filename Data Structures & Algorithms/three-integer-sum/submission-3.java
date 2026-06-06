class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for(int idx = 0; idx < nums.length - 2; idx++){
            if(idx == 0 || (idx > 0 && nums[idx - 1] != nums[idx])){
                int left = idx + 1, right = nums.length - 1, sum = - nums[idx];
                while(left < right){
                    if(nums[left] + nums[right] == sum){
                        result.add(Arrays.asList(nums[idx], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        while(right > 0 && nums[right] == nums[right - 1]){
                            right--;
                        }
                        left++;
                        right--;
                    }
                    else if(nums[left] + nums[right] > sum){
                        right--;
                    }else{
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
