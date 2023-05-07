class Solution {
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        return 1 + Math.max(left, right);
    }
} // TC: O(n), SC: O(n)
