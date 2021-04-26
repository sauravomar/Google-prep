package main.leetcode;

import java.util.Stack;

public class StocksSpan {

    public int[] calculateSpan(int price[]) {

        if (price.length == 0) return new int[0];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);


        int S[] = new int[price.length];
        S[0] = 1;

        for (int i = 1; i < price.length; i++) {

            while (!stack.empty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                S[i] = i + 1;
            } else {
                S[i] = i - stack.peek();

            }
            stack.push(i);
        }

        return S;
    }

    public static void main(String[] args) {
        int price[] = { 100, 80, 60, 70, 60, 75,85 };
        System.out.println(new StocksSpan().calculateSpan(price));
    }
}
