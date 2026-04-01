class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (k > points.length) {
            return null;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(getDistance(b), getDistance(a))
        );

        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    private int getDistance(int[] point) {
        int x = point[0];
        int y = point[1];
        return x * x + y * y;
    }
}