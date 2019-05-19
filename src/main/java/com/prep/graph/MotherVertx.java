package com.prep.graph;

public class MotherVertx {

	/*
	 * Let the last finished vertex be v. Basically, we need to prove that there
	 * cannot be an edge from another vertex u to v if u is not another mother
	 * vertex (Or there cannot exist a non-mother vertex u such that u-→v is an
	 * edge). There can be two possibilities.
	 * 
	 * Recursive DFS call is made for u before v. If an edge u-→v exists, then v
	 * must have finished before u because v is reachable through u and a vertex
	 * finishes after all its descendants. Recursive DFS call is made for v before
	 * u. In this case also, if an edge u-→v exists, then either v must finish
	 * before u (which contradicts our assumption that v is finished at the end) OR
	 * u should be reachable from v (which means u is another mother vertex).
	 * 
	 */
	public void motherVertx(Graph g) {

		boolean[] visited = new boolean[g.getVertices()];
		DFS dfs = new DFS(visited, g);

		int motherVertx = 0;

		for (int i = 0; i < g.getVertices(); i++) {

			if (visited[i] == false) {
				dfs.dfs(i);
				motherVertx = i;
			}
		}

		visited = new boolean[g.getVertices()];
		dfs.setVisited(visited);
		dfs.dfs(motherVertx);

		for (int i = 0; i < g.getVertices(); i++) {

			if (visited[i] == false) {
				System.out.println("Not exist");
			}
		}
		System.out.println("Mother vertx " + motherVertx);

	}

	public static void main(String[] args) {
		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 3);
		g.addEdge(4, 1);
		g.addEdge(6, 4);
		g.addEdge(5, 6);
		g.addEdge(5, 2);
		g.addEdge(6, 0);

		new MotherVertx().motherVertx(g);

	}
}
