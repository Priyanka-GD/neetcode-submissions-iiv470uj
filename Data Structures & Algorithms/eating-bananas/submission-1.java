class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0;
        for(int pile : piles)
            high = Math.max(high, pile);
        int low = 0, minHour = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low)/2;
            double hours = 0;
            for(int pile : piles){
                hours += Math.ceil((double) pile / mid);
            }
            if(hours <= h){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}
