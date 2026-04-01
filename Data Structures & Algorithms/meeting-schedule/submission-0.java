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
        Collections.sort(intervals, 
            (interval1, interval2) -> interval1.start - interval2.start);

        for(int idx = 1; idx < intervals.size(); idx++){
            if (intervals.get(idx - 1).end > intervals.get(idx).start) {
                return false;
            }
        }
        return true;
    }
}
