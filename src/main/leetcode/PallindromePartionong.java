package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PallindromePartionong {

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public List<List<String>> partition(String s) {

        List<List<String>> result = new ArrayList<>();
        ArrayList<String> partition = new ArrayList<String>();//track each possible partition

        if (s == null || s.length() == 0) return result;
        addString(s, 0, partition, result);
        return result;
    }


    private void addString(String s, int start, ArrayList<String> partition,
                           List<List<String>> result) {

        if (s.length() == start) {
            ArrayList<String> temp = new ArrayList<String>(partition);
            result.add(temp);
            return;
        }


        for (int i = start + 1; i < s.length(); i++) {
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str);
                addString(s, i, partition, result);
                partition.remove(partition.size() - 1);
            }
        }

    }
}
