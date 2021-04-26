package main.leetcode;

public class DecodeStringAtIndex {

    public String decodeAtIndex(String S, int K) {
        long len = 0;

        for (char c : S.toCharArray()) {
            if (Character.isDigit(c)) {
                len *= (c - '0');
            } else {
                ++len;
            }
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            K %= len;

            char c = S.charAt(i);

            if (K == 0 && c >= 'a' && c <= 'z') {
                return "" + c;
            }

            if (Character.isDigit(c)) {
                len /= (c - '0');
            } else {
                --len;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new DecodeStringAtIndex().decodeAtIndex("a23", 6));
    }
}
