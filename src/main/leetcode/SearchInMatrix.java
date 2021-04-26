package main.leetcode;

public class SearchInMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= -1) {

            if (target == matrix[i][j]) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int arr[][] = {{-1, 3}};
        System.out.println(new SearchInMatrix().searchMatrix(arr, 3));
    }
}
