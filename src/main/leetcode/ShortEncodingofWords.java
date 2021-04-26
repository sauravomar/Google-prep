package main.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ShortEncodingofWords {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
    }

    public boolean adder(String word, TrieNode root) {
        boolean newNeed = false;
        for (int i = word.length() - 1; i >= 0; --i) {
            char c = word.charAt(i);
            if (root.child[c - 'a'] == null) {
                newNeed = true;
                root.child[c - 'a'] = new TrieNode();
            }
            root = root.child[c - 'a'];
        }
        return newNeed;
    }

    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length < 1) return 0;
        Arrays.sort(words, (a, b) -> b.length() - a.length());
        TrieNode root = new TrieNode();
        int len = 0;
        for (String word : words) {
            if (adder(word, root)) {
                len += word.length() + 1;
            }
        }
        return len;
    }

}
