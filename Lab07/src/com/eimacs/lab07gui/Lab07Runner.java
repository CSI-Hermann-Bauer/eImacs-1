package com.eimacs.lab07gui;

import com.eimacs.lab07.*;
import java.util.Collections;
import java.util.ArrayList;

/**
 *
 * @author IMACS Curriculum Development Group
 * @version 2.0 January 2015
 */
public class Lab07Runner {
	public static TestingInterface tester;
	/*
	 * Random number generator
	 * 
	 * @param n a positive integer
	 * 
	 * @return an integer chosen at random from 0 through n-1
	 */
	public static int random(int n) {
		return (int) (n * Math.random());
	}

	// Define the static method randomArrayList here
	public static ArrayList<Integer> randomArrayList(int n, int dir) {
		ArrayList<Integer> al = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			al.add(new Integer(random(1000)));
		}
		if (dir == -1)
			Collections.sort(al, Collections.reverseOrder());
		if (dir == 1)
			Collections.sort(al);
		return al;
	}

	// Define the static method arrayListOfArrayLists here
	public static ArrayList<ArrayList<Integer>> arrayListOfArrayLists(int m,
			int n, int dir) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			al.add(randomArrayList(n, dir));
		}
		return al;
	}

	public static void main(String[] args) {
		//tester = new TestingInterface();
		// final int NTESTS = 100;
		// final int ARRSIZE = 10000;

		// ArrayList<ArrayList<Integer>> a = arrayListOfArrayLists( NTESTS, ARRSIZE, -1 );
		// APTimer timer = new APTimer();
		// //Sort s = new SelectionSort();
		//  Sort s = new InsertionSort();
		//  //Sort s = new MergeSort();

		// timer.start();
		// for ( ArrayList<Integer> aList : a )
		// s.sortList( aList );
		// timer.stop();

		// System.out.println( "Average time to sort an ArrayList of size " + ARRSIZE +
		// 					": " + (timer.interval() / (double)NTESTS) + " ms." );
		ArrayList<String> arrList = new ArrayList<String>();
arrList.add("A");
arrList.add("B");
arrList.add("C");
arrList.add("D");
for (int i = 0; i < arrList.size(); i++)
{
System.out.print(arrList.remove(i));
}}}