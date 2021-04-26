package main.graph.traversal;

import main.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CountNoOfForest {


    public int  getTotalForest(Graph graph){

        if( null == graph)  return 0;
        int count = 0;

        boolean visited[] = new boolean[graph.getV()];

        for(int neigh =0; neigh<graph.getV(); neigh++){

            if(!visited[neigh]){
                visited[neigh] = true;
                count++;
                traverse(graph, neigh, visited);
            }
        }
        return  count;
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
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(3, 4);


        System.out.println(new CountNoOfForest().getTotalForest(g));
    }

}
