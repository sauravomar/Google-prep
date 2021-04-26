package main.leetcode;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class MinimumEffortPath {


    private static boolean isValidPath(int x, int y, int sol[][]) {
        return (x >= 0 && x < sol.length && y >= 0 && y < sol[0].length);
    }

    public int minimumEffortPath(int[][] heights) {
        if (heights.length == 0) return 0;
        return traverse(heights, 0, 0);
    }


    private int traverse(int[][] heights, int start, int end) {


        int currVal = heights[start][end];
        System.out.println("Row " + start + " col " + end);

        if (start + 1 == heights.length - 1 && end == heights[0].length - 1) {
            return Math.abs(heights[start + 1][end] - currVal);
        }

        if (start == heights.length - 1 && end + 1 == heights[0].length - 1) {
            return Math.abs(heights[start][end + 1] - currVal);
        }


        int diff1 = Integer.MAX_VALUE;
        int diff2 = Integer.MAX_VALUE;

        if (isValidPath(start + 1, end, heights)) {
            int val = traverse(heights, start + 1, end);
            int diff = Math.abs(heights[start + 1][end] - currVal);
            System.out.println("Row " + (start + 1) + " col " + end + " diff " + diff + " val " + val);
            diff1 = Math.max(val, diff);

        }
        if (isValidPath(start, end + 1, heights)) {
            int val = traverse(heights, start, end + 1);
            int diff = Math.abs(heights[start][end + 1] - currVal);
            System.out.println("Row " + start + " col " + (end + 1) + " diff " + diff + " val " + val);
            diff2 = Math.max(val, diff);
        }
        return Math.min(diff1, diff2);
    }


//    public static void main(String[] args) {
//        int arr[][] = {{1, 2, 1, 1, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 2, 1, 2, 1}, {1, 1, 1, 2, 1}};
//        System.out.println(new MinimumEffortPath().minimumEffortPath(arr));
//    }

    static int MOD = 1_000_000_007;

    public static void main(String[] args) {
        System.out.println(getCount(5, 4, 3));
        System.out.println(getCount(5, 2, 3));
        System.out.println(getCount(4, 2, 2));
        System.out.println(getCount(5, 2, 3));
        assert getCount(5, 4, 3) == 469;
        assert getCount(5, 2, 3) == 2;
        assert getCount(4, 2, 2) == 8;
        assert getCount(5, 2, 3) == 2;
    }

    public static int getCount(int n, int k , int x){
        int[][] dp = new int[k+1][n+1];
        for(int[] d : dp){
            Arrays.fill(d, -1);
        }

        System.out.println("\nN: " + n  + " K: " + k + " x: " + x);

        // Initially no previous color
        return solve(-1, n, k, dp, x);
    }

    public static int solve(int previous_color, int n, int k, int [][] dp, int x){
        if (n == 0)
            return 1;

        int ans = 0;

        if (previous_color != -1 && dp[previous_color][n] != -1) {
//            System.out.println("MEMOIZATION HIT: N: " + n  + " K: " + k + " x: " + x + " prev_c: " + previous_color);
            return dp[previous_color][n];
        }

        for(int i=1; i<=k; i++) {
            // no two colors can be adjacent except color x
            if(i == previous_color && previous_color != x)
                continue;

            /*
             * Commenting this portion as it is redundant
             */
            // if the color is the one that can be adjacent
            //if(i == x)
            //   continue;

            // Number of ways possible without adjacency for n-1 points
            ans += solve(i, n-1, k, dp, x);
            ans %= MOD;
        }

        /*
         * Commenting this portion as it is redundant
         */
        // Number of ways possible with color X in adjacent position for n-1 points
        //ans += solve(x, n-1, k, dp, x);
        //ans %= MOD;

        if(previous_color != -1){
            dp[previous_color][n] = ans;
        }

        return ans;
    }
}
