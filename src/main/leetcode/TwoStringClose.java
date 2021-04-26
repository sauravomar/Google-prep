package main.leetcode;

import java.util.Arrays;

public class TwoStringClose {

    public boolean closeStrings(String word1, String word2) {

        if (word1.length() != word2.length()) return false;

        int f1[] = new int[26];
        int v1[] = new int[26];

        int f2[] = new int[26];
        int v2[] = new int[26];

        for (char ch : word1.toCharArray()) {
            f1[ch - 'a']++;
            v1[ch - 'a'] = 1;
        }

        for (char ch : word2.toCharArray()) {
            f2[ch - 'a']++;
            v2[ch - 'a'] = 1;
        }

        Arrays.sort(f1);
        Arrays.sort(f2);

        return Arrays.equals(f1, f2) && Arrays.equals(v1, v2);

    }
}
