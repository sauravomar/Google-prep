package main.leetcode;

import java.util.HashSet;

public class VowelSpellChecker {

    HashSet<Character> vowels = new HashSet<>();

    class Trie {
        private Trie[] caps = new Trie[26];
        private Trie[] small = new Trie[26];
        private boolean isEnd;

        public void insert(Trie root, String str) {

            if (str.length() == 0) {
                root.isEnd = true;
                return;
            }

            char ch = str.charAt(0);

            if (Character.isLowerCase(ch)) {
                if (root.small[ch - 'a'] == null) root.small[ch - 'a'] = new Trie();
                insert(root.small[ch - 'a'], str.substring(1));
            } else {
                if (root.caps[ch - 'A'] == null) root.caps[ch - 'A'] = new Trie();
                insert(root.caps[ch - 'A'], str.substring(1));
            }

        }

        public String search(Trie root, String str) {

            if (root.isEnd && str.length() == 0) return "";
            if (str.length() == 0) return "";

            char ch = str.charAt(0);


            if (Character.isLowerCase(ch)) {
                if (root.small[ch - 'a'] != null && str.length() == 1 && root.small[ch - 'a'].isEnd) {
                    return "" + ch;
                }

                if (root.small[ch - 'a'] != null) {
                    String res = search(root.small[ch - 'a'], str.substring(1));
                    if (res.length() > 0) return ch + res;
                    else return "";
                }

                if (vowels.contains(Character.toLowerCase(ch))) {
                    for (char c : vowels) {
                        if (root.small[c - 'a'] != null) {
                            String result = search(root.small[c - 'a'], str.substring(1));
                            if (result.length() > 0) return c + result;
                        }
                    }
                }

            } else {
                if (root.caps[ch - 'A'] != null && str.length() == 1 && root.caps[ch - 'A'].isEnd) {
                    return "" + ch;
                }

                if (root.caps[ch - 'A'] != null) {
                    String res = search(root.caps[ch - 'A'], str.substring(1));
                    if (res.length() != 0) return ch + res;
                    else return "";
                }
                if (vowels.contains(Character.toLowerCase(ch))) {
                    for (char c : vowels) {
                        if (root.caps[c - 'A'] != null) {
                            String result = search(root.caps[c - 'A'], str.substring(1));
                            if (result.length() > 0) return c + result;
                        }
                    }
                }

            }


            return "";

        }
    }


    public String[] spellchecker(String[] wordlist, String[] queries) {

        String[] result = new String[queries.length];

        if (wordlist.length == 0) return wordlist;

        HashSet<Character> vowels = new HashSet<>();

        Trie trie = new Trie();

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (String words : wordlist) {
            trie.insert(trie, words);
        }

        int index = 0;

        for (String query : queries) {
            String searchResult = trie.search(trie, query);
            result[index] = searchResult;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        String words[] = {"KiTe", "kite", "hare", "Hare"};
        String[] queries = {"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};

        System.out.println(new VowelSpellChecker().spellchecker(words, queries));
    }
}
