package com.subhjit.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorUsingList {

	public static void main(String[] args) {
		ArrayList<NewMovie> movieList = new ArrayList<NewMovie>();
		movieList.add(new NewMovie("DDLJ", 5.0, 1995));
		movieList.add(new NewMovie("KKKG", 3.0, 2001));
		movieList.add(new NewMovie("KNPH", 4.0, 2000));
		movieList.add(new NewMovie("HSSA", 2.0, 1990));
		movieList.add(new NewMovie("DIWAR", 5.0, 1975));
		Collections.sort(movieList, new SortByName());
		System.out.println("Movie after Sorting");
		for (NewMovie mv : movieList) {
			System.out.println(mv.getName() + " " + mv.getRating() + " " + mv.getYear());
		}

	}

}

class NewMovie {

	private double rating;
	private String name;
	private int year;

	public NewMovie(String nm, double rt, int yr) {
		this.name = nm;
		this.rating = rt;
		this.year = yr;

	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}

class SortByName implements Comparator<NewMovie> {
	@Override
	public int compare(NewMovie mv1, NewMovie mv2) {
		return mv1.getName().compareTo(mv2.getName());
	}

}
