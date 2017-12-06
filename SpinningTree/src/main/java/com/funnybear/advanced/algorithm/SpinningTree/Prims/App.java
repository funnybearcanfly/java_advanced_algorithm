package com.funnybear.advanced.algorithm.SpinningTree.Prims;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		List<Vertex> vertexList = new ArrayList<>();
		
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		vertexList.add(v4);
		
		v1.addEdge(new Edge(v1, v2, 1));
		v1.addEdge(new Edge(v1, v3, 3));
		v1.addEdge(new Edge(v1, v4, 5));
		
		v2.addEdge(new Edge(v2, v3, 1));
		
		v3.addEdge(new Edge(v3, v4, 4));
		
		PrimsLazyImp lazyImp = new PrimsLazyImp(vertexList);
		lazyImp.generateSpinningTree(v1);
		lazyImp.showMST();
		
		PrimsEagerImp eagerImp = new PrimsEagerImp(vertexList);
		eagerImp.generateSpinningTree(v1);
		eagerImp.showMST();
		
	}

}
