package main.leetcode;

import java.util.Stack;

public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;

        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && popped[j] == stack.peek()) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1, 2, 3, 4, 5};
        int popped[] = {4, 5, 3, 2, 1};
        System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
    }
}



