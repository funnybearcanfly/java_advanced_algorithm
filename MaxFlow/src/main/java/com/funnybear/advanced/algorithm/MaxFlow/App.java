package com.funnybear.advanced.algorithm.MaxFlow;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		Vertex vertex0 = new Vertex("s");
		Vertex vertex1 = new Vertex("A");
		Vertex vertex2 = new Vertex("B");
		Vertex vertex3 = new Vertex("t");

		vertex0.addEdge(new Edge(vertex0, vertex1, 4));
		vertex0.addEdge(new Edge(vertex0, vertex2, 5));
		vertex1.addEdge(new Edge(vertex1, vertex3, 7));
		vertex2.addEdge(new Edge(vertex2, vertex1, 4));
		vertex2.addEdge(new Edge(vertex2, vertex3, 1));

		FordFulkersonImp fordFulkerson = new FordFulkersonImp();
		fordFulkerson.findMaxFlow(vertex0, vertex3);
		
	}

}
