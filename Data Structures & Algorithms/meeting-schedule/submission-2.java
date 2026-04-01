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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (intrvl1, intrvl2) -> intrvl1.start - intrvl2.start);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(Interval interval : intervals){
            if(!maxHeap.isEmpty() && maxHeap.peek() > interval.start)
                return false;
            maxHeap.add(interval.end); 
        }
        return true;
    }
}
