/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (intrvl1, intrvl2) -> (intrvl1.start - intrvl2.start));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interval : intervals){
            if(!minHeap.isEmpty() && minHeap.peek() <= interval.start){
                minHeap.poll();
            }
            minHeap.add(interval.end);
        }
        return minHeap.size();
    }
}
