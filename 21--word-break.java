class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) { // n
            for (int j = 0; j < i; j++) { // n
                String suffix = s.substring(j, i); // n
                if (set.contains(suffix) && dp[j] == true) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

// TC: O(n^3 + m), SC: O(n + m)
