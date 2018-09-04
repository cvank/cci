/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class StringCountingSort {

	public static void main(String[] args) {

		String s = "In Programming Pearls Bentley says that the analogous line \"sets m to the average of l and u, truncated down to the nearest integer.\" On the face of it, this assertion might appear correct, but it fails for large values of the int variables low and high. Specifically, it fails if the sum of low and high is greater than the maximum positive int value (231 - 1). The sum overflows to a negative value, and the value stays negative when divided by two. In C this causes an array index out of bounds with unpredictable results. In Java, it throws ArrayIndexOutOfBoundsException.\n"
				+ "\n"
				+ "This bug can manifest itself for arrays whose length (in elements) is 230 or greater (roughly a billion elements). This was inconceivable back in the '80s, when Programming Pearls was written, but it is common these days at Google and other places. In Programming Pearls, Bentley says \"While the first binary search was published in 1946, the first binary search that works correctly for all values of n did not appear until 1962.\" The truth is, very few correct versions have ever been published, at least in mainstream programming languages.";

		// Counting sort

		int[] asciiArray = new int[256];

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue;
			}
			System.out.println(s.charAt(i) + ": " + (int) s.charAt(i));

			asciiArray[(int) s.charAt(i)] += 1;
			System.out.println("asciiArray[(int) s.charAt(i)]: " + asciiArray[(int) s.charAt(i)]);
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < asciiArray.length; i++) {
			if (asciiArray[i] > 0)
				for (int j = 0; j < asciiArray[i]; j++)
					builder.append((char) i);
		}
		System.out.println(builder);
	}

}
