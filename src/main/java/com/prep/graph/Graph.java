package com.prep.graph;

public class Graph {
	private int vertices; // No. of vertices
	private int adj[][]; // Adjacency Lists

	public Graph(int vertices, int[][] adj) {
		super();
		this.vertices = vertices;
		this.adj = adj;
	}
	
	public Graph(int vertices) {
		super();
		this.vertices = vertices;
		this.adj= new int[vertices][vertices];
	}

	public void addEdge(int v, int w) {
		adj[v][w] =  1;
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public int[][] getAdj() {
		return adj;
	}

	public void setAdj(int[][] adj) {
		this.adj = adj;
	}

}
