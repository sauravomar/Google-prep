package main.leetcode;

import java.util.Arrays;

public class RussianDolEnvelope {

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) return 0;

        Arrays.sort(envelopes, (a, b) -> (a[0] - b[0]));

        int len = envelopes.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        int maxEn = 1;

        for (int i = 0; i < envelopes.length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxEn = Math.max(maxEn, dp[i]);
        }


        return maxEn;
    }

    public static void main(String[] args) {

        int arr[][] = {{4, 5}, {6, 7}, {2, 3}};

        System.out.println(new RussianDolEnvelope().maxEnvelopes(arr));
    }
}
