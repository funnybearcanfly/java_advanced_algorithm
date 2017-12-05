package com.funnybear.advanced.algorithm.DepthFirstSearch.CycleDetection;

import java.util.List;

import com.funnybear.advanced.algorithm.DepthFirstSearch.Common.Vertex;

public class CycleDetector {
	
	public void detect(List<Vertex> list) {

		for (Vertex v : list) {

			if (!v.isVisited()) {
				dfs(v);
			}

		}

	}

	private void dfs(Vertex vertex) {

		System.out.println("DFS on vertex " + vertex);
		vertex.setVisited(false);
		vertex.setBeingVisited(true);

		for (Vertex v : vertex.getNeighbourList()) {

			System.out.println("Visiting neighbours of vertex " + v);

			if (v.isBeingVisited()) {
				System.out.println("There is a backward edge: so there is a cycle!!!");
				vertex.setVisited(true);
				// 重要： 此处必须是continue不能是return, 否则如果起始点是两个共享环的第一个出点，会有一个环不能被发现。
				continue;
			}

			if (!v.isVisited()) {
				System.out.println("Visiting vertex " + v + " recursively");
				dfs(v);
			}

		}

		System.out.println("Set vertex " + vertex + " being visted false and visited true");
		vertex.setBeingVisited(false);
		vertex.setVisited(true);

	}

}