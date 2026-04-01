class Solution {
    public int climbStairs(int n) {
        if(n <= 1)
            return n;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int step = 3; step <= n; step++)
            dp[step] = dp[step - 1] + dp[step - 2];
        return dp[n];
    }
}
