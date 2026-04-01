class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = 
            new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones)
            maxHeap.add(stone);
        while(!maxHeap.isEmpty() && maxHeap.size() > 1){
            int first = maxHeap.poll();
            int second = maxHeap.poll();
            if(first != second){
                int diff = first - second;
                maxHeap.add(diff);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
