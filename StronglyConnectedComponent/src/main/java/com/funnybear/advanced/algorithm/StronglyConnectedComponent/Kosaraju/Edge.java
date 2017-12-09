package com.funnybear.advanced.algorithm.StronglyConnectedComponent.Kosaraju;

public class Edge {

	private Vertex sourceVertex;
	private Vertex targetVertex;

	public Edge(Vertex sourceVertex, Vertex targetVertex) {
		this.sourceVertex = sourceVertex;
		this.targetVertex = targetVertex;
	}

	public Vertex getSourceVertex() {
		return sourceVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

}
