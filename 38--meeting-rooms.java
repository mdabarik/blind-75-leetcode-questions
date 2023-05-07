/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution { // lintCode
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int prev = 0;
        for (int curr = 1; curr < intervals.size(); curr++) {
            int endTime = intervals.get(prev).end;
            int startTime = intervals.get(curr).start;
            if (endTime > startTime) {
                return false;
            }
        }
        return true;
    }
} // TC: O(n log n + n), SC: O(1)
