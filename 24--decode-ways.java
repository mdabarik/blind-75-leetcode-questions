
class Solution {
    public int dfs(String str, int index, int[] dp) {
        if (index == str.length())
            return 1;
        if (str.charAt(index) == '0')
            return 0;
        if (dp[index] != -1) return dp[index];
        int val = dfs(str, index + 1, dp);
        if (index < str.length() - 1 && (str.charAt(index) == '1' 
                                         || str.charAt(index) == '2' 
                                         && str.charAt(index + 1) < '7')) {
            val += dfs(str, index + 2, dp);
        }
        return dp[index] = val;
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return dfs(s, 0, dp);
    }
} // TC: O(n), SC: O(n)

