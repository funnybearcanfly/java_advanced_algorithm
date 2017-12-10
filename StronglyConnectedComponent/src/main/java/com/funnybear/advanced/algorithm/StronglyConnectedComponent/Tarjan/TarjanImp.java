package com.funnybear.advanced.algorithm.StronglyConnectedComponent.Tarjan;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TarjanImp {

	private Stack<Vertex> stack;
	private List<Vertex> vertexList;
	private List<List<Vertex>> sscList;
	private int time = 0;
	private int count = 0;

	public TarjanImp(List<Vertex> vertexList) {
		this.stack = new Stack<>();
		this.vertexList = vertexList;
		this.sscList = new ArrayList<>();
	}

	public void findSSC() {
		for (Vertex vertex : vertexList) {
			if (!vertex.isVisited()) {
				dfs(vertex);
			}
		}
	}

	private void dfs(Vertex vertex) {

		vertex.setLowLink(time++);
		vertex.setVisited(true);
		stack.add(vertex);
		boolean isComponentRoot = true;

		for (Vertex v : vertex.getNeighbourList()) {

			if (!v.isVisited()) {
				dfs(v);
			}

			if (vertex.getLowLink() > v.getLowLink()) {
				vertex.setLowLink(v.getLowLink());
				isComponentRoot = false;
			}

		}

		if (isComponentRoot) {

			count++;
			List<Vertex> component = new ArrayList<>();

			while (true) {

				Vertex actualVertex = stack.pop();
				component.add(actualVertex);
				actualVertex.setLowLink(Integer.MAX_VALUE);

				if (actualVertex.getName().equals(vertex.getName()))
					break;

			}

			sscList.add(component);

		}

	}

	public void printSSC() {
		System.out.println(sscList);
	}

}
