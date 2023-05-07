class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        if (root.val == subRoot.val && isSame(root, subRoot)) {
            return true;
        }
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        return left || right;
    }
    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;

        boolean left = isSame(root1.left, root2.left);
        boolean right = isSame(root1.right, root2.right);
        return left && right;
    }
} // TC: O(m * n), SC: O(m)
