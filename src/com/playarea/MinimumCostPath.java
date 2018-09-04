/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class MinimumCostPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int r = 3;
		int c = 4;
		int[][] matrix = { { 1, 3, 5, 8 }, { 4, 2, 1, 7 }, { 4, 3, 2, 3 } };
		int element = 29;
		minCost(matrix, element, r, c);
	}

	private static void minCost(int[][] matrix, int element, int r, int c) {

		int temp[][] = new int[r][c];

		temp[0][0] = matrix[0][0];
		for (int i = 1; i < c; i++) {
			temp[0][i] = matrix[0][i] + temp[0][i - 1];
		}
		for (int i = 1; i < r; i++) {
			temp[i][0] = matrix[i][0] + temp[i - 1][0];
		}

		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				System.out.println("i:" + i + "j:" + j);
				temp[i][j] = matrix[i][j] + Math.min(temp[i][j - 1], temp[i - 1][j]);
			}
		}

		System.out.println(temp[r - 1][c - 1]);

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
	}

}
