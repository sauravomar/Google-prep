package com.prep.graph;

import java.util.Stack;

public class DFS {

	boolean visited[];
	Graph g;

	public DFS(boolean[] visited, Graph g) {
		super();
		this.visited = visited;
		this.g = g;
	}

	public boolean[] getVisited() {
		return visited;
	}

	public void setVisited(boolean[] visited) {
		this.visited = visited;
	}

	public void dfs(int source) {

		if (g.getVertices() == 0)
			return;

		Stack<Integer> stack = new Stack<Integer>();
		stack.add(source);
		visited[source] = true;

		while (!stack.isEmpty()) {
			int node = stack.pop();
			visited[node] = true;

			System.out.println("node " + node);
			for (int i = 0; i < g.getVertices(); i++) {
				if (g.getAdj()[node][i] == 1 && !visited[i]) {
					stack.add(i);
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
		new DFS(new boolean[4], g).dfs(2);
	}

}
