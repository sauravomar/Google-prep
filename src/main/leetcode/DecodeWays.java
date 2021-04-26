package main.leetcode;

public class DecodeWays {

    public int numDecodings(String s) {

        if (s.length() == 0) return 0;
        if (s.length() >= 1 && s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;

        int totalWays = 0;
        int iterator = 0;


        while (iterator < s.length()) {
            int val = Character.digit(s.charAt(iterator), 10);
            if (val > 0 && totalWays == 0) totalWays = 1;
            if (val > 2 || val == 0) {
                iterator++;
                continue;
            } else {
                iterator++;
                if (iterator < s.length() - 1) {
                    int val2 = Character.digit(s.charAt(iterator), 10);
                    int val3 = Character.digit(s.charAt(iterator + 1), 10);

                    if (val > 2 && val2 == 0 || val == 0 && val2 == 0) return 0;
                    if (val3 == 0) continue;
                    if (val <= 2 && val2 <= 6 && val2 > 0) totalWays++;

                } else if (iterator < s.length()) {
                    int val2 = Character.digit(s.charAt(iterator), 10);
                    if (val > 2 && val2 == 0 || val == 0 && val2 == 0) return 0;
                    if (val <= 2 && val2 <= 6 && val2 > 0) totalWays++;

                }
            }
        }
        return totalWays;
    }

    public static void main(String[] args) {
        System.out.println(new DecodeWays().numDecodings("12061"));
    }
}
