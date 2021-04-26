package main.graph.traversal;

import main.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class DepthFirstSearch {


    public void dfs(Graph graph, int src){
        if( null == graph)  return;
        boolean visited[] = new boolean[graph.getV()];
        traverse(graph, src, visited);
    }

    public void traverse(Graph graph, int src, boolean visited[]){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        while(!queue.isEmpty()){
            int source = queue.poll();
            for(int vertices :graph.getAdj()[source]){
                if(!visited[vertices]){
                    System.out.println("visited " + source);
                    visited[vertices] = true;
                    queue.add(vertices);
                    traverse(graph, vertices,visited);
                }
            }
        }

    }


    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        new DepthFirstSearch().dfs(g,0);

    }
}
