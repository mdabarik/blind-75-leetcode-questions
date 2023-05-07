class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currStreak = 1;
                int currNum = num;
                while (set.contains(currNum + 1)) {
                    currStreak++;
                    currNum++;
                }
                longestStreak = Math.max(longestStreak, currStreak);
            }
        }

        return longestStreak;
    }
} // TC: O(n), SC: O(n)
