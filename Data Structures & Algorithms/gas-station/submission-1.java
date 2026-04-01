class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currGain = 0, totalGain = 0, answer = 0;
        // sum of gas > sum of cost, then a solution exists
        // for ex. gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        // diff =[-2, -2, -2, 3, 3]
        // at idx = 3, we get 3 as diff and if we total it until idx = 4, we get 6,
        // then if we substract 0,1,2 idx of diff, we get 0, so we do a round trip
        // and can easily come back to idx 3, so it works
        for (int idx = 0; idx < gas.length; idx++) {
            currGain += gas[idx] - cost[idx];
            totalGain += gas[idx] - cost[idx];
            if (currGain < 0) {
                currGain = 0;
                answer = idx + 1;
            }
        }
        return totalGain >= 0 ? answer : -1;
    }
}