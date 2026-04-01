class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int minCost[] = new int[len + 1];

        for(int step = 2; step <= len; step++){
            int takeOneStep = minCost[step - 1] + cost[step - 1];
            int takeTwoStep = minCost[step - 2] + cost[step - 2];
            minCost[step] = Math.min(takeOneStep, takeTwoStep);
        }
        return minCost[len];
    }
}
