class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int currSum = 0, count = 0;

        for (int idx = 0; idx < nums.length; idx++) {
            currSum += nums[idx];
            if (map.containsKey(currSum - k))
                count += map.get(currSum - k);

            map.put(currSum, map.getOrDefault(currSum, 0) + 1);
        }
        return count;
    }
}