package main.graph.traversal;

import main.graph.Graph;

public class AlienLanguage {

    public void createGraph(String[]words, int totalChar) {

        Graph graph = new Graph(totalChar);

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j)- 'a');
                    break;
                }
            }
        }

        new TopologicalSort().topologicalSortUtil(graph);
    }

    public static void main(String[] args) {
       String words[] = {"baa", "abcd", "abca", "cab", "cad"};
       new AlienLanguage().createGraph(words, 4);
    }

}
