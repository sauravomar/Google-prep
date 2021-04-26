package main.leetcode;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

    public String minRemoveToMakeValid(String s) {

        if (s == null || s.length() == 0) return s;

        StringBuilder sb = new StringBuilder();

        char start = '(';
        char end = ')';

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == start) {
                stack.push(start);
                sb.append(ch);
            } else if (ch == end) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    sb.append(ch);
                }
            } else {
                sb.append(ch);
            }
        }

        while (!stack.isEmpty()) {
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) == start) {
                    sb.deleteCharAt(i);
                    stack.pop();
                    break;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid("lee(t(c)o)((de)"));
    }
}
