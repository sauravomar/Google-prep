package main.graph;

import java.util.LinkedList;

public class Graph {

    int v;

    LinkedList<Integer> adj[];

    public Graph(int vertices){
        this.v = vertices;
        adj = new LinkedList[v];

        for (int i=0; i<vertices; i++){
            adj[i]= new LinkedList<>();

        }
    }

    public void addEdge(int start, int end){
        adj[start].add(end);
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public LinkedList<Integer>[] getAdj() {
        return adj;
    }

    public void setAdj(LinkedList<Integer>[] adj) {
        this.adj = adj;
    }
}