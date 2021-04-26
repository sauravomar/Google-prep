package main.leetcode;

public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];

        int m = matrix.length;
        int n = matrix[0].length;

        int result[] = new int[m * n];

        int i = 0;
        int row = 0;
        int col = 0;
        boolean up = true;

        while (row < m && col < n) {

            if (up) {
                while (row > 0 && col < n-1) {
                    result[i++] = matrix[row][col];
                    row--;
                    col++;
                }
                result[i++] = matrix[row][col];
                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                while (col > 0 && row < m - 1) {
                    result[i++] = matrix[row][col];
                    col--;
                    row++;
                }
                result[i++] = matrix[row][col];
                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }

            up = !up;
        }
        return result;
    }
}
