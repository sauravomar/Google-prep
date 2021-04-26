package main.leetcode;

import java.util.Arrays;

public class TwoStringsArrayAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == null && word2 == null) return true;
        if ((word1 == null && word2 != null) || (word1 != null && word2 == null)) return false;
        String str1 = convertStringArrayToString(word1);
        String str2 = convertStringArrayToString(word2);
        return str1.equalsIgnoreCase(str2);

    }


    private String convertStringArrayToString(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr)
            sb.append(str);
        return sb.toString();
    }

    public static void main(String[] args) {
        String word1[] =  {"ecxarwyyy","ppf","tdyayjd"};
        String word2[] = {"ecxarwyyyppft","dyayj","q"};



        System.out.println(new TwoStringsArrayAreEquivalent().arrayStringsAreEqual(word1, word2));
    }

}
