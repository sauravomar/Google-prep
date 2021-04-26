package main.graph.traversal;

import main.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;


public class BreadthfirstSearch {

    public void bfs(Graph graph, int src){
        if( null == graph)  return;


        boolean visited [] = new boolean[graph.getV()];

        Queue<Integer>queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        while(!queue.isEmpty()){

            int source = queue.poll();

            System.out.println("visited " + source);

            for(int vertices :graph.getAdj()[source]){
                if(!visited[vertices]){
                    visited[vertices] = true;
                    queue.add(vertices);
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

        new BreadthfirstSearch().bfs(g,0);

    }
}
