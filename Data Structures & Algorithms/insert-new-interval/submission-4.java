class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int idx = 0;
        List<int[]> results = new ArrayList<>();
        int len = intervals.length;
        while(idx < len && newInterval[0] > intervals[idx][1]){
            results.add(intervals[idx++]);
        }

        while(idx < len && intervals[idx][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }

        results.add(newInterval);
        while(idx < len){
            results.add(intervals[idx++]);
        }
        return results.toArray(new int[results.size()][2]);
    }
}
