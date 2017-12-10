package com.funnybear.advanced.algorithm.StronglyConnectedComponent.Tarjan;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		Vertex v6 = new Vertex("6");
		Vertex v7 = new Vertex("7");
		Vertex v8 = new Vertex("8");

		v1.getNeighbourList().add(v2);
		v2.getNeighbourList().add(v4);
		v3.getNeighbourList().add(v2);
		v4.getNeighbourList().add(v3);
		v4.getNeighbourList().add(v5);
		v5.getNeighbourList().add(v6);
		v6.getNeighbourList().add(v7);
		v7.getNeighbourList().add(v8);
		v8.getNeighbourList().add(v5);

		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(v1);
		vertexList.add(v2);
		vertexList.add(v3);
		vertexList.add(v4);
		vertexList.add(v5);
		vertexList.add(v6);
		vertexList.add(v7);
		vertexList.add(v8);
		
		TarjanImp tarjan = new TarjanImp(vertexList);
		tarjan.findSSC();
		tarjan.printSSC();
		
	}

}
