class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p, q);
    }
    public boolean dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        boolean left = dfs(root1.left, root2.left);
        boolean right = dfs(root1.right, root2.right);
        return left && right;
    }
} // TC: O(n), SC: O(n)
