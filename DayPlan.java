package com.bean;

import java.util.ArrayList;

public class DayPlan {
	
	private ArrayList<Attraction> attractions;
	
	public ArrayList<Attraction> getAttractions() {
		return attractions;
	}

	public void setAttractions(ArrayList<Attraction> attractions) {
		this.attractions = attractions;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	private int count;

}
