package com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Dijkstra;

import java.util.ArrayList;
import java.util.List;

import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Edge;
import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Vertex;

public class App {

	public static void main(String[] args) {
		
		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");
		Vertex v6 = new Vertex("v6");
		
		v1.addNeighbour(new Edge(1, v1, v2));
		v1.addNeighbour(new Edge(3, v1, v3));
		v1.addNeighbour(new Edge(4, v1, v4));
		v2.addNeighbour(new Edge(1, v2, v3));
		v2.addNeighbour(new Edge(2, v2, v5));
		v2.addNeighbour(new Edge(3, v2, v6));
		v3.addNeighbour(new Edge(2, v3, v6));
		
		List<Vertex> list = new ArrayList<Vertex>();
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);
		list.add(v6);
		
		DijkstraImp dijkstra = new DijkstraImp(list);
		dijkstra.searchShortestPath(v1);
		
	}

}