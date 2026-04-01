class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean dp[] = new boolean[len + 1];
        dp[len] = true;

        for (int idx = len; idx >= 0; idx--) {
            for (String word : wordDict) {
                int wordLen = word.length();
                if (idx + wordLen <= len) {
                    String subStr = s.substring(idx, idx + wordLen);
                    if (subStr.equals(word))
                        dp[idx] = dp[idx + wordLen];
                    if (dp[idx])
                        break;
                }
            }
        }
        return dp[0];
    }
}
