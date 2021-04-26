package main.leetcode;

public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int buyPrice = prices[0];

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(prices[i] - buyPrice, profit);
            buyPrice = Math.min(prices[i], buyPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        int prices[] = {2, 1, 4};
        System.out.println(new BestTimeToBuyAndSellStock().maxProfit(prices));
    }
}
