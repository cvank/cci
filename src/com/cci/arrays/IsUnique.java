/**
 * 
 */
package com.cci.arrays;

/**
 * @author chandrashekharv
 * 
 * Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?
 *
 */
public class IsUnique {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "bca";
		
		System.out.println(isStringWithUniqueChars(s));

	}

	private static boolean isStringWithUniqueChars(String s) {
		if(null == s || s.trim() == "")
			return false;
		s = s.toLowerCase();
		
		int[] indexArray = new int[26];
		for(int i=0; i< indexArray.length; i++)
			indexArray[i] = 0;
		
		int ascii = (int)'a';
		for(int i=0; i<s.length(); i++) {
			if(indexArray[(int)s.charAt(i)-ascii] == 0)
				indexArray[(int)s.charAt(i)-ascii] = 1;
			else
				return false;
			
		}
		
		return true;
	}

}
