package main.leetcode;

public class LongestIncreasingPathInmAt {

    public int longestIncreasingPath(int[][] matrix) {


        if (matrix.length == 0) return 0;

        int ans = 1;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, traverse(matrix, i, j, dp));
            }
        }
        return ans;

    }


    private boolean isSafe(int mat[][], int row, int col, int curVal) {
        return row >= 0 && col >= 0 && row < mat.length && col < mat[0].length && curVal < mat[row][col];
    }

    private int traverse(int mat[][], int row, int col, int visited[][]) {

        if (visited[row][col] != 0)
            return visited[row][col];

        int ans = 1;

        if (isSafe(mat, row + 1, col, mat[row][col])) {
            ans = Math.max(ans, traverse(mat, row + 1, col, visited) + 1);
        }


        if (isSafe(mat, row, col + 1, mat[row][col])) {
            ans = Math.max(ans, traverse(mat, row, col + 1, visited) + 1);
        }


        if (isSafe(mat, row, col - 1, mat[row][col])) {
            ans = Math.max(ans, traverse(mat, row, col - 1, visited) + 1);
        }


        if (isSafe(mat, row - 1, col, mat[row][col])) {
            ans = Math.max(ans, traverse(mat, row - 1, col, visited) + 1);
        }

        visited[row][col] = ans;

        return ans;

    }

    public static void main(String[] args) {
        int mat[][] = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
        System.out.println(new LongestIncreasingPathInmAt().longestIncreasingPath(mat));
    }

}


