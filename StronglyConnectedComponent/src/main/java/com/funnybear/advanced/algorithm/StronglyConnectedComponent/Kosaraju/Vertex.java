package com.funnybear.advanced.algorithm.StronglyConnectedComponent.Kosaraju;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private boolean forwardVisited;
	private boolean backwardVisited;

	private List<Edge> forwardAdjacencies;
	private List<Edge> backwardAdjacencies;

	public Vertex(String name) {
		this.name = name;
		this.forwardAdjacencies = new ArrayList<>();
		this.backwardAdjacencies = new ArrayList<>();
	}

	public void addForwardEdge(Edge edge) {
		this.forwardAdjacencies.add(edge);
		Vertex target = edge.getTargetVertex();
		Edge backwardEdge = new Edge(target, this);
		target.addBackwardEdge(backwardEdge);
	}

	public void addBackwardEdge(Edge edge) {
		this.backwardAdjacencies.add(edge);
	}

	public boolean isForwardVisited() {
		return forwardVisited;
	}

	public void setForwardVisited(boolean forwardVisited) {
		this.forwardVisited = forwardVisited;
	}

	public boolean isBackwardVisited() {
		return backwardVisited;
	}

	public void setBackwardVisited(boolean backwardVisited) {
		this.backwardVisited = backwardVisited;
	}

	public List<Edge> getForwardAdjacencies() {
		return forwardAdjacencies;
	}

	public List<Edge> getBackwardAdjacencies() {
		return backwardAdjacencies;
	}

	@Override
	public String toString() {
		return this.name;
	}

}
