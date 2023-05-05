class Solution {
    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], nums[i] + curr);
            max = Math.max(max, curr);
        }
        return max;
    }
} // TC: O(n), SC: O(1)
