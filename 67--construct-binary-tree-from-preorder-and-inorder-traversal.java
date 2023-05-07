class Solution {
    int preorderIndex;
    HashMap<Integer,Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return arrayToTree(preorder, 0, inorder.length - 1);
    }
    public TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);
        root.left = arrayToTree(preorder, left, inorderIndexMap.get(rootValue) - 1); // left: left -> c-1
        root.right = arrayToTree(preorder, inorderIndexMap.get(rootValue) + 1, right); // right: c+1 -> right
        return root;
    }
} // TC: O(n), SC: O(n)
