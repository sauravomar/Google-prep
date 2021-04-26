package main.graph.traversal;

import main.graph.Graph;

import java.util.Arrays;

public class TransitiveClosure {

    private int[][] trans;

    public void transitiveClosure(Graph graph) {

        if (null == graph || graph.getV() == 0) return;

        this.trans = new int[graph.getV()][graph.getV()];
        for (int i = 0; i < graph.getV(); i++) {
            dfsUtil(graph, i, i);
        }

        for (int i = 0; i < graph.getV(); i++) {
            System.out.println(Arrays.toString(trans[i]));
        }
    }


    public void dfsUtil(Graph graph, int start, int end) {

        trans[start][end] = 1;

        for (int neigh : graph.getAdj()[end]) {
            if (trans[start][neigh] == 0) {
                dfsUtil(graph, start, neigh);
            }
        }
    }

    public static void main(String[] args) {

        // Create a graph given
        // in the above diagram
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Transitive closure " +
                "matrix is");

        new TransitiveClosure().transitiveClosure(g);

    }
}
