package com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Dijkstra;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Edge;
import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Vertex;

public class DijkstraImp {

	private List<Vertex> list;

	private Queue<Vertex> distanceQueue;

	public DijkstraImp(List<Vertex> list) {

		this.list = list;
		this.distanceQueue = new PriorityQueue<Vertex>(new Comparator<Vertex>() {

			@Override
			public int compare(Vertex o1, Vertex o2) {
				if (o1.getDistance() < o2.getDistance()) {
					return -1;
				} else {
					return 1;
				}
			}
		});

	}

	public void searchShortestPath(Vertex startPoint) {

		startPoint.setDistance(0);
		distanceQueue.add(startPoint);

		while (!distanceQueue.isEmpty()) {
			Vertex currentVertex = distanceQueue.poll();

			for (Edge edge : currentVertex.getAdjacencies()) {
				Vertex nextVertex = edge.getTargetVertex();
				double distance = currentVertex.getDistance() + edge.getWeight();

				if (distance < nextVertex.getDistance()) {
					nextVertex.setDistance(distance); 
					nextVertex.setPreviousVertex(currentVertex);
					distanceQueue.remove(nextVertex);
					distanceQueue.add(nextVertex);
				}
			}
		}

		printAllPath(startPoint);
		
	}
	
	private void printAllPath(Vertex startPoint){
		
		for (Vertex v : list) {
			System.out.print("From " + startPoint + " to " + v + " takes " + v.getDistance() + ": ");
			printPath(v);
			System.out.println("");
		}
		
	}
	
	private void printPath(Vertex v){
		
		if(v.getPreviousVertex() == null){
			System.out.print(v + " ");
			return;
		}
		
		printPath(v.getPreviousVertex());
		System.out.print(v + " ");
		
	}

}