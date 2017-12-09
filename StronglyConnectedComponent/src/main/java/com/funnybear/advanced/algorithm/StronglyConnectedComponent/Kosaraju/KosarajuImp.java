package com.funnybear.advanced.algorithm.StronglyConnectedComponent.Kosaraju;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KosarajuImp {

	private List<Vertex> vertexList;
	private Stack<Vertex> forwardDFSStack;
	private List<List<Vertex>> sscList;

	public KosarajuImp(List<Vertex> vertexList) {
		this.vertexList = vertexList;
		this.forwardDFSStack = new Stack<>();
		this.sscList = new ArrayList<>();
	}

	public void findSSC() {

		for (Vertex vertex : vertexList) {
			if (!vertex.isForwardVisited()) {
				forwardDFS(vertex);
			}
		}

		while (!forwardDFSStack.isEmpty()) {

			List<Vertex> ssc = new ArrayList<>();
			Vertex vertex = forwardDFSStack.pop();
			if (!vertex.isBackwardVisited()) {
				backwordDFS(vertex, ssc);
				this.sscList.add(ssc);
			}

		}

		printAllSSC();

	}

	private void forwardDFS(Vertex vertex) {

		vertex.setForwardVisited(true);

		for (Edge edge : vertex.getForwardAdjacencies()) {

			Vertex target = edge.getTargetVertex();

			if (!target.isForwardVisited()) {
				forwardDFS(target);
			}

		}

		this.forwardDFSStack.push(vertex);

	}

	private void backwordDFS(Vertex vertex, List<Vertex> ssc) {

		vertex.setBackwardVisited(true);
		ssc.add(vertex);

		for (Edge edge : vertex.getBackwardAdjacencies()) {
			
			Vertex target = edge.getTargetVertex();
			
			if(!target.isBackwardVisited()){
				backwordDFS(target, ssc);
			}
			
		}

	}

	private void printAllSSC() {
		
		System.out.println("Found " + this.sscList.size() + " Strongly Connected Components...");
		System.out.println(this.sscList);
		
	}

}
