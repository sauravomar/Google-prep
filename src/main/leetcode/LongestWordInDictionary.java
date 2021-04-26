package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LongestWordInDictionary {

    class Trie {
        private Trie[] child = new Trie[26];
        private boolean isEnd;

        public void insert(Trie root, String str) {
            if (root == null) return;

            if (str.length() == 0) {
                root.isEnd = true;
                return;
            }
            if (root.child[str.charAt(0) - 'a'] == null) root.child[str.charAt(0) - 'a'] = new Trie();
            insert(root.child[str.charAt(0) - 'a'], str.substring(1));
        }
    }

    public String findLongestWord(String s, List<String> d) {

        Trie root = new Trie();

        for (String str : d) {
            root.insert(root, str);
        }
        return search(root, s);
    }

    private String search(Trie trie, String str) {

        if (str.length() == 0) {
            return "";
        }

        String result = null;
        for (int i = 0; i < str.length(); i++) {
            if (trie.child[str.charAt(i) - 'a'] != null) {
                if ( i == 0 || i > 0 && str.charAt(i - 1) != str.charAt(i)) {

                    String internalResult = search(trie.child[str.charAt(i) - 'a'], str.substring(i + 1));

                    if (internalResult != null) {

                        if (internalResult.length() == 0 && trie.isEnd) {
                            return str.charAt(i) + "";
                        } else if (result == null || internalResult.length() + 1 > result.length())
                            result = str.charAt(i) + internalResult;
                    }
                }
            }
        }

        if (trie.isEnd && (result == null || result.length() == 0)) return "";
        return result;
    }

    public static void main(String[] args) {
        String s = "aaa";
        List<String> d = new ArrayList<>();
        d.add("aa");
        d.add("aaa");
        d.add("a");

        System.out.println(new LongestWordInDictionary().findLongestWord(s, d));
    }
}
