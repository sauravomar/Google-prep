package main.leetcode;

public class PallindromicSubstrings {


    public int countSubstrings(String s) {

        if (s.length() == 0) return 0;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            int j = 0;

            while (i + j < s.length() && i - j >= 0) {

                // even length
                if (s.charAt(i + j) == s.charAt(i - j)) {
                    count++;
                    j++;
                } else {
                    break;
                }

            }

            j = 0;

            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {

                while (i + j + 1 < s.length() && i - j >= 0) {

                    if (s.charAt(i + j + 1) == s.charAt(i - j)) {
                        count++;
                        j++;
                    } else {
                        break;
                    }

                }
            }
        }

        return count;

    }
}
