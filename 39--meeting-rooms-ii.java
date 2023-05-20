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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
        minHeap.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            int end = minHeap.peek().end;
            int start = intervals.get(i).start;
            if (end <= start) {
                minHeap.poll();
            }
            minHeap.add(intervals.get(i));
        }
        return minHeap.size();
    }
} // TC: O(n log n), SC: O(n)
