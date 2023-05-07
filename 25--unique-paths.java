class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        
        for (int i = 1; i < grid[0].length; i++) // first row
            grid[0][i] = 1;
        
        for (int i = 1; i < grid.length; i++) // first col
            grid[i][0] = 1;

        for (int r = 1; r < grid.length; r++) {
            for (int c = 1; c < grid[0].length; c++) {
                int top = grid[r-1][c];
                int left = grid[r][c-1];
                grid[r][c] = top + left;
            }
        }
        return grid[m-1][n-1];
    }
} // TC: O(m * n), SC: O(m * n)
