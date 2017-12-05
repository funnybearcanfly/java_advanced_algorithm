package com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common;

public class Edge {

	private double weight;
	private Vertex startVertex;
	private Vertex targetVertex;

	public Edge(double weight, Vertex startVertex, Vertex targetVertex) {
		this.weight = weight;
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
	}

	public double getWeight() {
		return weight;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

}
