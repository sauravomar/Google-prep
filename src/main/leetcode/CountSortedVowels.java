package main.leetcode;

public class CountSortedVowels {

    public int countVowelStrings(int n) {
        if (n == 0) return 0;
        String str[] = {"a", "e", "i", "o", "u"};
        return count(str, n, 0, "");

    }


    private int count(String str[], int n, int start, String s) {

        if (n == 0) {
            return 1;
        }

        int totalCount = 0;

        for (int i = start; i < 5; i++) {
            totalCount = totalCount + count(str, n - 1, i, s + str[i]);
        }
        return totalCount;
    }


    public static void main(String[] args) {
        System.out.println(new CountSortedVowels().countVowelStrings(33));
    }
}
