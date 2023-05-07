class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != -1) {
                    min = Math.min(min, dp[i - coins[j]]);
                }
            }
            dp[i] = (min == Integer.MAX_VALUE) ? -1 : 1 + min;
        }
        return dp[amount];
    }
} // TC: (n * amount), SC: O(amount)
