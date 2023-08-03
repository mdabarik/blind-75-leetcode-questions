
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean hasFirstRow = false;
        boolean hasFirstCol = false;
        for (int c = 0; c < matrix[0].length; c++) { // first row
            if (matrix[0][c] == 0) {
                hasFirstRow = true;
                break;
            }
        }
        for (int r = 0; r < matrix.length; r++) { // first column
            if (matrix[r][0] == 0) {
                hasFirstCol = true;
                break;
            }
        }
        for (int r = 1; r < matrix.length; r++) { // preprocessing
            for (int c = 1; c < matrix[0].length; c++) {
                if (matrix[r][c] == 0) {
                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }
        for (int c = 1; c < matrix[0].length; c++) { // 1st row
            if (matrix[0][c] == 0) {
                nullifyCol(matrix, c);
            }
        }
        for (int r = 1; r < matrix.length; r++) { // first column
            if (matrix[r][0] == 0) {
                nullifyRow(matrix, r);
            }
        }
        if (hasFirstRow) nullifyRow(matrix, 0);
        if (hasFirstCol) nullifyCol(matrix, 0);
    }
    public void nullifyRow(int[][] matrix, int row) {
        for (int c = 0; c < matrix[0].length; c++) {
            matrix[row][c] = 0;
        }
    }
    public void nullifyCol(int[][] matrix, int col) {
        for (int r = 0; r < matrix.length; r++) {
            matrix[r][col] = 0;
        }
    }
} // TC: O(R) + O(C) + O(R * C) + O(R * C), SC: O(1)
