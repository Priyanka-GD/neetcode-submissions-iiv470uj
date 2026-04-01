class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        List<List<Integer>> subsequences = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            subsequences.add(new ArrayList<>());
        }
        for (int idx = 0; idx < len; idx++) {
            subsequences.get(idx).add(nums[idx]);
            for (int nextIdx = 0; nextIdx < idx; nextIdx++) {
                if (nums[idx] > nums[nextIdx] &&
                        dp[idx] < dp[nextIdx] + 1) {
                    dp[idx] = dp[nextIdx] + 1;
                    subsequences.set(idx, new ArrayList<>(subsequences.get(nextIdx)));
                    subsequences.get(idx).add(nums[idx]);
                }
            }
        }
        int maxLen = 0;
        for (int idx = 0; idx < len; idx++)
            maxLen = Math.max(maxLen, dp[idx]);
        return maxLen;
    }
}
