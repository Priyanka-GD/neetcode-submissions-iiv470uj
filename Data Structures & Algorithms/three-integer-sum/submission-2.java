class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int idx = 0; idx < nums.length - 2; idx++){
            if(idx == 0 || (idx > 0 && nums[idx - 1] != nums[idx])){
                int low = idx + 1, high = nums.length - 1, sum = -nums[idx];
                while(low < high){
                    if(nums[low] + nums[high] == sum){
                        result.add(Arrays.asList(nums[idx], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low + 1]){
                            low++;
                        }
                        while(low < high && nums[high] == nums[high - 1]){
                            high--;
                        }
                        high--;
                        low++;
                    } else if(nums[low] + nums[high] > sum){
                        high--;
                    } else{
                        low++;
                    }
                }
            }
        }
        return result;
    }
}
