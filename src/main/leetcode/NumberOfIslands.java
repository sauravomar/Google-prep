package main.leetcode;

public class NumberOfIslands {


    public int numIslands(char[][] grid) {

        int row[] = {};
        int col[] = {};

        if (grid.length == 0) return 0;

        boolean isVisited[][] = new boolean[grid.length][grid[0].length];
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !isVisited[i][j]) {
                    DFS(grid, i, j, isVisited);
                    count++;
                }
            }
        }
        return count;
    }

    boolean isSafe(char M[][], int row, int col,
                   boolean visited[][]) {
        return (row >= 0) && (row < M.length) && (col >= 0) && (col < M[0].length) && (M[row][col] == '1' && !visited[row][col]);
    }


    public void DFS(char M[][], int row, int col, boolean visited[][]) {

        int rowNbr[] = new int[]{0, 0, -1, 1,};
        int colNbr[] = new int[]{-1, 1, 0, 0};

        visited[row][col] = true;

        for (int k = 0; k < 4; ++k) {
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited)) {
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
            }
        }
    }

    public static void main(String[] args) {
        char arr[][] = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

        System.out.println(new NumberOfIslands().numIslands(arr));
    }
}
