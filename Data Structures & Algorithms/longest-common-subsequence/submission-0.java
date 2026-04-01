class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];

        for(int idx1 = text1.length() - 1; idx1 >= 0; idx1--){
            for(int idx2 = text2.length() - 1; idx2 >= 0; idx2--){
                if(text1.charAt(idx1) == text2.charAt(idx2))
                    dp[idx1][idx2] = 1 + dp[idx1 + 1][idx2 + 1];
                else
                     dp[idx1][idx2] = Math.max(dp[idx1][idx2 + 1], dp[idx1 + 1][idx2]);
            }
        }
        return dp[0][0];
    }
}