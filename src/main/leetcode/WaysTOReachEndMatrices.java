package main.leetcode;

public class WaysTOReachEndMatrices {

    public int getWays(int matrices[][]) {
        if (matrices.length == 0) return 0;
        return getPath(0, 0, matrices);
    }


    private int getPath(int start, int end, int matrices[][]) {

        if (start == matrices.length - 1 && end == matrices[0].length - 1) return 1;
        if (start >= matrices.length || end >= matrices.length) return 0;

        if (matrices[start][end] != 1) {
            return getPath(start + 1, end, matrices) + getPath(start, end + 1, matrices);
        }
        return 0;

    }

    public int uniquePathsWithObstacles(int matrices[][]) {
        if (matrices.length == 0 || matrices[0][0] == 1) return 0;

        int[][] numberOfPaths = new int[matrices.length][matrices[0].length];
        numberOfPaths[0][0] = matrices[0][0] == 0 ? 1 : 0;

        numberOfPaths[numberOfPaths.length][numberOfPaths[0].length] = 1;

        for (int i = matrices.length - 1; i >= 0; i--) {
            for (int j = matrices[0].length - 1; j >= 0; j--) {
                if (matrices[i][j] == 1) {
                    numberOfPaths[i][j] = 0;
                } else if (i == 0) {
                    if (j > 0) numberOfPaths[i][j] = numberOfPaths[i][j - 1];
                } else if (j == 0) {
                    if (i > 0) numberOfPaths[i][j] = numberOfPaths[i - 1][j];
                } else {
                    numberOfPaths[i][j] = numberOfPaths[i - 1][j] + numberOfPaths[i][j-1];
                }
            }
        }

        return numberOfPaths[numberOfPaths.length - 1][numberOfPaths[0].length - 1];

    }

    public static void main(String[] args) {
        int mat[][] = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(new WaysTOReachEndMatrices().getWays(mat));
    }
}
