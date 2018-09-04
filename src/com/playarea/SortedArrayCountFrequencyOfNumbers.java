/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class SortedArrayCountFrequencyOfNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a[] = { 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 6, 7, 7, 7, 7, 8, 8 };
		int prev = a[0];
		int count = 1;
		for (int i = 1; i < a.length; i++) {
			if (prev < a[i]) {
				System.out.println(prev + ":" + count);
				prev = a[i];
				count = 1;
			} else
				count += 1;
		}
	}

}
