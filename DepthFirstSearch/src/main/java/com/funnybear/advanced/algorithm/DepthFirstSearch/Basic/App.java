package com.funnybear.advanced.algorithm.DepthFirstSearch.Basic;

import java.util.ArrayList;
import java.util.List;

import com.funnybear.advanced.algorithm.DepthFirstSearch.Common.Vertex;

public class App {

	public static void main(String[] args) {

		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);
		Vertex v6 = new Vertex(6);
		Vertex v7 = new Vertex(7);
		Vertex v8 = new Vertex(8);
		
		v2.addNeighbourVertex(v1);
		v2.addNeighbourVertex(v3);
		v3.addNeighbourVertex(v4);
		v4.addNeighbourVertex(v5);
		v4.addNeighbourVertex(v6);
		v7.addNeighbourVertex(v8);
		
		List<Vertex> list = new ArrayList<Vertex>();

		list.add(v6);
		list.add(v3);
		list.add(v1);
		list.add(v2);
		list.add(v4);
		list.add(v5);
		
		list.add(v7);
		list.add(v8);
		
		DFS dfs = new DFS();
		
		System.out.println("DSF with for stack...");
		dfs.search(list);
		
		System.out.println("DSF with stack...");
		dfs.dfsWithStack(v2);
		
		System.out.println("DSF with recursion...");
		dfs.dfsWithRecursion(v2);
		
	}

}