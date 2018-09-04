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
		int r = 1;
		int c = 5;
		int[][] wall = new int[r][c];
		Random random = new Random();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				wall[i][j] = ((random.nextInt(100) % 3) == 0) ? 0 : 1;
				System.out.print(wall[i][j] + " ");
			}
			System.out.println();
		}
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
				}
				else if (r == 1 && !containsPorusBrickOnTopLayer) {
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
	}System.out.println("------TEMP ARRAY-------");for(

	int i = 0;i<r;i++)
	{
		for (int j = 0; j < c; j++) {

			System.out.print(temp[i][j] + " ");
		}
		System.out.println();
	}
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
