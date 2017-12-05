package com.funnybear.advanced.algorithm.ShortestPathAlgorithm.DAG;

import java.util.ArrayList;
import java.util.List;

import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Edge;
import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Vertex;

public class App {

	public static void main(String[] args) {

		Vertex vertexA = new Vertex("A");
		Vertex vertexB = new Vertex("B");
		Vertex vertexC = new Vertex("C");
		
		List<Vertex> vertexList = new ArrayList<Vertex>();
		vertexList.add(vertexA);
		vertexList.add(vertexB);
		vertexList.add(vertexC);
		
		vertexA.addNeighbour(new Edge(1, vertexA, vertexB));
		vertexA.addNeighbour(new Edge(1, vertexA, vertexC));
		vertexA.addNeighbour(new Edge(1, vertexB, vertexC));
		
		AcyclicShortestPath acyclicShortestPath = new AcyclicShortestPath();

		acyclicShortestPath.shortestPath(vertexList, vertexA, vertexC);
		
	}

}
