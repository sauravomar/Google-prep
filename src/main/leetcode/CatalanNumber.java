package main.leetcode;

public class CatalanNumber {

    public int numTrees(int n) {

        if (n == 0) return 0;

        int[] catalan = new int[n + 2];

        catalan[0] = 1;
        catalan[1] = 1;

        for (int i = 2; i <= n; i++) {

            catalan[i] = 0;

            for (int j = 0; j < i; j++) {
                catalan[i] = catalan[i] + catalan[j]
                        * catalan[i - j - 1];
            }
        }

        return catalan[n];

    }
}
