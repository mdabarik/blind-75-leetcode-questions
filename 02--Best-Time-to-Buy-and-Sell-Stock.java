class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0, left = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[left]) {
                profit = Math.max(profit, prices[i] - prices[left]);
            } else {
                left = i;
            }
        }
        return profit;
    }
} // TC: O(n), SC: O(1)
