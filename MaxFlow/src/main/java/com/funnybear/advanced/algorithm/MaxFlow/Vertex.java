package com.funnybear.advanced.algorithm.MaxFlow;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private List<Edge> adjacencies;
	private Vertex previousVertex;
	private double distance;

	public Vertex(String name) {
		this.name = name;
		this.adjacencies = new ArrayList<>();
	}

	public List<Edge> getAdjacencies() {
		return this.adjacencies;
	}

	public void addEdge(Edge edge) {
		this.adjacencies.add(edge);
	}

	public Vertex getPreviousVertex() {
		return previousVertex;
	}

	public void setPreviousVertex(Vertex previousVertex) {
		this.previousVertex = previousVertex;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return name;
	}

}
