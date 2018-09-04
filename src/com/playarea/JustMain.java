/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class JustMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Even and odd
		for (int i = 1; i < 10; i++)
			System.out.println(i + ": " + (((i >> 1) * 2) == i));
		
		for (int i = 1; i < 10; i++)
			System.out.println(i + ": " + (i%2 == 0));

	}

}
