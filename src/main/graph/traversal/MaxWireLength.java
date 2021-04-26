package main.graph.traversal;

import main.graph.Graph;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MaxWireLength {

    public void dfs(WeightGraph graph){
        if( null == graph)  return;


        int max = 0;

        for(int i=0;i<graph.getV(); i++){
            boolean visited[] = new boolean[graph.getV()];
         int length= traverse(graph, i, visited);


         if(max< length)max=length;

        }
        System.out.println("max " + max);

    }

    public int traverse(WeightGraph graph, int src, boolean visited[]){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        visited[src] = true;

        int max = 0;

        while(!queue.isEmpty()){
            int source = queue.poll();
            int len = 0;
            for(Map.Entry<Integer, Integer> vertices :graph.getAdj()[source].entrySet()){
                if(!visited[vertices.getKey()]){
                    System.out.println("visited " + vertices.getKey());
                    visited[vertices.getKey()] = true;
                    queue.add(vertices.getKey());
                    len = vertices.getValue() + traverse(graph, vertices.getKey(),visited);

                    if(max< len){
                        max = len;
                    }
                }
            }

        }

        return  max;

    }

    public static void main(String[] args) {
        WeightGraph g = new WeightGraph(6);

        g.addEdge(0, 1, 3);
        g.addEdge(1, 2,4);
        g.addEdge(1, 5,2);
        g.addEdge(5, 3, 6);
        g.addEdge(5, 4, 5);

        new MaxWireLength().dfs(g);

    }

}

