class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int idx = 0;
        int len = intervals.length;
        List<int[]> result = new ArrayList<>();
        int resultIdx = 0;
        while(idx < len && intervals[idx][1] < newInterval[0]){
            result.add(intervals[idx++]);
        }
        while(idx < len && intervals[idx][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        result.add(newInterval);
        while(idx < len){
            result.add(intervals[idx++]);
        }
        return result.toArray(new int[result.size()][2]);  
    }
}
/*

If we are checking for newInterval = [4, 5]
intervals = [[1, 3], [6, 10]]

Then if we are comparing if currIntervalEnd >= newInterval[0] - which will be true for 
[4,5] [6,10]- but they are not overlapping, so the if should have
if currInterval start <= new Interval end. then there is an overlap

*/
