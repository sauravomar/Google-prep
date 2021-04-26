package main.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationFromPhoneNumber {
    public List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();

        if(digits.length() == 0) return list;

        String[] table = {"", "", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"};


        Queue<String> q = new LinkedList<>();
        q.add("");

        while (!q.isEmpty()) {
            String s = q.remove();

            if (s.length() == digits.length())
                list.add(s);
            else {
                String val = table[Integer.parseInt(digits.charAt(s.length())+"")];
                for (int i = 0; i < val.length(); i++) {
                    q.add(s + val.charAt(i));
                }
            }
        }

        return list;
    }
}
