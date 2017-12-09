package com.funnybear.advanced.algorithm.StronglyConnectedComponent.Kosaraju;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args){
		
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		Vertex v7 = new Vertex("7");
		Vertex v8 = new Vertex("8");
		
		v1.addForwardEdge(new Edge(v1, v2));
		v2.addForwardEdge(new Edge(v2, v4));
		v3.addForwardEdge(new Edge(v3, v2));
		v4.addForwardEdge(new Edge(v4, v3));
		v4.addForwardEdge(new Edge(v4, v5));
		v5.addForwardEdge(new Edge(v5, v6));
		v6.addForwardEdge(new Edge(v6, v7));
		v7.addForwardEdge(new Edge(v7, v8));
		v8.addForwardEdge(new Edge(v8, v5));

		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		vertexList.add(v4);
		vertexList.add(v5);
		vertexList.add(v6);
		vertexList.add(v7);
		vertexList.add(v8);
		
		KosarajuImp kosaraju = new KosarajuImp(vertexList);
		kosaraju.findSSC();
		
	}
		
}
