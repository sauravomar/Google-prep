package main.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class ValidBrackets {

    public boolean isValid(String s) {

        Set<Character> set = new HashSet<>();
        set.add('(');
        set.add('{');
        set.add('[');

        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (set.contains(ch)) {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() &&  stack.peek() == map.get(ch)) stack.pop();
                else return false;
            }
        }

        if (!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidBrackets().isValid("{[]}"));
    }
}
