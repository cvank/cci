/**
 * 
 */
package com.playarea;

import java.util.HashMap;

/**
 * @author chandrashekharv
 *
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = -2147483648;

		System.out.println(reverse(a));

	}

	private static int reverse(int a) {

		int reverse = 0;
		while (a != 0) {
			int digit = a % 10;
			a /= 10;

			if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE / 10 && digit > 7))
				return 0;
			if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MIN_VALUE / 10 && digit < -8))
				return 0;
			reverse = reverse * 10 + digit;
		}
		return reverse;
	}

}
