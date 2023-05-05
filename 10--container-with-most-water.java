class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int min = Math.min(height[left], height[right]);
            ans = Math.max(ans, min * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }
} // TC: O(n), SC: O(1)
