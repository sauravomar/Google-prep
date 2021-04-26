package main.graph.traversal;

import com.sun.org.apache.regexp.internal.RE;
import main.graph.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CheckBiParititeGraph {

    public boolean isBipariteGraph(Graph graph, int src){

        if( null == graph || graph.getV() == 0 ) return  true;

        String color[] = new String[graph.getV()];
        boolean  visit[] = new boolean[graph.getV()];
        String BLUE = "BLUE";
        String RED = "RED";

        Queue<Integer>queue = new LinkedList<>();

        queue.add(src);
        visit[src] = true;
        color[src] = RED;

        while( !queue.isEmpty()){
            int start = queue.remove();

            for(int neigh:   graph.getAdj()[start]){
                if(neigh == start || color[start] == color[neigh]) return false;
                else if(!visit[neigh]) {
                    queue.add(neigh);
                    if(color[start] == BLUE) color[neigh] = RED;
                    else color[neigh] = BLUE;

                    visit[neigh] = true;

                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        g.addEdge(3, 2);

       System.out.println(new CheckBiParititeGraph().isBipariteGraph(g, 0));

    }

}
