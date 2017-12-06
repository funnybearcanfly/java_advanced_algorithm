package com.funnybear.advanced.algorithm.SpinningTree.Prims;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

	private String name;
	private boolean visited;
	private Vertex previousVertex;
	private List<Edge> adjacencies;
	
	// For eager implementation
	private Edge minEdge;
	private double distance = Double.POSITIVE_INFINITY;

	public Vertex(String name) {
		this.name = name;
		this.visited = false;
		this.adjacencies = new ArrayList<>();
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public List<Edge> getAdjacencies() {
		return adjacencies;
	}

	public Edge getMinEdge() {
		return minEdge;
	}

	public void setMinEdge(Edge minEdge) {
		this.minEdge = minEdge;
	}

	public void addEdge(Edge edge) {
		this.adjacencies.add(edge);
	}

	public double getDistance() {
		return distance;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public int compareTo(Vertex o) {
		return Double.compare(this.distance, o.getDistance());
	}

}
