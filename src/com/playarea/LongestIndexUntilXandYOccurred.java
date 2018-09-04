/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class LongestIndexUntilXandYOccurred {

	public static void main(String[] args) {

		int a[] = { 10, 20, 1, 2, 3, 10, 5, 6, 7, 10, 4, 3, 5, 20, 4, 5, 20, 10, 11, 12 };

		int x = 10, y = 20;
		int nX = 0, nY = 0;
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x)
				nX++;
			if (a[i] == y)
				nY++;

			if (nX == nY && nX != 0 && nY != 0)
				result = i;
		}

		System.out.println(result);
	}
}
