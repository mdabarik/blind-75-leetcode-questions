class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        
        int min = 1, max = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {  // -2, 0, -1
                min = 1;
                max = 1;
                ans = Math.max(ans, nums[i]);
                continue;
            }

            int tmp = min;
            min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
            max = Math.max(nums[i], Math.max(nums[i] * tmp, nums[i] * max));
            ans = Math.max(ans, max);
        }

        return ans;
    }
} // TC: O(n), SC: O(1)
