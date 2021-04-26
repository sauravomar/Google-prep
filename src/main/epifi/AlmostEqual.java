package main.epifi;

import java.util.ArrayList;
import java.util.List;

public class AlmostEqual {

    public static List<String> areAlmostEquivalent(List<String> s, List<String> t) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.size(); i++) {
            result.add(isEqual(getCountArray(s.get(i)), getCountArray(t.get(i))));
        }
        return result;

    }


    private static int[] getCountArray(String str) {
        int count[] = new int[26];

        for (char ch : str.toCharArray()) {
            count[ch - 'a']++;
        }
        return count;
    }

    private static String isEqual(int[] s1, int s2[]) {
        String YES = "YES";
        String NO = "NO";
        for (int i = 0; i < 26; i++) {
            if (Math.abs(s1[i] - s2[i]) > 3) {
                return NO;
            }
        }
        return YES;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
