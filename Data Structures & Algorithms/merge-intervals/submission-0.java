class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> answer = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];

        for(int idx = 1; idx < intervals.length; idx++){
            if(currEnd >= intervals[idx][0]){
                currEnd = Math.max(currEnd, intervals[idx][1]);
                currStart = Math.min(currStart, intervals[idx][0]);
            } else {
                answer.add(new int[]{currStart, currEnd});
                currStart = intervals[idx][0];
                currEnd = intervals[idx][1];
            }
        }
        answer.add(new int[]{currStart, currEnd});
        return answer.toArray(new int[answer.size()][]);

    }
}
