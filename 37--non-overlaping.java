class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        LinkedList<int[]> merged = new LinkedList<>();
        merged.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currInterval = intervals[i];
            if (merged.getLast()[1] < currInterval[0]) {
                merged.add(currInterval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], currInterval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][2]);
    }
} // TC: O(n log n + n) SC: O(1)
