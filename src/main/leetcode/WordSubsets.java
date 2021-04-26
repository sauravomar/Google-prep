package main.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {

        List<String> result = new ArrayList<>();

        if (A.length == 0 || B.length == 0) return result;

        int freq[] = new int[26];

        for (String str : B) {
            int[] arr = new int[27];
            for (int j = 0; j < str.length(); j++) {
                arr[str.charAt(j) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0 && arr[i] > freq[i]) {
                    freq[i] = arr[i];
                }
            }
        }

        for (String str : A) {


            int[] freqWord = new int[26];

            for (char ch : str.toCharArray()) {
                freqWord[ch - 'a']++;
            }

            int i = 0;

            for (i = 0; i < 26; i++) {
                if (freq[i] != 0 && freq[i] > freqWord[i]) {
                    break;
                }

                if (i >= 25) {
                    result.add(str);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str[] = {"amazon", "apple", "facebook", "google", "leetcode"};
        String words[] = {"e", "o"};

        System.out.println(new WordSubsets().wordSubsets(str, words));
    }
}


