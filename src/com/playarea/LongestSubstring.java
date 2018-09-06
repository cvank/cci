/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class LongestSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s1 = "ABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMN";
		String s2 = "JKABCDHIJKLANABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEF";

		longestSubStringApproach1(s1, s2);
		longestSubStringApproach2(s1, s2);

	}

	private static void longestSubStringApproach2(String s1, String s2) {
		int[][] t = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			t[i][0] = 0;
		}
		for (int j = 0; j <= s2.length(); j++) {
			t[0][j] = 0;
		}

		for (int i = 1; i <= t.length - 1; i++) {
			for (int j = 1; j <= t[0].length - 1; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					t[i][j] = t[i - 1][j - 1] + 1;
				else
					t[i][j] = 0;
			}
		}

		
	}

	private static void longestSubStringApproach1(String s1, String s2) {
		int[][] t = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			t[i][0] = 0;
		}
		for (int j = 0; j <= s2.length(); j++) {
			t[0][j] = 0;
		}

		int max = Integer.MIN_VALUE;
		int maxI = Integer.MIN_VALUE;
		int maxJ = Integer.MIN_VALUE;
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					t[i][j] = t[i - 1][j - 1] + 1;
					if (max < t[i][j]) {
						max = t[i][j];
						maxI = i;
						maxJ = j;
					}

				} else
					t[i][j] = 0;
			}
		}

		System.out.println("Max substring length:" + max);
		StringBuilder builder = new StringBuilder();

		// Backtracking to print longest sub string
		for (int i = maxI, j = maxJ; i > 0 && j > 0 && t[i][j] != 0; i--, j--) {
			builder.insert(0, s2.charAt(j - 1));
		}
		System.out.println(builder);
	}

}
