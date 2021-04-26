package main.leetcode;

public class LongestPallindromeSubString {

    private String convertToNewString(String s) {
        String newString = "@";

        for (int i = 0; i < s.length(); i++) {
            newString += "#" + s.subSequence(i, i + 1);
        }

        newString += "#$";
        return newString;
    }

    public String longestPalindrome(String s) {

        String newStr = convertToNewString(s);
        int count[] = new int[newStr.length()];

        int c = 0;
        int r = 0;
        int max = 0;

        int maxPalindrome = 0;
        int centerIndex = 0;


        for (int i = 0; i < count.length; i++) {

            int mirr = 2 * c - 1;

            if (i < r) count[i] = Math.min(r - i, count[mirr]);


            int a = i + (1 + count[i]);
            int b = i - (1 + count[i]);


            while (a < count.length && b > 0 && newStr.charAt(a) == newStr.charAt(b)) {
                count[i]++;
                a++;
                b--;
            }

            if (count[i] > maxPalindrome) {
                maxPalindrome = count[i];
                centerIndex = i;
            }

            if (i + count[i] > r) {
                c = i;
                r = i + count[i];
            }
        }
        return maxPalindrome % 2 == 0 && maxPalindrome != s.length() ?
                s.substring((centerIndex - 1 - maxPalindrome) / 2, maxPalindrome + 1) : s.substring((centerIndex - 1 - maxPalindrome) / 2, maxPalindrome);

    }

//    public String longestPalindrome(String s) {
//        if (s.isEmpty()) {
//            return null;
//        }
//
//        if (s.length() == 1) {
//            return s;
//        }
//
//        String longest = s.substring(0, 1);
//        for (int i = 0; i < s.length(); i++) {
//            // get longest palindrome with center of i
//            String tmp = helper(s, i, i);
//            if (tmp.length() > longest.length()) {
//                longest = tmp;
//            }
//
//            // get longest palindrome with center of i, i+1
//            tmp = helper(s, i, i + 1);
//            if (tmp.length() > longest.length()) {
//                longest = tmp;
//            }
//        }
//
//        return longest;
//    }
//
//    // Given a center, either one letter or two letter,
//// Find longest palindrome
//    public String helper(String s, int begin, int end) {
//        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
//            begin--;
//            end++;
//        }
//        return s.substring(begin + 1, end);
//    }

    public static void main(String[] args) {
        System.out.println(new LongestPallindromeSubString().longestPalindrome("bb"));
    }
}
