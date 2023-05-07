class Solution {
    public static void dfs(int[][] matrix, boolean[][] ocean, int r, int c, int curr) {
        if (r < 0 || r >= matrix.length || c < 0 || c >= matrix[0].length) return;
        if (matrix[r][c] < curr || ocean[r][c] == true) return;
        ocean[r][c] = true;
        // down, up, right, left
        dfs(matrix, ocean, r + 1, c, matrix[r][c]);
        dfs(matrix, ocean, r - 1, c, matrix[r][c]);
        dfs(matrix, ocean, r, c + 1, matrix[r][c]);
        dfs(matrix, ocean, r, c - 1, matrix[r][c]);
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> list = new ArrayList<>();
        int row = heights.length, col = heights[0].length;
        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        int MIN = Integer.MIN_VALUE;
        // first row & last row
        for (int c = 0; c < col; c++) {
            dfs(heights, pacific, 0, c, MIN);
            dfs(heights, atlantic, row - 1, c, MIN);
        }
        // first col & last col
        for (int r = 0; r < row; r++) {
            dfs(heights, pacific, r, 0, MIN);
            dfs(heights, atlantic, r, col - 1, MIN);
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (pacific[r][c] == true && atlantic[r][c] == true) {
                    list.add(Arrays.asList(r, c));
                }
            }
        }
        return list;
    }
}

/*
    1, 2, 2, 3, 5
    3, 2, 3, 4, 4
    2, 4, 5, 3, 1
    6, 7, 1, 4, 5
    5, 1, 1, 2, 4
*/
