class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int high = 0, low = 1;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            long timeTakenToFinish = computeBananaEatingSpeed(mid, piles, h);

            //If mid is too slow when timeTakenToFinish > h, then we need to check from mid + 1
            if (timeTakenToFinish > h) {
                low = mid + 1;
            } else {
                //Even though mid works, we want the minimum possible speed, so we are minimizing the range
                high = mid - 1;
            }
        }
        return low;
    }

    public long computeBananaEatingSpeed(int currSpeed, int[] piles, int hour) {
        long time = 0;

        for (int pile : piles) {
            time += pile / currSpeed;
            if (pile % currSpeed != 0) {
                time++;
            }
        }
        return time;
    }
}
