package com.funnybear.advanced.algorithm.DepthFirstSearch.MapSolver;

public class MapSolver {

	private int[][] mazMap;
	private boolean[][] visited;
	private int startPositionRow;
	private int startPositionCol;

	public MapSolver(int[][] mazMap, int startPositionRow, int startPositionCol) {
		this.mazMap = mazMap;
		this.visited = new boolean[mazMap.length][mazMap.length];
		this.startPositionRow = startPositionRow;
		this.startPositionCol = startPositionCol;
	}

	public void findWayOut() {
		try {
			dfs(startPositionRow, startPositionCol);
			System.out.println("No solution found...");
		} catch (RuntimeException e) {
			System.out.println("Route found to exit!!!");
		}
	}

	private void dfs(int rowIndex, int colIndex) {

		System.out.println("Visiting i=" + rowIndex + ", j=" + colIndex);

		if (this.mazMap[rowIndex][colIndex] == 3) {
			throw new RuntimeException();
		}

		int endOfMap = this.mazMap.length - 1;

		if (visited[rowIndex][colIndex]) {
			return;
		} else if (rowIndex < 0 || rowIndex >= endOfMap) {
			return;
		} else if (colIndex < 0 || colIndex >= endOfMap) {
			return;
		} else if (this.mazMap[rowIndex][colIndex] == 1) {
			return;
		} else {

			this.visited[rowIndex][colIndex] = true;

			dfs(rowIndex + 1, colIndex);
			dfs(rowIndex - 1, colIndex);
			dfs(rowIndex, colIndex + 1);
			dfs(rowIndex, colIndex - 1);

		}

	}

}