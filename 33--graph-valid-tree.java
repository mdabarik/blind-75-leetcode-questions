public class Solution { // LintCode
    public boolean validTree(int n, int[][] edges) {
        int[] root = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            rank[i] = 0;
        }

        int count = n; // number of connected components
        for (int[] edge : edges) {
            int A = edge[0], B = edge[1];
            int rootA = find(root, A); // union-find
            int rootB = find(root, B);
            if (rootA == rootB) return false;

            // union 
            if (rank[rootA] >= rank[rootB]) {
                root[rootB] = rootA;
                rank[rootA]++;
            } else {
                root[rootA] = rootB;
                raFnk[rootB]++;
            }

            count--;
        }

        return (count == 1);
    }

    public int find(int[] root, int X) {
        if (root[X] != X) {
            root[X] = find(root, root[X]);
        }
        return root[X];
    }
} // TC: O(V + E), SC: O(V)
