package com.funnybear.advanced.algorithm.DepthFirstSearch.MapSolver;

public class App {
	
	public static void main(String[] args) {

		FileReader fileReader = new FileReader("path to the map file", 5, 5);
		fileReader.parseFile();
		MapSolver solver = new MapSolver(fileReader.getMap(), fileReader.getStartPositionRow(), fileReader.getStartPositionCol());
		solver.findWayOut();
		
	}
	
}
