/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv T
 * 
 *         There are two sorted arrays nums1 and nums2 of size m and n
 *         respectively.
 * 
 *         Find the median of the two sorted arrays. The overall run time
 *         complexity should be O(log (m+n)).
 * 
 *         Example 1: nums1 = [1, 3] nums2 = [2]
 * 
 *         The median is 2.0 Example 2: nums1 = [1, 2] nums2 = [3, 4]
 * 
 *         The median is (2 + 3)/2 = 2.5
 *
 */
public class MedianTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 1 };
		int b[] = { 1, 1 };
		medianOptimized(a, b);

	}

	private static void median(int[] a, int[] b) {
		int result[] = new int[a.length + b.length];
		int index = 0;
		int i = 0, j = 0;
		double median = 0.0;
		for (; i < a.length && j < b.length;) {
			if (a[i] == b[j]) {
				result[index++] = a[i++];
				result[index++] = b[j++];
			} else if (a[i] > b[j]) {
				result[index++] = b[j++];
			} else if (b[j] > a[i]) {
				result[index++] = a[i++];
			}
		}
		while (i < a.length) {
			result[index++] = a[i++];
		}
		while (j < b.length) {
			result[index++] = b[j++];
		}

		for (int k = 0; k < result.length; k++)
			System.out.print(result[k] + " , ");

		if (result.length % 2 != 0)
			median = result[result.length / 2];
		else {
			System.out.println("Calculating median of :" + (result[(result.length / 2)]));
			System.out.println("Calculating median of :" + (result[(result.length / 2) - 1]));
			median = (double) ((result[(result.length / 2)]) + (result[(result.length / 2) - 1])) / 2;
		}

		System.out.println("Median:" + median);
	}

	private static void medianOptimized(int[] a, int[] b) {

		int runCount = ((a.length + b.length) / 2) + 1;
		int result[] = new int[runCount];
		int index = 0;
		int i = 0, j = 0;
		double median = 0.0;
		for (; i < a.length && j < b.length && index < runCount;) {
			if (a[i] == b[j]) {
				if (index < runCount)
					result[index++] = a[i++];
				if (index < runCount)
					result[index++] = b[j++];
			} else if (a[i] > b[j]) {
				if (index < runCount)
					result[index++] = b[j++];
			} else if (b[j] > a[i]) {
				if (index < runCount)
					result[index++] = a[i++];
			}
		}
		while (i < a.length && index < runCount) {
			result[index++] = a[i++];
		}
		while (j < b.length && index < runCount) {
			result[index++] = b[j++];
		}

		for (int k = 0; k < result.length; k++)
			System.out.print(result[k] + " , ");

		if ((a.length + b.length) % 2 != 0)
			median = result[result.length - 1];
		else {
			System.out.println("Calculating median of :" + (result[result.length - 1]));
			System.out.println("Calculating median of :" + (result[result.length - 2]));
			median = (double) ((result[result.length - 1]) + (result[result.length - 2])) / 2;
		}

		System.out.println("Median:" + median);
	}

}
