package main.graph.traversal;

import main.graph.Graph;

import java.util.Stack;

public class MaxEgdeInDag {

    private void topologicalSort(Graph graph){

        if(graph == null) return;

        boolean visit[] = new boolean[graph.getV()];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<graph.getV(); i++){
            if(!visit[i]){
                dfs(i, graph, visit, stack);
            }
        }


    }

    private void dfs(int vert, Graph graph, boolean[] visit, Stack<Integer>stack){

        visit[vert] = true;

        for(int i : graph.getAdj()[vert]){
            if(!visit[i]){
                dfs(i, graph, visit, stack);

            }
        }

        for(int i=0; i<graph.getV(); i++){
            if(i!= vert && visit[i] && !graph.getAdj()[vert].contains(i) && !graph.getAdj()[i].contains(vert)){
                System.out.println(" from " + vert +  " to " + i);

            }
        }

        stack.add(vert);
    }


    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        new MaxEgdeInDag().topologicalSort(g);
    }


}
