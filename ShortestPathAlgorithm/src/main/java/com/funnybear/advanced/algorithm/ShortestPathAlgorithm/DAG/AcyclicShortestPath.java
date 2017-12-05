package com.funnybear.advanced.algorithm.ShortestPathAlgorithm.DAG;

import java.util.List;
import java.util.Stack;

import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Edge;
import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Vertex;

public class AcyclicShortestPath {

	public void shortestPath(List<Vertex> vertexList, Vertex sourceVertex, Vertex targetVertex) {

		sourceVertex.setDistance(0);
		TopologicalSort topologicalSort = new TopologicalSort();
		topologicalSort.makeTopologicalOrder(vertexList);

		Stack<Vertex> stack = topologicalSort.getTopologicalOrder();

		for (Vertex actualVertex : stack) {

			for (Edge edge : actualVertex.getAdjacencies()) {

				Vertex u = edge.getStartVertex();
				Vertex v = edge.getTargetVertex();

				double newDistance = u.getDistance() + edge.getWeight();

				if (newDistance < v.getDistance()) {
					v.setDistance(newDistance);
					v.setPreviousVertex(u);
				}

			}

		}

		if (targetVertex.getDistance() == Double.MAX_VALUE) {
			System.out.println("No shortest path there...");
		} else {
			System.out.println("Target vertex shortest path: " + targetVertex.getDistance());
			printPathTo(targetVertex);
		}

	}

	private void printPathTo(Vertex v) {

		if (v.getPreviousVertex() == null) {
			System.out.print(v + " ");
			return;
		}

		printPathTo(v.getPreviousVertex());
		System.out.print(v + " ");

	}

}