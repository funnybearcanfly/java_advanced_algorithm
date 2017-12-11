package com.funnybear.advanced.algorithm.TravellingSalesman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SingleTour {

	private List<City> tour = new ArrayList<>();
	private double distance = 0;

	public SingleTour() {
		for (int i = 0; i < Repository.getNumberOfCities(); i++) {
			tour.add(null);
		}
	}

	public SingleTour(List<City> city) {

		List<City> currentTour = new ArrayList<>();

		for (int i = 0; i < city.size(); i++)
			currentTour.add(null);

		for (int i = 0; i < city.size(); i++)
			currentTour.set(i, city.get(i));

		tour = currentTour;

	}

	public double getDistance() {

		if (distance == 0) {
			
			int tourDistance = 0;
			
			for (int i = 0; i < getTourSize(); i++) {
				
				City fromCity = getCity(i);
				City destinationCity;

				if (i + 1 < getTourSize()) {
					destinationCity = getCity(i + 1);
				} else {
					destinationCity = getCity(0);
				}
				
				tourDistance += fromCity.distanceTo(destinationCity);
				
			}
			
			distance = tourDistance;
			
		}

		return distance;

	}

	public List<City> getTour() {
		return tour;
	}

	public void generateIndividual() {

		for (int i = 0; i < Repository.getNumberOfCities(); i++)
			setCity(i, Repository.getCity(i));

		Collections.shuffle(tour);

	}

	public void setCity(int index, City city) {
		tour.set(index, city);
		distance = 0;
	}

	public City getCity(int tourPosition) {
		return tour.get(tourPosition);
	}

	public int getTourSize() {
		return tour.size();
	}

	@Override
	public String toString() {

		String s = "";

		for (int i = 0; i < getTourSize(); i++) {
			s += getCity(i) + " -> ";
		}

		return s;

	}

}
