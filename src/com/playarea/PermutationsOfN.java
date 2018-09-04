/**
 * 
 */
package com.playarea;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chandrashekharv
 *
 */
public class PermutationsOfN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int n = 11;
		int a[] = new int[11];
		for (int i = 0; i < n; i++) {
			a[i] = i + 1;
		}
		PermutationsOfN n2 = new PermutationsOfN();
		n2.listPermutations(a);
	}

	public List<int[]> listPermutations(int[] a) {
		List<int[]> results = new ArrayList<int[]>();
		listPermutations(a, 0, results);
		return results;
	}

	private void listPermutations(int[] a, int start, List<int[]> result) {
		if (start >= a.length) {
			result.add(a.clone());
		} else {
			for (int i = start; i < a.length; i++) {
				swap(a, start, i);
				listPermutations(a, start + 1, result);
				swap(a, start, i);
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
