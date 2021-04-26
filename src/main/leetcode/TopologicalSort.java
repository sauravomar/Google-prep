package main.leetcode;

import main.graph.Graph;

import java.util.Stack;

public class TopologicalSort {

    public void topologicalSort(Graph graph) {
        boolean visited[] = new boolean[graph.getV()];
        Stack<Integer> stack = new Stack<Integer>();


        for (int i = 0; i < graph.getV(); i++) {
            if (!visited[i]) topologicalSortUtil(i, graph, visited, stack);
            visited[i] = true;
        }

//        while (stack.empty() == false)
//            System.out.print(stack.pop() + " ");

    }

    private void topologicalSortUtil(int vertices, Graph graph, boolean visited[], Stack<Integer> stack) {
        if (visited[vertices]) return;
        for (int vert : graph.getAdj()[vertices]) {
            if (!visited[vert]) {
                topologicalSortUtil(vert, graph, visited, stack);
                visited[vert] = true;
            }
        }
        stack.push(vertices);
        System.out.println("vertices " + vertices);
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        new TopologicalSort().topologicalSort(g);

    }

}
