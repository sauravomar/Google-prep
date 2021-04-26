package main.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s) {

        int number = 0;

        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);


        Map<Character, Integer> sortedMap = new HashMap<>();

        sortedMap.put('I', 0);
        sortedMap.put('V', 1);
        sortedMap.put('X', 2);
        sortedMap.put('L', 3);
        sortedMap.put('C', 4);
        sortedMap.put('D', 5);
        sortedMap.put('M', 6);

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (i > 0 && sortedMap.get(s.charAt(i - 1)) < sortedMap.get(ch)) {
                int index = i - 1;
                while (index >= 0 && sortedMap.get(s.charAt(index)) < sortedMap.get(ch)) {
                    number = number - 2 * map.get(s.charAt(index));
                    index--;
                }
            }
            number = number + map.get(ch);
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }
}
