/**
 * 
 */
package com.playarea;

import java.util.Arrays;
import java.util.Random;

/**
 * @author chandrashekharv
 *
 */
public class SecondMinimumElementInArray {

	public static void main(String[] args) {
		int a[] = new int[10000];
		Random random = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = random.nextInt(1000000);
		}
		int min = Integer.MIN_VALUE;
		int secondMin = Integer.MIN_VALUE;

		min = a[0];
		secondMin = a[1];
		int temp = 0;
		if (min > secondMin) {
			temp = secondMin;
			secondMin = min;
			min = temp;

		}

		for (int i = 2; i < a.length; i++) {
			if (a[i] < min) {
				temp = min;
				min = a[i];
				secondMin = secondMin < temp ? secondMin : temp;
			} else if (a[i] < secondMin)
				secondMin = secondMin < a[i] ? secondMin : a[i];

		}
		System.out.println("Min: " + min + " Second Min:" + secondMin);
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " , ");
	}
}
