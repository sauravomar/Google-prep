package main.leetcode;

import java.util.Stack;

public class ScoreOfParentheses {

    public int scoreOfParentheses(String S) {

        char startBrace = '(';

        int score = 0;

        Stack<int[]> stack = new Stack<>();

        int isbacktoBackPop = 0;

        for(int i=0; i<S.length(); i++) {
            if(S.charAt(i) == '(') {
                stack.push(new int[] {i, score});
            } else {
                int[] a = stack.pop();
                if(i - 1 == a[0]) score += 1;
                else score += (score - a[1]);
            }
        }

        return score;
    }

    public static void main(String[] args) {
        System.out.println(new ScoreOfParentheses().scoreOfParentheses("(()((())))"));
    }
}
