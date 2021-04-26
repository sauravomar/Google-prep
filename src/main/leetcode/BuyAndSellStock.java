package main.leetcode;

public class BuyAndSellStock {

    public int maxProfit(int[] prices, int fee) {

        if (prices.length == 0) return 0;

        int dp[][] = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = prices[0] - fee;


        for (int i = 1; i < prices.length; i++) {

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]-fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

        }


        return dp[prices.length - 1][0];

    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(new BuyAndSellStock().maxProfit(prices, 2));
    }
}
