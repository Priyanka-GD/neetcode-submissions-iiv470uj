class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        boolean dp[][] = new boolean[len][len];
        int count = 0;

        for (int idx = 0; idx < len; idx++){
            dp[idx][idx] = true;
            count++;
        }

        for (int idx = 0; idx < len - 1; idx++) {
            if (s.charAt(idx) == s.charAt(idx + 1)) {
                dp[idx][idx + 1] = true;
                count++;
            }
        }

        for (int diff = 2; diff < len; diff++) {
            for (int idx = 0; idx < len - diff; idx++) {
                int nextIdx = idx + diff;
                if (s.charAt(idx) == s.charAt(nextIdx) &&
                        dp[idx + 1][nextIdx - 1]) {
                    dp[idx][nextIdx] = true;
                    count++;
                }
            }
        }
        return count;
    }
}

