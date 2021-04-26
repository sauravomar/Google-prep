package main.leetcode;

import java.util.*;

public class WordLaddeer {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        if (wordList.size() == 0) return 0;
        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int depth = 0;

        while (!queue.isEmpty()) {
            depth = depth + 1;

            int lsize = queue.size();

            while (lsize-- > 0) {
                String curr = queue.peek();
                queue.remove();
                for (int i = 0; i < curr.length(); ++i) {
                    StringBuilder temp = new StringBuilder(curr);
                    for (char c = 'a'; c <= 'z'; ++c) {
                        temp.setCharAt(i, c);

                        if (curr.equalsIgnoreCase(temp.toString()))
                            continue;   //Skip the same word
                        if (temp.toString().equalsIgnoreCase(endWord))
                            return depth + 1; //endWord found
                        if (set.contains(temp.toString())) {
                            queue.add(temp.toString());
                            set.remove(temp.toString());
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("tog");
        wordList.add("cog");

        System.out.println(new WordLaddeer().ladderLength("hit", "cog", wordList));

    }
}
