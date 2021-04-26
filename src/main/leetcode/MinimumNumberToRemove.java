package main.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class MinimumNumberToRemove {

    public int solution(String S) {
        // write your code in Java SE 8

        if (S.length() == 0) return 0;

        HashSet<Integer> set = new HashSet<>();

        int countArr[] = new int[26];

        for (int i = 0; i < S.length(); i++) {
            countArr[S.charAt(i) - 'a']++;
        }
        Arrays.sort(countArr);

        int result = 0;

        for (int i = 0; i < countArr.length; i++) {

            if (countArr[i] == 0) continue;

            if (set.contains(countArr[i])) {
                int number = countArr[i] - 1;
                while (number > 0 && set.contains(number)) {
                    number--;
                }
                if (number == 0) continue;
                else {
                    result = result + number;
                    set.add(number);
                }
            } else {
                result = result + countArr[i];
                set.add(countArr[i]);
            }
        }
        return S.length() - result;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberToRemove().solution("eeee"));
    }
}
