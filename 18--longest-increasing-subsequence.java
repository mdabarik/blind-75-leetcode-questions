class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            int curr = 0;
            for (int j = 0; j <= i; j++) {
                if (nums[j] < nums[i]) {
                    curr = Math.max(curr, dp[j]);
                }
            }
            dp[i] = curr + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
} // TC: O(n), SC: O(n)
/*
[10, 9, 2, 5, 3, 7, 101, 18]
  1  1. 1  2  2  */
