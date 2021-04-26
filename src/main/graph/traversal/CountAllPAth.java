package main.graph.traversal;

import main.graph.Graph;
public class CountAllPAth {

    public int  getAllPaths(Graph graph, int src, int end){
        if( null == graph)  return 0;
        int count = 0;

        boolean visited[] = new boolean[graph.getV()];

        for(int neigh:  graph.getAdj()[src]){
            visited[neigh] = true;
            count =  count + traverse(graph, visited, neigh,end);
            visited[neigh] = false;
        }
        return  count;
    }



    public int traverse(Graph graph, boolean visited[], int src, int end){
        int count = 0;

        if(src == end) return 1;

        for(int neigh:  graph.getAdj()[src]){
            if(neigh == end) return 1;
            if(!visited[neigh]) {
                visited[neigh] = true;
                count = count + traverse(graph, visited, neigh, end);
                visited[neigh] = false;
            }
        }
        return  count;
    }


    public static void main(String[] args) {

        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        int s = 0, d = 3;

        System.out.println(new CountAllPAth().getAllPaths(g,s, d));

    }
}
