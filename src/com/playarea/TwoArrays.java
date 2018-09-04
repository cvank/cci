/**
 * 
 */
package com.playarea;

import java.util.Arrays;

/**
 * @author chandrashekharv
 *
 */
public class TwoArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int nums[] = { 2, 10, 5, 4, 8 };
		int maxes[] = { 3, 1, 7, 8 };

		Arrays.stream(counts(nums, maxes)).forEach(System.out::println);
	}

	/**
	 * @param nums
	 * @param maxes
	 * @return
	 */
	static int[] counts(int[] nums, int[] maxes) {
		Arrays.sort(nums);

		int i = 0;
		int j = 0;
		int[] result = new int[maxes.length];
		while (j < maxes.length && i < nums.length) {
			if (maxes[j] >= nums[i])
				i++;
			else {
				result[j] = i;
				j++;
			}
		}
		result[j] = i;

		return result;

	}

}
