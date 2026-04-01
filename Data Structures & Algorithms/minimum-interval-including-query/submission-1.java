class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        //Sort intervals by start range in ascending order
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        int[][] sortedQueries = new int[queries.length][2];
        for(int idx = 0; idx < queries.length; idx++){
            sortedQueries[idx][0] = queries[idx];
            sortedQueries[idx][1] = idx;
        }

        //Sort sortedQueries by query value in ascending order
        Arrays.sort(sortedQueries, (a,b) -> a[0] - b[0]);

        //Min heap - with respect to range 
        PriorityQueue<int[]> minHeap = new PriorityQueue<>
                ((a,b) -> (a[1] - a[0] + 1) - (b[1] - b[0] + 1));
        
        int intervalIdx = 0;
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);

        for(int sortedQuery[] : sortedQueries){
            int qValue = sortedQuery[0];
            int qIdx = sortedQuery[1];

            while(intervalIdx < intervals.length 
                && intervals[intervalIdx][0] <= qValue){
                    minHeap.add(intervals[intervalIdx]);
                    intervalIdx++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < qValue){
                minHeap.poll();
            }

            if(!minHeap.isEmpty()){
                int smallestInterval[] = minHeap.peek();
                result[qIdx] = smallestInterval[1] - smallestInterval[0] + 1;
            }
        }
        return result;    
    }
}
