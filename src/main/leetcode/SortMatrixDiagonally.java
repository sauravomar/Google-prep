package main.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {

        if (mat.length == 0) return mat;

        int row = 0;
        int col = 0;
        int diff = 0;

        while (row < mat.length) {
            while (col < mat[0].length) {
                //get diagonal
                List<Integer> list = new ArrayList<>();
                int startRow = row;
                int startCol = col + diff;

                while (startRow < mat.length && startCol < mat[0].length) {
                    list.add(mat[startRow][startCol]);
                    startRow++;
                    startCol++;
                }
                Collections.sort(list);
                startRow = row;
                startCol = col + diff;
                int index = 0;

                while (startRow < mat.length && startCol < mat[0].length) {
                    mat[startRow][startCol] = list.get(index);
                    startRow++;
                    startCol++;
                    index++;
                }
                col++;
            }
            row++;
            col = 0;
            diff = 0;
        }
        return mat;
    }

    public static void main(String[] args) {
        int mat[][] = {{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}};
        int result[][] = new SortMatrixDiagonally().diagonalSort(mat);
        System.out.println(result);
    }

}
