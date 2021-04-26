package main.leetcode;

public class UniquePath {

//    public int uniquePathsIII(int[][] grid) {
//        if(grid.length == 0) return 0;
//
//        int row=0;
//        int col=0;
//
//
//        if(grid[0][0] != 1) {
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[0].length; j++) {
//                    if (grid[i][j] == 1) {
//                        row = i;
//                        col = j;
//                        break;
//                    }
//                }
//                if (row != 0 && col != 0) break;
//            }
//        }
//
//        return findPath(grid)
//
//    }
//
//    private int findPath(int [][]grid, int row, int col){
//        if(grid[row][col] == 2) return 1;
//        int totalCount = 0;
//
//        for(int i=row; i< grid.length; i++){
//            for(int j=col; j<grid[0].length; j++){
//                if(grid[i][j] == 0){
//                    totalCount = totalCount + findPath(grid, i, j);
//                }
//            }
//        }
//        return totalCount;
//    }


}
