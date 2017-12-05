package com.funnybear.advanced.algorithm.ShortestPathAlgorithm.BellmanFord;

import java.util.ArrayList;
import java.util.List;

import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Edge;
import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Vertex;

public class App {

	public static void main(String[] args) {

		List<Vertex> vertexList = new ArrayList<Vertex>();

		vertexList.add(new Vertex("A"));
		vertexList.add(new Vertex("B"));
		vertexList.add(new Vertex("C"));

		List<Edge> edgeList = new ArrayList<Edge>();

		edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));
		edgeList.add(new Edge(-3, vertexList.get(0), vertexList.get(2)));
		edgeList.add(new Edge(1, vertexList.get(1), vertexList.get(2)));

		/* This is the case for negative cycle. */
		// edgeList.add(new Edge(1, vertexList.get(0), vertexList.get(1)));
		// edgeList.add(new Edge(-3, vertexList.get(1), vertexList.get(2)));
		// edgeList.add(new Edge(1, vertexList.get(2), vertexList.get(0)));

		BellmanFordImp bellmanFord = new BellmanFordImp(vertexList, edgeList);

		bellmanFord.bellmanFord(vertexList.get(0), vertexList.get(2));

	}

}