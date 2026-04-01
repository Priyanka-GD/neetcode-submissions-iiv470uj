class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2)-> interval1[0] - interval2[0]);
        List<int[]> result = new ArrayList<>();
        int end = intervals[0][1];
        int start = intervals[0][0];

        for(int idx = 1; idx < intervals.length; idx++){
            if(end >= intervals[idx][0]){
                end = Math.max(end, intervals[idx][1]);
                start = Math.min(start, intervals[idx][0]);
            }else{
                result.add(new int[]{start, end});
                start = intervals[idx][0];
                end = intervals[idx][1];
            }
        }
        result.add(new int[]{start, end});
        return result.toArray(new int[result.size()][2]);
    }
}
