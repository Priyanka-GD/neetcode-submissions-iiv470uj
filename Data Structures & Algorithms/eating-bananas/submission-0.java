class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles)
            maxPile = Math.max(pile, maxPile);
        int left = 1, right = maxPile, rate = 0;
        while(left <= right){
            int mid = left + (right - left)/2;
            long rateOfBananaEating = calculateHour(piles, mid);
            if(rateOfBananaEating > h)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
    private long calculateHour(int piles[], int speed){
        long hour = 0;
        for(int idx = 0; idx < piles.length; idx++){
            hour += piles[idx] / speed;
            if(piles[idx] % speed != 0)
                hour++;
        }
        return hour;
    }
}
