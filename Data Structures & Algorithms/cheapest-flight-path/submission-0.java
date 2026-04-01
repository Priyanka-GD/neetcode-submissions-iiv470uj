class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> mapOfDist = new HashMap<>();

        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int dist = flight[2];
            mapOfDist.putIfAbsent(from, new HashMap<>());
            mapOfDist.get(from).put(to, dist);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { src, 0, 0 });

        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        while (!q.isEmpty()) {
            int[] element = q.poll();
            int source = element[0];
            int currPrice = element[1];
            int currStop = element[2];

            if (currStop > k)
                continue;

            for (int nextStop : mapOfDist.getOrDefault(source, new HashMap<>()).keySet()) {
                int price = mapOfDist.get(source).get(nextStop);
                int newPrice = price + currPrice;

                if (newPrice < minCost[nextStop]) {
                    minCost[nextStop] = newPrice;
                    q.add(new int[] { nextStop, newPrice, currStop + 1 });
                }
            }
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
