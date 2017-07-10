package com.subhjit.test;

import java.util.ArrayList;
import java.util.Collections;

public class ComparableUsingList {

	public static void main(String[] args) {
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		movieList.add(new Movie("DDLJ", 5.0, 1995));
		movieList.add(new Movie("KKKG", 3.0, 2001));
		movieList.add(new Movie("KNPH", 4.0, 2000));
		movieList.add(new Movie("HSSA", 2.0, 1990));
		movieList.add(new Movie("DIWAR", 5.0, 1975));
		Collections.sort(movieList);
		System.out.println("Movie after Sorting");
		for (Movie mv : movieList) {
			System.out.println(mv.getName() + " " + mv.getRating() + " " + mv.getYear());
		}
	}

}

class Movie implements Comparable<Movie> {

	private double rating;
	private String name;
	private int year;

	public Movie(String nm, double rt, int yr) {
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

	@Override
	public int compareTo(Movie m) {
		// TODO Auto-generated method stub
		//return this.year - m.year;
		//return (int) (this.rating-m.rating);
		return this.name.compareTo(m.name);
	}

}