package com.funnybear.advanced.algorithm.SpinningTree.Prims;

public class Edge implements Comparable<Edge> {

	private Vertex startVertex;
	private Vertex targetVertex;
	private double weight;
	
	public Edge(Vertex startVertex, Vertex targetVertex, double weight) {
		this.startVertex = startVertex;
		this.targetVertex = targetVertex;
		this.weight = weight;
	}

	public Vertex getStartVertex() {
		return startVertex;
	}
	
	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public double getWeight() {
		return weight;
	}
	
	@Override
	public int compareTo(Edge edge) {
		return Double.compare(this.weight, edge.weight);
	}

}
