/**
 * 
 */
package com.playarea;

import java.util.Random;

/**
 * @author chandrashekharv
 * 
 *         Given a wall, which is made up of two types of bricks (Porus / opaque
 *         ). Porus bricks allow water pass through them. Opaque won't. Find
 *         whether water reaches to ground, if there is any rainfall. Water can
 *         flow from top to bottom, diagonally, horizontally as well. Only
 *         flowing from bottom to top is not possible.
 *
 */
public class TwoBricksWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// prous as 1 and opaque as 0
		int r = 3;
		int c = 4;
		int[][] wall = new int[r][c];
		Random random = new Random();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				wall[i][j] = ((random.nextInt(100) % 3) == 0) ? 0 : 1;
				System.out.print(wall[i][j] + " ");
			}
			System.out.println();
		}
		apply(wall); // Latest
		/*
		 * wall[0] = new int[] { 0, 0, 1 }; wall[1] = new int[] { 0, 0, 1 }; wall[2] =
		 * new int[] { 1, 1, 1 };
		 * 
		 * 
		 * for (int i = 0; i < r; i++) { for (int j = 0; j < c; j++) {
		 * System.out.print(wall[i][j] + " "); } System.out.println(); }
		 */
		int temp[][] = new int[r][c];
		boolean containsPorusBrickOnTopLayer = false;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i == 0) {
					temp[i][j] = wall[i][j];
					containsPorusBrickOnTopLayer = containsPorusBrickOnTopLayer || temp[i][j] == 1;
				}
				if (r == 1 && containsPorusBrickOnTopLayer) {
					System.out.println("WATER FLOWS THROUGH THE WALL");
				} else if (r == 1 && !containsPorusBrickOnTopLayer) {
					System.out.println("WATER DOESN'T FLOWS THROUGH THE WALL");
					break;
				}

				if (i > 0) {
					temp[i][j] = get0OR1(temp, i, j, wall, r, c);
					if (i == r - 1 && j <= c - 1) {
						if (temp[i][j] == 1) {
							System.out.println("WATER FLOWS THROUGH THE WALL");
							break;
						}
					}
				}
			}
		}
		System.out.println("------TEMP ARRAY-------");

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {

				System.out.print(temp[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void apply(int[][] wall) {

		// Take temp array with [row+1][col+1]
		int t[][] = new int[wall.length + 1][wall[0].length + 1];
		for (int i = 0; i < t[0].length; i++) {
			t[0][i] = 1; // all row 1 values are 1
		}
		for (int i = 0; i < t.length; i++) {
			t[i][0] = 1; // All col one values are 1
		}
		
		for (int i = 1; i < t.length; i++) {
			for (int j = 1; j < t[0].length; j++) {
				if (wall[i - 1][j - 1] == 0) // if opaque put 0 and continue;
					t[i][j] = 0;
				else { // if porus
					if ((i - 1 >= 0 && j - 1 >= 0 && t[i - 1][j - 1] == 1) || // diagonal value is porus
						(i - 1 >= 0 && t[i - 1][j] == 1) || // right above row brick
						(j - 1 >= 0 && t[i][j - 1] == 1) || // horizontal left brick
						(j + 1 < t[0].length && i - 1 >= 0 && t[i - 1][j + 1] == 1)) // right diagonal brick
						t[i][j] = 1;
				}
			}

		}

		boolean flows = false;
		for (int i = t.length - 1, j = 1; j < t[0].length; j++) {
			if (t[i][j] == 1) {
				flows = true;
				break;
			}
		}
		if (flows)
			System.out.println("Water flows... HURRAY!!!");

	}

	private static int get0OR1(int[][] temp, int currentRow, int currentColumn, int[][] wall, int r, int c) {
		if (wall[currentRow][currentColumn] == 0)
			return 0;

		if (currentColumn == 0) {
			if ((currentColumn + 1 < c && temp[currentRow - 1][currentColumn + 1] == 1)
					|| temp[currentRow - 1][currentColumn] == 1)
				return 1;
		} else if (currentColumn == c - 1) {
			if (temp[currentRow - 1][currentColumn] == 1 || temp[currentRow][currentColumn - 1] == 1
					|| temp[currentRow - 1][currentColumn - 1] == 1)
				return 1;
		} else {
			if (temp[currentRow - 1][currentColumn] == 1 || temp[currentRow][currentColumn - 1] == 1
					|| temp[currentRow - 1][currentColumn - 1] == 1 || temp[currentRow - 1][currentColumn + 1] == 1)
				return 1;
		}

		return 0;
	}

}
