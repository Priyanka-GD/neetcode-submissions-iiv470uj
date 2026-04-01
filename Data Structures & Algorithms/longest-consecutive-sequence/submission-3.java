class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }

        int idx = 0, longestStreak = 0;
        while(idx < nums.length){
            int currNum = nums[idx];
            int streak = 1;
            while(seen.contains(currNum + 1)){
                streak++;
                currNum++;
            }
            longestStreak = Math.max(streak, longestStreak);
            idx++;
        }
        return longestStreak;
    }
}