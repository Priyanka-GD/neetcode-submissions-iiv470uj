class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mapOfIndices = new HashMap<>();

        for(int idx = 0; idx < nums.length; idx++){
            int complement = target - nums[idx];
            if(mapOfIndices.containsKey(complement))
                return new int[]{mapOfIndices.get(complement), idx};
            mapOfIndices.put(nums[idx], idx);
        }
        return null;
    }
}
