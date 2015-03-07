package com.eimacs.lab07;

import java.util.ArrayList;

/**
 *
 * @author |your name|
 * @version 1.0 |today's date|
 */
public class MergeSort2 extends Sort {
	public <T extends Comparable<T>> void sortList(ArrayList<T> arr) {
		mergeSort(arr, 0, arr.size() - 1);
	}

	public <T extends Comparable<T>> void mergeSort(ArrayList<T> a, int low,
			int high) {
		if (low >= high)
			return;

		int mid = (low + high) / 2;

		mergeSort(a, low, mid);
		mergeSort(a, mid + 1, high);

		merge(a, low, mid, high);
	}

	public static <T extends Comparable<T>> void merge(ArrayList<T> a, int low,
			int mid, int high) {
		int i = low, j = mid + 1;

		if (a.get(mid).compareTo(a.get(j)) <= 0)
			return;

		while (i <= mid && j <= high) {
			if (a.get(i).compareTo(a.get(j)) > 0) {
				a.add(i, a.remove(j));
				mid++;
				j++;
			}
			i++;
		}
	}
}
