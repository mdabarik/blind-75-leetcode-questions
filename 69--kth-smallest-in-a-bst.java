class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        while (true) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            k = k - 1;
            if (k == 0) return root.val;
            root = root.right;
        }
    }
} // TC: O(n), SC: O(n)
