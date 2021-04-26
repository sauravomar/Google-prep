package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        if (S == null || S.length() == 0) return result;

        result.add(S);
        permutation(S, result);

        return result;
    }

    private void permutation(String S, List<String> result) {

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            StringBuilder sb = new StringBuilder();

            if (Character.isLetter(ch)) {
                char toAppend = Character.isLowerCase(ch) ? Character.toUpperCase(ch) : Character.toLowerCase(ch);
                if (i == 0) {
                    sb.append(toAppend).append(S.substring(1, S.length()));
                } else {
                    sb.append(S.substring(0, i)).append(toAppend).append(S.substring(i + 1, S.length()));
                }
                if (!result.contains(sb.toString())) {
                    result.add(sb.toString());
                    permutation(sb.toString(), result);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LetterCasePermutation().letterCasePermutation("3z4"));
    }
}
