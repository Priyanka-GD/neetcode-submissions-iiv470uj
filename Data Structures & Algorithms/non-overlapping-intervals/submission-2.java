class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals, (intrvl1, intrvl2) -> intrvl1[0] - intrvl2[0]);

       int prevEnd = intervals[0][1], res = 0;

        for(int idx = 1; idx < intervals.length; idx++){

            if(intervals[idx][0] >= prevEnd){
                prevEnd = intervals[idx][1];
            }
            else {
                prevEnd = Math.min(prevEnd, intervals[idx][1]);
                res++;
            }
       }
       return res; 
    }
}
