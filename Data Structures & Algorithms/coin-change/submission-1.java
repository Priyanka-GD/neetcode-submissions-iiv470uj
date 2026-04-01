class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for(int idx = 1; idx <= amount; idx++){
            for(int coin : coins){
                if(idx >= coin){
                    dp[idx] = Math.min(dp[idx], dp[idx - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
