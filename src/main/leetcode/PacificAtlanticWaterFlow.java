package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {

        List<List<Integer>> ans = new ArrayList<>();
        if (matrix.length == 0 || matrix == null) return ans;

        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new boolean[matrix.length][matrix[0].length];

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, directions, pacific, i, 0);
            dfs(matrix, directions, atlantic, i, matrix[0].length - 1);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, directions, pacific, 0, i);
            dfs(matrix, directions, atlantic, matrix.length - 1, i);
        }


        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> pair = new ArrayList<Integer>();
                    pair.add(i);
                    pair.add(j);
                    ans.add(pair);
                }
            }
        }

        return ans;


    }


    private void dfs(int matrix[][], int[][] directions, boolean visited[][], int row, int col) {

        visited[row][col] = true;

        for(int[] direction : directions){
            int X = row + direction[0];
            int Y = col + direction[1];
            if(X<0 || Y<0 || X>=matrix.length || Y>=matrix[0].length || visited[X][Y] || matrix[row][col]>matrix[X][Y]){
                continue;
            }
            dfs(matrix, directions, visited, X, Y);
        }

    }

    boolean isSafe(int row, int col, int matrix[][]) {
        if (row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1) {
            return false;
        }
        return true;
    }

}
