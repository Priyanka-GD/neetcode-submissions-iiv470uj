class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answerList = new ArrayList<>();
        int idx = 0;
        while (idx < intervals.length && intervals[idx][1] < newInterval[0]) {
            answerList.add(intervals[idx]);
            idx++;
        }
        while (idx < intervals.length && newInterval[1] >= intervals[idx][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        answerList.add(newInterval);
        while (idx < intervals.length) {
            answerList.add(intervals[idx]);
            idx++;
        }
        return answerList.toArray(new int[answerList.size()][]);
    }
}
