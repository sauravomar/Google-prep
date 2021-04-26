package main.leetcode;

import java.util.Arrays;

public class SmallestRangeII {

    public int smallestRangeII(int[] A, int K) {

        if (A.length == 0) return 0;

        Arrays.sort(A);

        int n = A.length, mx = A[n - 1], mn = A[0], res = mx - mn;

        for (int i = 0; i < A.length - 1; i++) {
            mx = Math.max(mx, A[i] + 2 * K);
            mn = Math.min(A[i + 1], A[0] + 2 * K);
            res = Math.min(res, mx - mn);
        }

        return res;
    }
}
