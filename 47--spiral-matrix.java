class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> traversal = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            // r1: c1 -> c2
            for (int i = c1; i <= c2; i++) {
                traversal.add(matrix[r1][i]);
            }
            // c2: r1 + 1 -> r2
            for (int i = r1 + 1; i <= r2; i++) {
                traversal.add(matrix[i][c2]);
            }
            if (c1 < c2 && r1 < r2) {
                // r2: c2 - 1 -> c1
                for (int i = c2 - 1; i >= c1; i--) {
                    traversal.add(matrix[r2][i]);
                }
                // c1: r2-1 -> r1 + 1
                for (int i = r2 - 1; i >= r1 + 1; i--) {
                    traversal.add(matrix[i][c1]);
                }
            }
            
            c1++;
            c2--;
            r1++;
            r2--;
        }
        return traversal;
    }
} // TC: O(m * n), SC: O(m * n)

/*
     c1           c2    
    [[1,  2,   3,  4 ] r1
     [5,  6,   7,  8 ]
     [9,  10,  11, 12]
     [13, 14,  15, 16]] r2
*/
