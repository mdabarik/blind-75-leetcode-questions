class Solution {
  public static int countConnectedComp(int[][] edges, int n) { // lintCode
    int[] root = new int[n];
    int[] rank = new int[n];
    for (int i = 0; i < n; i++) {
        root[i] = i;
        rank[i] = 0;
    }

    int count = n;
    for (int[] edge : edges) {
        int A = edge[0], B = edge[1];
        int rootA = find(root, A);
        int rootB = find(root, B);
        if (rootA != rootB) {
            count--;
        }
        if (rank[rootA] >= rank[rootB]) {
            root[rootB] = root[rootA];
            rank[rootA]++;
        } else {F
            root[rootA] = root[rootB];
            rank[rootB]++;
        }
    }
    return count;
  }

  public static int find(int[] root, int x) {
      if (root[x] != x) {
          root[x] = find(root, root[x]);
      }
      return root[x];
  }
} // TC: O(V + E), SC: O(V)
