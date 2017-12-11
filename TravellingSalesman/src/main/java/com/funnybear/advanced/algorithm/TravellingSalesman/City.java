package com.funnybear.advanced.algorithm.TravellingSalesman;

public class City {

	private int x;
	private int y;

	public City() {
		this.x = (int) (Math.random() * 100);
		this.y = (int) (Math.random() * 100);
	}

	public City(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public double distanceTo(City otherCity) {

		int xDistance = Math.abs(x - otherCity.getX());
		int yDistance = Math.abs(y - otherCity.getX());

		double distance = Math.sqrt(xDistance * xDistance + yDistance * yDistance);

		return distance;
		
	}

	@Override
	public String toString() {
		return this.x + " - " + this.y;
	}

}
