class Solution {
    public int[] sortArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int minValue = Integer.MAX_VALUE, maxValue = Integer.MIN_VALUE;

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            minValue = Math.min(minValue, num);
            maxValue = Math.max(maxValue, num);
        }
        int[] result = new int[nums.length];
        int idx = 0;

        for(int n = minValue; n <= maxValue; n++){
            while(map.containsKey(n) && map.get(n) > 0){
                result[idx++] = n;
                map.put(n, map.get(n) - 1);
            }
        }
        return result;
    }
}