class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currGain = 0, totalGain = 0, answer = 0;

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