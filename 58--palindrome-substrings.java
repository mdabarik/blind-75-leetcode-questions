class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += find(s, i, i);
            count += find(s, i, i + 1);
        }
        return count;
    }
    public int find(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count += 1;
            left--;
            right++;
        }
        return count;
    }
} // TC: O(n^2), SC: O(1)
