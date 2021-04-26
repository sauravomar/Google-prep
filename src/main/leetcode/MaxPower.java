package main.leetcode;

public class MaxPower {

    public int maxPower(String s) {

        if (s.length() == 0) return 0;

        char ch = s.charAt(0);

        int maxCount = 1;
        int internalCount = 0;

        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == ch) {
                internalCount++;
                continue;
            }
            if(maxCount < internalCount)maxCount = internalCount;
            internalCount = 1;
            ch = s.charAt(i);
        }
        return maxCount;
    }

    public static void main(String[] args) {

    }
}
