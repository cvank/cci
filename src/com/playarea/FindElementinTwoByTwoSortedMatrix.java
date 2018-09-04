/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class FindElementinTwoByTwoSortedMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int r = 4;
		int c = 4;
		int[][] matrix = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		int element = 29;
		findElementFromTopRight(matrix, element, r, c);
		findElementFromTopLeft(matrix, element, r, c);

	}

	private static boolean findElementFromTopLeft(int[][] matrix, int element, int r, int c) {
		for (int i = 0, j = 0; i < r && j < c;)
			if (matrix[i][j] == element) {
				System.out.println("Index - left:" + i + " " + j);
				return true;
			} else if (matrix[i][j] < element) {
				j++;
			} else {
				j--;
				i++;
			}

		return false;
	}

	private static boolean findElementFromTopRight(int[][] matrix, int element, int r, int c) {
		
		for (int i = 0, j = c - 1; i < r && j >= 0;)
			if (matrix[i][j] == element) {
				System.out.println("Index:" + i + " " + j);
				return true;
			} else if (matrix[i][j] < element) {
				i++;
			} else
				j--;

		return false;
	}

}
