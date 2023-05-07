class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (!map.containsKey(ch)) {
                map.put(ch, right);
            } else {
                left = Math.max(left, map.get(ch) + 1);
                map.put(ch, right);
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
} // TC: O(n), SC: O(n)
