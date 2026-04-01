class Solution {
    public int minDistance(String word1, String word2) {
        int word1Len = word1.length();
        int word2Len = word2.length();

        int dp[][] = new int[word2Len + 1][word1Len + 1];

        for (int pos = 1; pos <= word1Len; pos++)
            dp[0][pos] = pos;
        for (int pos = 1; pos <= word2Len; pos++)
            dp[pos][0] = pos;

        for (int row = 1; row <= word2Len; row++) {
            for (int col = 1; col <= word1Len; col++) {
                if (word1.charAt(col - 1) == word2.charAt(row - 1))
                    dp[row][col] = dp[row - 1][col - 1];
                else {
                    dp[row][col] = Math.min(dp[row - 1][col - 1],
                            Math.min(dp[row - 1][col], dp[row][col - 1])) + 1;
                }
            }
        }
        return dp[word2Len][word1Len];
    }
}