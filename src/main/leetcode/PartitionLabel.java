package main.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PartitionLabel {

    public List<Integer> partitionLabels(String S) {

        List<Integer> result = new ArrayList<>();

        if(S.length() == 0) return  result;

        char[] arr = S.toCharArray();

        int[] right = new int[26];

        for(char c:arr) right[c-'a']++;

        int count =0;

        HashSet<Character> seen = new HashSet<Character>();
        for(char c:arr) {
            count++;
            seen.add(c);

            if(--right[c-'a'] == 0){
                seen.remove(c);
                if(seen.isEmpty()){
                    result.add(count);
                    count =0;
                }
            }

        }
        return  result;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabel().partitionLabels("ababcbacadefegdehijhklij"));
    }

}