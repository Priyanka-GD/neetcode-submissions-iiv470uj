class Solution {
    int memo[][];
    public int change(int amount, int[] coins) {
        memo = new int[coins.length][amount + 1];
        for(int row[] : memo)
            Arrays.fill(row, -1);
        return numberOfWays(0, amount, coins);
    }

    private int numberOfWays(int idx, int amount, int[] coins){
        if(amount == 0)
            return 1;
        if(idx == coins.length)
            return 0;
        if(memo[idx][amount] != -1)
            return memo[idx][amount];
        if(coins[idx] > amount)
           return memo[idx][amount] =  numberOfWays(idx + 1, amount, coins);
        memo[idx][amount] =  numberOfWays(idx + 1, amount, coins) + 
           numberOfWays(idx , amount - coins[idx], coins) ;
        return memo[idx][amount];
    }
}
