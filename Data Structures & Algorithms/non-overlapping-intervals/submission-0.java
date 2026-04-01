class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int currEnd = intervals[0][1];

        for (int idx = 1; idx < intervals.length; idx++) {
            if (currEnd > intervals[idx][0]) {
                count++;
            } else {
                currEnd = intervals[idx][1];
            }
        }
        return count;
    }
}
