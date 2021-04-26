package main.leetcode;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

public class OneAndZeros {


    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeroes = str.length() - str.replaceAll("0", "").length(), ones = str.length() - str.replaceAll("1", "").length();
            for (int i = m; i >= zeroes; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroes][j - ones] + 1);
                }
            }

        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] str = {"10", "0001", "111001", "1", "0"};

        System.out.println(new OneAndZeros().findMaxForm(str, 5, 3));
    }
}

