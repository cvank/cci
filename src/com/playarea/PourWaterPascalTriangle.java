/**
 * 
 */
package com.playarea;

import java.util.Arrays;

/**
 * @author chandrashekharv
 *
 *
 *         There is a stack of water glasses in a form of pascal triangle and a
 *         person wants to pour the water at the topmost glass, but the capacity
 *         of each glass is 1 unit . Overflow takes place in such a way that
 *         after 1 unit, 1/2 of remaining unit gets into bottom left glass and
 *         other half in bottom right glass.
 * 
 *         Now the pours K units of water in the topmost glass and wants to know
 *         how much water is there in the jth glass of the ith row.
 * 
 *         Assume that there are enough glasses in the triangle till no glass
 *         overflows.
 * 
 *         Input: First line of the input contains an integer T denoting the
 *         number of test cases and each test case consists of three lines.
 *         First line contain an integer K, second line contains an integer i
 *         and third line contains an integer j.
 * 
 * 
 *         Output: Corresponding to each test case output the remaining amount
 *         of water in jth cup of the ith row correct to 6 decimal places.
 * 
 * 
 *         Constraints:
 * 
 *         T<=20 K<=1000 i <= K j<= K
 * 
 *         Example: Input:
 * 
 *         1 3 2 1
 * 
 *         Output: 1
 */
public class PourWaterPascalTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int k = 100; // No.Of units of water
		int i = 20; // Row
		int j = 10; // position of the glass
		double[][] levelArray = new double[k][];

		// Define as below
		// 0
		// 0 0
		// 0 0 0
		for (int level = 0; level <= i; level++) {
			levelArray[level] = new double[level + 1];

			for (int index = 0; index < levelArray[level].length; index++) {
				levelArray[level][index] = 0;
			}
		}

		// pour Water
		levelArray[0][0] = 1;
		k--;
		while (k > 0) {
			pourWater(0, 0, levelArray, 1); // level, total bucket container, units of water to start with
			k--;
		}

		System.out.println("Bucket :" + levelArray[i - 1][j - 1]);
		Arrays.stream(levelArray).flatMapToDouble(row -> Arrays.stream(row)).forEach(System.out::println);

	}

	private static void pourWater(int level, int node, double[][] levelArray, double noOfUnits) {

		if (noOfUnits == 0)
			return;

		if (levelArray[level][node] < 1) {
			double alreadyHolds = levelArray[level][node];
			double remainingTofill = 1 - alreadyHolds;
			if (noOfUnits >= remainingTofill) {
				levelArray[level][node] += remainingTofill;
				noOfUnits = noOfUnits - remainingTofill;
			} else {
				levelArray[level][node] += noOfUnits;
				noOfUnits = 0;
				return;
			}

		}

		if (levelArray[level][node] == 1) {
			pourWater(level + 1, node, levelArray, noOfUnits / 2);
			pourWater(level + 1, node + 1, levelArray, noOfUnits / 2);
		}
	}

}
