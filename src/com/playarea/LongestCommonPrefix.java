/**
 * 
 */
package com.playarea;

/**
 * @author chandrashekharv
 *
 *         Write a function to find the longest common prefix string amongst an
 *         array of strings.
 * 
 *         If there is no common prefix, return an empty string "".
 * 
 *         Example 1:
 * 
 *         Input: ["flower","flow","flight"] Output: "fl" Example 2:
 * 
 *         Input: ["dog","racecar","car"] Output: "" Explanation: There is no
 *         common prefix among the input strings. Note:
 * 
 *         All given inputs are in lower case letters a-z.
 */
public class LongestCommonPrefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] sArray = { "abc", "abf", "a" };
		longestCommonPrefix(sArray);

	}

	private static void longestCommonPrefix(String[] sArray) {

		int length = Integer.MIN_VALUE;
		for (int i = 0; i < sArray.length; i++) {
			length = length == Integer.MIN_VALUE ? sArray[i].length() : Math.min(length, sArray[i].length());
		}
		if (length == 0) {
			System.out.println("");
			return;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < sArray.length; i++) {
			int count = 0;
			while (length > count) {
				if (i == 0) {
					builder.append(sArray[i].charAt(count));
					count++;
				} else if (builder.length() > count && builder.charAt(count) == sArray[i].charAt(count)) {
					count++;
					continue;
				} else {
					builder = new StringBuilder(builder.subSequence(0, count));
					count++;
					break;
				}
			}
		}

		System.out.println(builder.toString());

	}

}
