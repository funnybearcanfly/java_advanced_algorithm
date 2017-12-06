package com.funnybear.advanced.algorithm.SpinningTree.Prims;

import java.util.List;
import java.util.PriorityQueue;

public class PrimsEagerImp {

	private List<Vertex> vertexList;
	private PriorityQueue<Vertex> heap;
	private double fullCost;

	public PrimsEagerImp(List<Vertex> vertexList) {
		this.vertexList = vertexList;
		this.heap = new PriorityQueue<>();
	}

	public void generateSpinningTree(Vertex vertex) {

		for (Vertex v : vertexList) {
			if (!vertex.isVisited()) {
				makePrimsJarnik(v);
			}
		}

	}

	private void makePrimsJarnik(Vertex vertex) {

		vertex.setDistance(0);
		heap.add(vertex);

		while (!heap.isEmpty()) {
			Vertex v = heap.remove();
			this.fullCost += v.getDistance();
			scanVertex(v);
		}

	}

	private void scanVertex(Vertex vertex) {

		vertex.setVisited(true);

		for (Edge edge : vertex.getAdjacencies()) {

			Vertex u = edge.getTargetVertex();

			if (u.isVisited())
				continue;

			if (edge.getWeight() < u.getDistance()) {

				u.setDistance(edge.getWeight());
				u.setMinEdge(edge);

				if (this.heap.contains(u)) {
					this.heap.remove(u);
				}

				this.heap.add(u);

			}

		}

	}

	public void showMST() {

		System.out.println("Eager - The minium spinning tree cost: " + this.fullCost);

		for (Vertex v : this.vertexList) {
			
			Edge edge = v.getMinEdge();
			
			if (edge != null) {
				System.out.println(edge.getStartVertex() + " - " + edge.getTargetVertex());
			}
			
		}

	}

}
