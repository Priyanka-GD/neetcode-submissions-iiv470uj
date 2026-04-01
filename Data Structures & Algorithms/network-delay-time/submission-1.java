class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create adjacency list
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] time : times) {
            adjList.putIfAbsent(time[0], new ArrayList<>());
            adjList.get(time[0]).add(new int[]{time[1], time[2]}); // Pair (neighbor, time)
        }
        
        // Delay time array
        int[] delayTimeArr = new int[n + 1];
        Arrays.fill(delayTimeArr, Integer.MAX_VALUE);
        delayTimeArr[k] = 0; // Starting node distance is 0
        
        // Use priority queue for Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0}); // Pair (node, current delay)
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currNode = curr[0];
            int currTime = curr[1];
            
            // Skip processing if we've already found a shorter path
            if (currTime > delayTimeArr[currNode]) continue;
            
            if (!adjList.containsKey(currNode)) continue;
            
            for (int[] edge : adjList.get(currNode)) {
                int neighbor = edge[0];
                int time = edge[1];
                
                if (delayTimeArr[neighbor] > currTime + time) {
                    delayTimeArr[neighbor] = currTime + time;
                    pq.offer(new int[]{neighbor, delayTimeArr[neighbor]});
                }
            }
        }
        
        // Find the maximum time taken to reach any node
        int answer = Arrays.stream(delayTimeArr).skip(1).max().getAsInt(); // Ignore index 0
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}
