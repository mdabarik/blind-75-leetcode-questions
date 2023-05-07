class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> rCount = new HashMap<>(); // string t
        HashMap<Character, Integer> window = new HashMap<>(); // string s
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            rCount.put(ch, rCount.getOrDefault(ch, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int leftIndx = -1, rightIndx = -1;

        int count = 0, required = rCount.size();

        int left = 0, right = 0;
        for (right = 0; right < s.length(); right++) {
            char curr_ch = s.charAt(right);
            window.put(curr_ch, window.getOrDefault(curr_ch, 0) + 1);
            if (rCount.containsKey(curr_ch) && rCount.get(curr_ch).intValue() == window.get(curr_ch).intValue()) {
                count += 1;
            }
            while (required == count) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    leftIndx = left;
                    rightIndx = right;
                }
                char left_ch = s.charAt(left);
                window.put(left_ch, window.getOrDefault(left_ch, 0) - 1);
                if (rCount.containsKey(left_ch) && rCount.get(left_ch).intValue() > window.get(left_ch).intValue()) {
                    count -= 1;
                }
                left++;F
            }
        }
        if (leftIndx == -1 || rightIndx == -1) return "";
        return s.substring(leftIndx, rightIndx + 1);
    }
} // TC: O(n) + O(m), SC: O(n) + O(m)





