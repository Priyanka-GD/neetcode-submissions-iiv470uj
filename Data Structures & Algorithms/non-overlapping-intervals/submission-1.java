public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int res = 0;
        int prevEnd = intervals[0][1];
        
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start < prevEnd) {
               res++;
               prevEnd = Math.min(end, prevEnd);
            } else {
                prevEnd = end;
            }
        }
        return res;
    }
}

//{{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}};

// [3,6] [4,9] [2,15] [16,23] [9, 29] [36,45]

// [2, 15] , [3, 6], [4, 9], [9, 29], [16, 23], [36, 45]

// bucket  = 1, prev = 6


