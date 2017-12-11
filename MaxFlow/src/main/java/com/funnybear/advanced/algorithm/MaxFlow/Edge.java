package com.funnybear.advanced.algorithm.MaxFlow;

public class Edge {

	private Vertex sourceVertex;
	private Vertex targetVertex;
	private double capacity;
	private double flow;
	private double residualFlow;

	public Edge(Vertex sourceVertex, Vertex targetVertex, double capacity) {
		this.sourceVertex = sourceVertex;
		this.targetVertex = targetVertex;
		this.capacity = capacity;
		this.flow = 0;
		this.residualFlow = capacity;
	}

	public double getFlow() {
		return flow;
	}

	public void addFlow(double flow) {
		this.flow += flow;
		this.residualFlow = capacity - this.flow;
	}

	public double getResidualFlow() {
		return residualFlow;
	}

	public Vertex getSourceVertex() {
		return sourceVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public double getCapacity() {
		return capacity;
	}

	@Override
	public String toString() {
		return sourceVertex + " to " + targetVertex + ". Flow: " + flow + ", Residual Flow: " + residualFlow;
	}

}
