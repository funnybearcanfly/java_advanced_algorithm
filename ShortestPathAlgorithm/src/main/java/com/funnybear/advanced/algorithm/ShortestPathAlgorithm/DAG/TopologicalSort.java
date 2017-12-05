package com.funnybear.advanced.algorithm.ShortestPathAlgorithm.DAG;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Edge;
import com.funnybear.advanced.algorithm.ShortestPathAlgorithm.Common.Vertex;

public class TopologicalSort {

	private Stack<Vertex> stack;

	public TopologicalSort() {
		this.stack = new Stack<>();
	}

	public void makeTopologicalOrder(List<Vertex> vertexList) {

		for (Vertex vertex : vertexList) {
			if (!vertex.isVisited()) {
				dfs(vertex);
			}
		}

	}

	private void dfs(Vertex vertex) {

		for (Edge edge : vertex.getAdjacencies()) {
			Vertex target = edge.getTargetVertex();
			if (!target.isVisited()) {
				target.setVisited(true);
				dfs(target);
			}
		}

		this.stack.push(vertex);
	}

	public Stack<Vertex> getTopologicalOrder() {
		Collections.reverse(stack);
		return stack;
	}
}