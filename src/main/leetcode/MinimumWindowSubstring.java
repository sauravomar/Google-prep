package main.leetcode;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {

        int length = 0;

        int uniqlength = 0;

        int start = 0;

        int freqMap[] = new int[256];

        int freqMapStr[] = new int[256];

        int min_len = Integer.MAX_VALUE;
        int start_index = 0;


        for (int i = 0; i < t.length(); i++) {
            freqMap[t.charAt(i)]++;
            if (freqMap[t.charAt(i)] == 1) uniqlength++;
        }

        for (int i = 0; i < s.length(); i++) {
            freqMapStr[s.charAt(i)]++;

            if (freqMapStr[s.charAt(i)] == freqMap[s.charAt(i)]) {
                length++;
            }

            if (uniqlength <= length) {
                while (start < s.length() && freqMapStr[s.charAt(start)] > freqMap[s.charAt(start)]) {
                    freqMapStr[s.charAt(start)]--;
                    start++;
                }

                int len_window = i - start + 1;
                if (min_len > len_window) {
                    min_len = len_window;
                    start_index = start;
                }

            }

        }

        if (min_len == Integer.MAX_VALUE) return "";
        else return s.substring(start_index, start_index + min_len);

    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ab", "A"));
    }
}
