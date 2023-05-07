class Solution {
    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }
    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
} // TC: O(n), SC: O(n)
