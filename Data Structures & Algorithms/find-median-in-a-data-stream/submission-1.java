class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    boolean even;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
        even = true;
    }
    
    public void addNum(int num) {
        if(even){
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }else{
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even)
            return (maxHeap.peek() + minHeap.peek())/ 2.0;
        return maxHeap.peek();
        }
}
