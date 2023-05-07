class Solution {
    int start = 0, end = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i); 
            expandAroundCenter(s, i, i + 1);
        }
        return s.substring(start, end + 1);
    }
    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left = left + 1; // from left to right => palindromic substring
        right = right - 1;
        if (end - start + 1 < right - left + 1) {
            start = left;
            end = right;
        }
    }
} // TC: O(n^2), SC: O(1)
