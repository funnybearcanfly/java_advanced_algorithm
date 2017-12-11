package com.funnybear.advanced.algorithm.MaxFlow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FordFulkersonImp {

	private double maxFlow;

	public void findMaxFlow(Vertex sourceVertex, Vertex targetVertex) {

		while (true) {
			List<Vertex> orderedVertex = getResidualTopologicalOrder(sourceVertex, targetVertex);

			if (orderedVertex == null)
				break;

			List<Vertex> shortestPath = findResidualShortestPath(orderedVertex, sourceVertex, targetVertex);
			updateFlow(shortestPath);
		}

		System.out.println("Max flow from " + sourceVertex + " to " + targetVertex + " is " + maxFlow);

	}

	private List<Vertex> getResidualTopologicalOrder(Vertex sourceVertex, Vertex targetVertex) {

		Queue<Vertex> queue = new LinkedList<>();
		List<Vertex> order = new ArrayList<>();

		queue.add(sourceVertex);

		while (!queue.isEmpty()) {
			Vertex v = queue.poll();
			order.add(v);

			if (v == targetVertex) {
				return order;
			}

			for (Edge edge : v.getAdjacencies()) {
				if (edge.getResidualFlow() > 0) {
					queue.add(edge.getTargetVertex());
				}
			}
		}

		return null;

	}

	private List<Vertex> findResidualShortestPath(List<Vertex> orderedVertex, Vertex sourceVertex, Vertex targetVertex) {

		for (Vertex v : orderedVertex) {
			v.setDistance(Double.POSITIVE_INFINITY);
			v.setPreviousVertex(null);
		}

		sourceVertex.setDistance(0);
		sourceVertex.setPreviousVertex(null);

		for (Vertex v : orderedVertex) {
			for (Edge edge : v.getAdjacencies()) {
				if (edge.getResidualFlow() > 0) {
					Vertex target = edge.getTargetVertex();
					double distance = v.getDistance() + edge.getResidualFlow();
					if (distance < target.getDistance()) {
						target.setDistance(distance);
						target.setPreviousVertex(v);
					}
				}
			}
		}

		List<Vertex> list = new ArrayList<>();
		Vertex vertex = targetVertex;
		while (vertex.getPreviousVertex() != null) {
			list.add(vertex);
			vertex = vertex.getPreviousVertex();
		}

		list.add(sourceVertex);

		Collections.reverse(list);

		return list;

	}

	private void updateFlow(List<Vertex> shortestPath) {

		double minValue = Double.POSITIVE_INFINITY;

		List<Edge> edgeList = new ArrayList<>();

		for (int i = 0; i < shortestPath.size() - 1; i++) {
			Vertex v = shortestPath.get(i);
			Vertex u = shortestPath.get(i + 1);

			for (Edge edge : v.getAdjacencies()) {
				if (edge.getTargetVertex() == u) {
					edgeList.add(edge);
					if (edge.getResidualFlow() < minValue) {
						minValue = edge.getResidualFlow();
					}
				}
			}
		}

		for (Edge edge : edgeList) {
			edge.addFlow(minValue);
		}

		maxFlow += minValue;

		System.out.println(edgeList);
		
	}

}
