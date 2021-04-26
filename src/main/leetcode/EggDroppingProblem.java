package main.leetcode;

public class EggDroppingProblem {

    public int getMinMoves(int egg, int floor) {

        if (floor == 0 || egg == 0) return 0;

        if (floor == 1 && egg == 1) return 1;

        int dp[][] = new int[egg + 1][floor + 1];

        dp[1][1] = 0;

        for (int i = 1; i <= egg; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }

        for (int i = 2; i <= floor; i++) {
            dp[1][i] = i;
        }

        for (int i = 2; i <= egg; i++) {
            for (int j = 2; j <= floor; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                for (int x = 1; x <= j; x++) {
                    int res = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
                    if (res < dp[i][j])
                        dp[i][j] = res;
                }
            }
        }

        return dp[egg][floor];
    }

    public static void main(String[] args) {
        System.out.println(new EggDroppingProblem().getMinMoves(2, 36));
    }
}
