package main.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongSubString {

        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;

            int max = 0;
            Set<Character> set = new HashSet<>();
            int index = 0;
            int startStr = 0;

            while (index < s.length() && startStr < s.length()) {
                char ch = s.charAt(index);
                if (!set.contains(ch)) {
                    set.add(ch);
                    index++;
                    max = Math.max(max, index - startStr);
                } else {
                    set.remove(s.charAt(startStr));
                    startStr++;
                }

            }
            if (set.size() > max) return set.size();
            return max;
        }

    public static void main(String[] args) {
        System.out.println(new LongSubString().lengthOfLongestSubstring("pwwkew"));
    }


}
