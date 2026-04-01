class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : hand) {
            minHeap.add(num);
        }

        while (!minHeap.isEmpty()) {
            int curr = minHeap.poll();
            for (int nextEle = curr + 1; nextEle < curr + groupSize; nextEle++) {
                if (!minHeap.remove(nextEle))
                    return false;
            }
        }
        return true;
    }
}
