package main.leetcode;

import java.util.Stack;

public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        char start = '(';
        char end = ')';


        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == ')' && s.charAt(stack.peek()) == '(')
                stack.pop();
            else stack.push(i);
        }

        int index = -1;
        int max = 0;
        for (int i : stack) {
            max = Math.max(max, i - index - 1);
            index = i;
        }

        max=Math.max(max,s.length()-index-1);


        return max;
    }

    public static void main(String[] args) {

        System.out.println(new LongestValidParentheses().longestValidParentheses("()(()"));
    }
}
