package main.leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    class Trie {
        private Trie [] child = new Trie[26];
        private boolean isEnd;

        public void insert(Trie root, String str){

            if(str.length() == 0) {
                root.isEnd = true;
                return;
            }

            if(root.child[str.charAt(0) - 'a'] == null) root.child[str.charAt(0) - 'a'] =  new Trie();
            insert(root.child[str.charAt(0) - 'a'], str.substring(1));
        }

        public boolean search(Trie root, String str){

            if(root.isEnd && str.length() == 0) return true;
            if(str.length() == 0) return false;

            if(root.child[str.charAt(0) - 'a'] != null && str.length() == 1 && root.child[str.charAt(0) - 'a'].isEnd){
                return true;
            }

            if(root.child[str.charAt(0) - 'a'] != null){
               return search(root.child[str.charAt(0) - 'a'], str.substring(1));
            }
            return false;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        int size = s.length();

        // Base case
        if (size == 0)  return true;
        if(wordDict.size() == 0) return false;

        Trie root = new Trie();

        // Construct trie
        for(int i = 0; i < wordDict.size(); i++)
            root.insert(root, wordDict.get(i));

        return wordSearch(root, s);
    }


    private boolean wordSearch(Trie root, String s){

        int size = s.length();

        if(size == 0) return true;

        for(int i=0 ; i <=s.length(); i++){

            if (root.search(root,s.substring(0, i) ) &&
                    wordSearch(root,s.substring(i, size) )) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "bb";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("b");
        wordDict.add("bbb");
        wordDict.add("bbbb");

        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }
}
