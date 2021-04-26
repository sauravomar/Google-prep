package main.graph.traversal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WeightGraph {

    int v;

    Map<Integer, Integer> adj[];

    public WeightGraph(int vertices){
        this.v = vertices;
        adj = new HashMap[v];

        for (int i=0; i<vertices; i++){
            adj[i]= new HashMap<>();

        }
    }

    public void addEdge(int start, int end, int weight){
        adj[start].put(end, weight);
        adj[end].put(start, weight);

    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public Map<Integer,Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(Map<Integer, Integer>[] adj) {
        this.adj = adj;
    }
}
