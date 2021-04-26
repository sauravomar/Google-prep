package main.leetcode;

import java.util.Stack;


class CountChar {

    int count;
    char ch;

    public CountChar(int count, char ch) {
        this.ch = ch;
        this.count = count;

    }

}

public class RemovalAllAdjacentDuplicates {


    public String removeDuplicates(String s, int k) {

        if (s.length() == 0) return s;

        Stack<CountChar> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int charCOunt = 0;

            if (!stack.empty() && stack.peek().ch == ch) {
                charCOunt = stack.peek().count;
            } else charCOunt = 0;

            stack.add(new CountChar(charCOunt + 1, ch));

            if (stack.peek().count == k) {
                int removalCount = k;
                while (removalCount > 0) {
                    stack.pop();
                    removalCount--;
                }

            }

        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) sb.append(stack.pop().ch);
        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(new RemovalAllAdjacentDuplicates().removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
