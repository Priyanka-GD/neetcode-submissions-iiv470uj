class MedianFinder {
    PriorityQueue<Integer> evenQ;
    PriorityQueue<Integer> oddQ;
    boolean even;

    public MedianFinder() {
        evenQ = new PriorityQueue<>(Collections.reverseOrder());
        oddQ = new PriorityQueue<>();
        even = true;
    }
    
    public void addNum(int num) {
        if(even){
            evenQ.add(num);
            oddQ.add(evenQ.poll());
        }else{
            oddQ.add(num);
            evenQ.add(oddQ.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even){
            return (evenQ.peek() + oddQ.peek())/2.0;
        }else{
            return oddQ.peek();
        }
    }
}
