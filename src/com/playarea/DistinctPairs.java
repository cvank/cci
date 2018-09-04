/**
 * 
 */
package com.playarea;

import java.util.Arrays;

/**
 * @author chandrashekharv
 *
 */
public class DistinctPairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 3, 46, 1, 3, 9 };
		System.out.println(numberOfPairs(a, 47));

	}

	static int numberOfPairs(int[] a, long k) {

		// Sort Array
		// For each element find the k-element using binary search and add the pair to a
		// set
		// increment count

		Arrays.sort(a);
		int count = 0;
		int prev = Integer.MIN_VALUE;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > k) {
				break;
			} else if (prev == a[i])
				continue;

			else {

				if (k - a[i] > Math.pow(2, 31)) {
					break;
				}
				int diff = (int) k - a[i];
				int foundIndex = -1;

				foundIndex = Arrays.binarySearch(a, i + 1, a.length, diff);

				if (foundIndex > 0)
					count++;

				prev = a[i];
			}
		}

		return count;
	}

}
