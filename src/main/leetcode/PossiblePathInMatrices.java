package main.leetcode;

public class PossiblePathInMatrices {

    public int uniquePaths(int m, int n) {
        if (m == 0 && n == 0) return 0;
        return getPath(0, 0, m, n);
    }


    private int getPath(int start, int end, int m, int n) {
        if (start == m - 1 && end == n - 1) return 1;
        if (start < m && end < n) return getPath(start + 1, end, m, n) + getPath(start, end + 1, m, n);
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new PossiblePathInMatrices().uniquePaths(19, 13));
    }



}
