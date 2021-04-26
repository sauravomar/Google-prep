package main.leetcode;

public class TwoDigitMax {

    public int solution(String S) {

        if (S.length() == 0) return 0;

        int max = 0;

        for (int i = 0; i < S.length() - 1; i++) {
            int val = Integer.parseInt(S.substring(i, i + 2));
            if (val > max) max = val;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new TwoDigitMax().solution("88"));
    }
}
