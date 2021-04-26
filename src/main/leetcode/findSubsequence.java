package main.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findSubsequence {

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<=s.length() - 10; i++) {
            map.put(s.substring(i, i+10), map.getOrDefault(s.substring(i, i+10), 0) + 1);
        }

        List<String> ans = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s  = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(new findSubsequence().findRepeatedDnaSequences(s));
    }
}
