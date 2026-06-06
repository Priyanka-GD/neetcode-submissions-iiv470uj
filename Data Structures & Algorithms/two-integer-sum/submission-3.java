class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int idx = 0; idx < nums.length; idx++){
            int diff = target - nums[idx];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), idx};
            }
            map.put(nums[idx], idx);
        }
        return null;
    }
}
/*
Time Complexity O(n): We traverse the list containing n elements only once.
Each lookup in the hash table costs O(1) on average.
Space Complexity O(n): The extra space required depends on the number 
of items stored in the hash table, which stores at most n elements.
*/
