package com.prep.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	public void bfs(Graph g, int source) {
		if(g.getVertices() == 0) return;
		
		boolean visited[] = new boolean[g.getVertices()];
		Queue<Integer>queue = new LinkedList<Integer>();
		queue.add(source);
		visited[source] = true;
		System.out.println("node " + source) ;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for(int i =0;i <g.getVertices(); i++ ) {
				if(g.getAdj()[node][i] ==1 &&  !visited[i]) {
					System.out.println("node " + i) ;
					queue.add(i);
					visited[i] = true;
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
        
        new BFS().bfs(g, 1);
	}
}
