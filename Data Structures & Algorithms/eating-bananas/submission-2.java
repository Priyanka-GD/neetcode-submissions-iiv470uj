class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hoursSpent = 0; 

            for (int pile : piles) {
                hoursSpent += (pile + mid - 1) / mid;
            }

            if (hoursSpent <= h) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return result;
    }
}