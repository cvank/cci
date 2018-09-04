/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class MergeTwoSortedArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int b[] = { -1, -2, -3 };

		int result[] = new int[a.length + b.length];
		int index = 0;
		int i = 0, j = 0;
		for (; i < a.length && j < b.length;) {
			if (a[i] == b[j]) {
				result[index++] = a[i++];
				result[index++] = b[j++];
			} else if (a[i] > b[j]) {
				result[index++] = b[j++];
			} else {
				result[index++] = a[i++];
			}

		}

		while (i < a.length)
			result[index++] = a[i++];
		while (j < b.length)
			result[index++] = b[j++];

		for (int k = 0; k < result.length; k++)
			System.out.println(result[k]);
	}

}
