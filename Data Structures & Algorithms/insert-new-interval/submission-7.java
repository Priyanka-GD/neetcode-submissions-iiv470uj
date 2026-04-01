class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int idx = 0;
        List<int[]> results = new ArrayList<>();
        int len = intervals.length;
        while(idx < len && intervals[idx][1] < newInterval[0]){
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

/*
magine newInterval = [3, 5] and the remaining intervals = [[4, 6], [8, 10]].
Using intervals[idx][0] <= newInterval[1]:Check [4, 6]: 4 < 5 Merge them.
Check [8, 10]: 8 < 5 is False. Stop merging. (Correct!)
*/
