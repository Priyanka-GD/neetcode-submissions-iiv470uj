class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, totalWeight = 0;
        for(int weight : weights){
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        while(maxWeight < totalWeight){
            int midWeight = maxWeight + (totalWeight - maxWeight)/2;
            if(canLoad(midWeight, weights, days)){
                totalWeight = midWeight;
            }else{
                maxWeight = midWeight + 1;
            }
        }
        return maxWeight;
    }
    private boolean canLoad(int load, int[] weights, int days){
        int daysNeeded = 1, currLoad = 0;
        for(int weight : weights){
            currLoad += weight;
            if(currLoad > load){
                currLoad = weight;
                daysNeeded++;
            }   
        }
        return daysNeeded <= days;
    }
}