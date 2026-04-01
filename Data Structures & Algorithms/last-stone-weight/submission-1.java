class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>(Collections.reverseOrder());

        for(int stone : stones)
            maxHeap.add(stone);
        
        while(maxHeap.size() >= 2){
            int firstStone = maxHeap.poll();
            int secondStone = maxHeap.poll();

            if(secondStone < firstStone)
                maxHeap.add(firstStone - secondStone);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
