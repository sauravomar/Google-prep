package main.graph.traversal;

import main.graph.Graph;

import java.util.Stack;

public class TopologicalSort {


    public void topologicalSortUtil(Graph graph){

        if( null == graph || graph.getV() == 0 ) return;

        boolean  visit[] = new boolean[graph.getV()];
        Stack<Integer>stack = new Stack<>();

        for(int i=0; i<graph.getV(); i++){
            if(!visit[i]) {
                topologicalSort(i,graph, stack, visit);
            }
        }

        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }

    }


    public void topologicalSort(int ele, Graph graph, Stack<Integer>stack, boolean visited[]){


        for(int neigh :  graph.getAdj()[ele]){
            if(!visited[neigh]){
                topologicalSort(neigh,graph,stack, visited);
            }
        }
        visited[ele] = true;
        stack.add(ele);

    }

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        new TopologicalSort().topologicalSortUtil(g);
    }
}


