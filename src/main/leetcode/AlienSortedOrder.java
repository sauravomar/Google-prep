package main.leetcode;

public class AlienSortedOrder {

    public boolean isAlienSorted(String[] words, String order) {

        if (words.length == 0) return true;

        int sortSeq[] = new int[26];

        for (int i = 0; i < order.length(); i++) {
            sortSeq[order.charAt(i) - 'a'] = i;
        }


        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int k = 0;

            while (k < first.length() && k < second.length() && first.charAt(k) == second.charAt(k)) {
                k++;
            }

            if (k == second.length() && k == first.length()) continue;

            if (k == second.length()) return false;

            if (k == second.length()) continue;

            if (sortSeq[second.charAt(i) - 'a'] < sortSeq[first.charAt(i) - 'a']) return false;


        }

        return true;
    }
}
