package main.leetcode;

public class SmallestStringWithDigits {


    public String getSmallestString(int n, int k) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append('a');
        }

        int totalSum = k - n;
        int start = 0;

        while (totalSum > 0) {
            int len = sb.length() - start - 1;
            char ch = 'a';
            if (totalSum >= 25) {
                totalSum = totalSum - 25;
                ch = (char) (ch + 25);
            } else {
                ch = (char) (ch + totalSum);
                totalSum = 0;

            }
            sb.setCharAt(len, ch);
            start++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SmallestStringWithDigits().getSmallestString(5, 73));
    }
}
