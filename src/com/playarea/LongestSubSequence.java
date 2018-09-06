/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 */
public class LongestSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Input Strings
		String s1 = "ABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMN";
		String s2 = "JKABCDHIJKLANABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFJKABCDHIJKLANABCDEFABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMNABCDEFGHIJKLMN";

		// Initialize
		int[][] t = new int[s1.length() + 1][s2.length() + 1];
		init(s1, s2, t);

		// Process
		compareAndFillDynamicTable(s1, s2, t);
		System.out.println("Max length of common sub sequence: " + t[s1.length()][s2.length()]);

		// Backtracking
		printViaBacktracking(s1, s2, t);
	}

	private static void compareAndFillDynamicTable(String s1, String s2, int[][] t) {
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					t[i][j] = t[i - 1][j - 1] + 1;
				else
					t[i][j] = Math.max(Math.max(t[i - 1][j - 1], t[i - 1][j]), t[i][j - 1]);

			}
		}
	}

	private static void init(String s1, String s2, int[][] t) {
		for (int i = 0; i <= s1.length(); i++) {
			t[i][0] = 0;
		}
		for (int j = 0; j <= s2.length(); j++) {
			t[0][j] = 0;
		}
	}

	private static void printViaBacktracking(String s1, String s2, int[][] t) {
		StringBuilder builder = new StringBuilder();
		for (int i = t.length - 1, j = t[0].length - 1; i > 0 && j > 0;) {
			if (t[i][j] == t[i - 1][j - 1] + 1 && s2.charAt(j - 1) == s1.charAt(i - 1)) {
				builder.insert(0, s2.charAt(j - 1));
				i = i - 1;
				j = j - 1;
			} else if (t[i - 1][j] > t[i][j - 1]) {
				i = i - 1;
			} else {
				j = j - 1;
			}

		}

		System.out.println("Longest Sub-Sequence: " + builder);
	}
}
