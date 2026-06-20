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
        // sort by start time
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        // If the next one starts before current ends, return false. 
        // otherwise, move up one
        for (int index = 0; index < intervals.size() - 1; index++) {
            Interval current = intervals.get(index);
            Interval next = intervals.get(index + 1);
            // if conflict, return false
            if (next.start < current.end) {
                return false;
            }
        }
        // no conflicts found
        return true;

    }
}
