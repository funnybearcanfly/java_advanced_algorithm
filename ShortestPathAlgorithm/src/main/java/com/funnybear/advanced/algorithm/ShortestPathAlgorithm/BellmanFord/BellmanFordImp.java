package com.funnybear.advanced.algorithm.ShortestPathAlgorithm.BellmanFord;

import java.util.List;

import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Edge;
import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Vertex;

public class BellmanFordImp {

	private List<Vertex> vertexList;
	private List<Edge> edgeList;

	public BellmanFordImp(List<Vertex> vertexList, List<Edge> edgeList) {
		this.vertexList = vertexList;
		this.edgeList = edgeList;
	}

	public void bellmanFord(Vertex sourceVertex, Vertex targetVertex) {

		sourceVertex.setDistance(0);

		for (int i = 0; i < vertexList.size() - 1; i++) {

			for (Edge edge : edgeList) {

				Vertex u = edge.getStartVertex();
				Vertex v = edge.getTargetVertex();

				if (u.getDistance() == Double.MAX_VALUE)
					continue;

				double newDistance = u.getDistance() + edge.getWeight();

				if (newDistance < v.getDistance()) {
					v.setDistance(newDistance);
					v.setPreviousVertex(u);
				}

			}

		}

		for (Edge edge : edgeList) {

			if (edge.getStartVertex().getDistance() != Double.MAX_VALUE) {

				if (hasCycle(edge)) {
					System.out.println("There is a negative cycle...");
					return;
				}

			}

		}

		if (targetVertex.getDistance() == Double.MAX_VALUE) {
			System.out.println("There is no path from " + sourceVertex + " to " + targetVertex);
		} else {
			System.out.println("Shortest path from " + sourceVertex + " to " + targetVertex + " : ");
			printPathTo(targetVertex);
		}

	}

	private boolean hasCycle(Edge edge) {
		return edge.getStartVertex().getDistance() + edge.getWeight() < edge.getTargetVertex().getDistance();
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