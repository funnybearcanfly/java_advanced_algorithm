package com.funnybear.advanced.algorithm.BreadthFirstSearch.Basic;

public class App {

	public static void main(String[] args) {

		BFS bfs = new BFS();

		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);

		v1.addNeighbourVertex(v2);
		v1.addNeighbourVertex(v4);
		v2.addNeighbourVertex(v3);
		v4.addNeighbourVertex(v5);

		bfs.bfs(v1);

	}

}