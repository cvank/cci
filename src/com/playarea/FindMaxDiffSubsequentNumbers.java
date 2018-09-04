/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class FindMaxDiffSubsequentNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 1, 5, 6, 7, 18, 59, 50, 1, 5, 6, 7, 18, 59, 50, 1, 5, 6, 7, 18, 59, 50, 1, 5, 6, 7, 18, 59, 50, 1,
				5, 6, 7, 18, 59, 0 };
		System.out.println(findMaxDiff(a));

	}

	private static int findMaxDiff(int[] a) {
		if (a.length == 0)
			return 0;
		if (a.length == 1)
			return a[0];

		int maxDiff = 0;

		int prev = a[0];
		for (int i = 1; i < a.length; i++) {
			maxDiff = maxDiff > Math.abs(prev - a[i]) ? maxDiff : Math.abs(prev - a[i]);
			prev = a[i];
		}
		return maxDiff;
	}

}
