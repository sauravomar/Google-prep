package com.prep.graph;

public class CountAllPossiblePath {

	public int count(Graph g, boolean visited[], int source, int des) {
		int count = 0;

		visited[source] = true;
		
		if (source == des)
			return 1;

		for (int i = 0; i < g.getVertices(); i++) {
			if (g.getAdj()[source][i] == 1 && !visited[i]) {
				visited[i] = true;
				count = count + count(g, visited, i, des);
				visited[i] = false;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(1, 3);

		boolean visited[] = new boolean[4];
		System.out.println(new CountAllPossiblePath().count(g, visited, 2, 3));
	}
}
