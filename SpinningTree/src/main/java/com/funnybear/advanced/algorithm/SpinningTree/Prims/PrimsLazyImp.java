package com.funnybear.advanced.algorithm.SpinningTree.Prims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsLazyImp {

	private List<Vertex> unvisitedVertexes;
	private List<Edge> spinningTree;
	private PriorityQueue<Edge> edgeHeap;
	private double fullCost;

	public PrimsLazyImp(List<Vertex> vertextList) {

		this.unvisitedVertexes = new ArrayList<>();
		this.spinningTree = new ArrayList<>();
		this.edgeHeap = new PriorityQueue<>();

		for (Vertex v : vertextList) {
			this.unvisitedVertexes.add(v);
		}

	}

	public void generateSpinningTree(Vertex vertex) {

		Vertex currentVertex = vertex;
		this.unvisitedVertexes.remove(currentVertex);

		while (!this.unvisitedVertexes.isEmpty()) {

			for (Edge edge : currentVertex.getAdjacencies()) {
				if (this.unvisitedVertexes.contains(edge.getTargetVertex())) {
					this.edgeHeap.add(edge);
				}
			}

			Edge minEdge = this.edgeHeap.remove();
			while (!this.unvisitedVertexes.contains(minEdge.getTargetVertex())) {
				minEdge = this.edgeHeap.remove();
			}

			this.spinningTree.add(minEdge);
			this.fullCost += minEdge.getWeight();

			currentVertex = minEdge.getTargetVertex();
			this.unvisitedVertexes.remove(currentVertex);

		}

	}

	public void showMST() {

		System.out.println("Lazy - The minium spinning tree cost: " + this.fullCost);

		for (Edge edge : this.spinningTree) {
			System.out.println(edge.getStartVertex() + " - " + edge.getTargetVertex());
		}

	}

}
